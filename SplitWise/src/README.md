To design a normalized PostgreSQL database for a Splitwise-like app with your provided models, you should create tables that follow Third Normal Form (3NF), ensuring each table contains only data directly related to its primary key and eliminating transitive dependencies. Here’s a step-by-step solution:[1][2][3]

### Step 1: Identify Entities and Relationships
Based on your models, the core entities are:
- User
- Group
- Expense
- Balance (for each user in an expense)
- PaymentGraph (can be derived from balances and expenses)

### Step 2: Create Tables in 3NF

#### Table: Users
Stores user information.
```sql
CREATE TABLE users (
    user_id VARCHAR(50) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    bio TEXT
);
```
Each user is uniquely identified by `user_id`, and all attributes depend directly on this key.[4]

#### Table: Groups
Stores group details.
```sql
CREATE TABLE groups (
    group_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    created_by VARCHAR(50) REFERENCES users(user_id)
);
```
`created_by` references the user who created the group.[4]

#### Table: Group Members
Tracks which users belong to which groups.
```sql
CREATE TABLE group_members (
    group_id INT REFERENCES groups(group_id),
    user_id VARCHAR(50) REFERENCES users(user_id),
    PRIMARY KEY (group_id, user_id)
);
```
This junction table avoids repeating group or user data and ensures no transitive dependencies.[4]

#### Table: Expenses
Stores expense details for each group.
```sql
CREATE TABLE expenses (
    expense_id SERIAL PRIMARY KEY,
    group_id INT REFERENCES groups(group_id),
    title VARCHAR(200) NOT NULL,
    description TEXT,
    created_by VARCHAR(50) REFERENCES users(user_id),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```
Each expense is tied to a group and creator, with all attributes depending directly on `expense_id`.[4]

#### Table: Expense Balances
Stores the balance (amount and currency) for each user in each expense.
```sql
CREATE TABLE expense_balances (
    expense_id INT REFERENCES expenses(expense_id),
    user_id VARCHAR(50) REFERENCES users(user_id),
    amount INT NOT NULL,
    currency VARCHAR(10) DEFAULT 'Dollar',
    PRIMARY KEY (expense_id, user_id)
);
```
This table ensures that balances are normalized and not repeated, with each entry directly tied to the expense and user.[4]

### Step 3: Payment Graph (Derived Table)
The payment graph can be computed at runtime from the balances. You don’t need a dedicated table; instead, use queries to generate who owes whom and how much, based on the `expense_balances` table.[5][4]

### Step 4: Normalization Checks
- Each table has a primary key.
- No repeating groups or multi-valued attributes (1NF).
- No partial dependencies (2NF).
- No transitive dependencies (3NF).

### Example Usage
- To get all expenses for a group, join `expenses` with `expense_balances` and `users`.
- To compute the payment graph, aggregate balances per user per group and use logic to determine payments.

This design ensures your database is scalable, maintainable, and adheres to best practices for relational data modeling.[2][3][4]



Here’s a PostgreSQL SQL query to get all expenses for a group, including the balance for each user in each expense. The query joins the `expenses`, `expense_balances`, and `users` tables.

### Example Table Data

**users**
| user_id | name    | bio        |
|---------|---------|------------|
| u1      | Alice   | Student    |
| u2      | Bob     | Engineer   |
| u3      | Charlie | Designer   |

**groups**
| group_id | name     | description |
|----------|----------|-------------|
| 1        | Trip     | Goa Trip    |

**expenses**
| expense_id | group_id | title       | description | created_by | created_at           |
|------------|----------|-------------|-------------|------------|----------------------|
| 101        | 1        | Hotel       | Hotel bill  | u1         | 2025-12-20 18:00:00  |
| 102        | 1        | Food        | Dinner      | u2         | 2025-12-20 19:00:00  |

**expense_balances**
| expense_id | user_id | amount | currency |
|------------|---------|--------|----------|
| 101        | u1      | 500    | Dollar   |
| 101        | u2      | -300   | Dollar   |
| 101        | u3      | -200   | Dollar   |
| 102        | u1      | -100   | Dollar   |
| 102        | u2      | 200    | Dollar   |
| 102        | u3      | -100   | Dollar   |

### SQL Query

```sql
SELECT 
    e.expense_id,
    e.title,
    e.description,
    e.created_by,
    e.created_at,
    eb.user_id,
    u.name,
    eb.amount,
    eb.currency
FROM expenses e
INNER JOIN expense_balances eb ON e.expense_id = eb.expense_id
INNER JOIN users u ON eb.user_id = u.user_id
WHERE e.group_id = 1
ORDER BY e.expense_id, eb.user_id;
```

### Output Example

| expense_id | title  | description | created_by | created_at           | user_id | name    | amount | currency |
|------------|--------|-------------|------------|----------------------|---------|---------|--------|----------|
| 101        | Hotel  | Hotel bill  | u1         | 2025-12-20 18:00:00  | u1      | Alice   | 500    | Dollar   |
| 101        | Hotel  | Hotel bill  | u1         | 2025-12-20 18:00:00  | u2      | Bob     | -300   | Dollar   |
| 101        | Hotel  | Hotel bill  | u1         | 2025-12-20 18:00:00  | u3      | Charlie | -200   | Dollar   |
| 102        | Food   | Dinner      | u2         | 2025-12-20 19:00:00  | u1      | Alice   | -100   | Dollar   |
| 102        | Food   | Dinner      | u2         | 2025-12-20 19:00:00  | u2      | Bob     | 200    | Dollar   |
| 102        | Food   | Dinner      | u2         | 2025-12-20 19:00:00  | u3      | Charlie | -100   | Dollar   |

This query gives you a complete list of all expenses in a group, with each user's balance for every expense, by joining the three tables and filtering by the group ID.



To update an expense, specifically the amount that users owe or are owed, you will need to update multiple rows in the `expense_balances` table because each user’s balance for that expense is stored in a separate row. Here’s how you can do it efficiently in PostgreSQL.[1][2]

### Step-by-Step Approach

1. **Identify the expense and the users whose balances need updating.**
2. **Use a single `UPDATE` statement with a `CASE` expression to update multiple rows at once.**

### Example SQL Query

Suppose you want to update the balances for users in expense 101:
- User u1 now owes 600 (instead of 500)
- User u2 now owes -400 (instead of -300)
- User u3 now owes -200 (unchanged)

```sql
UPDATE expense_balances
SET amount = CASE
    WHEN user_id = 'u1' THEN 600
    WHEN user_id = 'u2' THEN -400
    WHEN user_id = 'u3' THEN -200
END
WHERE expense_id = 101
  AND user_id IN ('u1', 'u2', 'u3');
```

### Key Points

- This query updates the balance for each specified user in one transaction, ensuring data consistency.[2][1]
- You can include as many `WHEN` clauses as needed for the users involved in the expense.
- The `WHERE` clause ensures only the relevant rows are updated.

### Best Practices

- Always wrap such updates in a transaction to maintain consistency, especially if multiple related tables need updating.
- Validate the input data before executing the update to avoid unintended changes.[3]
- Use constraints and triggers to enforce business rules, such as ensuring the total balance for an expense remains zero (if applicable).

This approach allows you to update multiple user balances for a single expense efficiently and safely in PostgreSQL.[1][2][3]