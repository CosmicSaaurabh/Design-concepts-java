package com.saurabh.services;

import com.saurabh.models.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupService {
    private final ExpenseService expenseService;
    private final Map<String, Group> groups;
    public GroupService(ExpenseService expenseService, Map<String, Group> groups) {
        this.expenseService = expenseService;
        this.groups = groups;
    }

    public void addExpenseToGroup(String groupId, Expense expense) {
        // Logic to add expense to a group
        expenseService.addExpense(expense);
        System.out.println("Expense added to group " + groupId);
    }

    public PaymentGraph getPaymentGraph(final String groupId, final String userId)  {
        // Logic to get payment graph for a group
//        System.out.println("Total expense for group " + groupId + " is " + resultExpense.getAmount());
        final BalanceMap balances = getBalance(groupId, userId);
        return expenseService.generatePaymentGraph(balances);
    }

    public BalanceMap getBalance(final String groupId, final String userId) {
        // Logic to get balance for a user in a group
        if (!groups.get(groupId).getUsers().contains(userId)) {
            throw new IllegalArgumentException("User " + userId + " is not a member of group " + groupId);
        }

        System.out.println("Calculating balance for user " + userId + " in group " + groupId);
        List<Expense> expenses = expenseService.getExpensesByGroup(groupId);
        // result expense will have a map for each user and their balance
        BalanceMap resultExpense = sumExpenses(expenses);

        return resultExpense;
    }

    private BalanceMap sumExpenses(List<Expense> expenses) {
        final Map<User, Balance> resultBalanceMap = new HashMap<>();
        for (Expense expense : expenses) {
            for (Map.Entry<User, Balance> balance: expense.getUserBalances().getBalances().entrySet()) {
                User user = balance.getKey();
                Balance bal = balance.getValue();
                resultBalanceMap.putIfAbsent(user, new Balance(0, "Dollar"));
                Balance existingBalance = resultBalanceMap.get(user);
                existingBalance.setAmount(existingBalance.getAmount() + bal.getAmount());
            }
        }

        return (BalanceMap) resultBalanceMap;
    }
}
