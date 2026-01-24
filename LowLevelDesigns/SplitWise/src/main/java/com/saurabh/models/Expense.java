package com.saurabh.models;

public class Expense {
    // with each entry in expense or each object of expense we will have a map of user to balance
    private final BalanceMap userBalances;
    private final double title;
    private final String description;

    public Expense(BalanceMap userBalances, double title, String description) {
        this.userBalances = userBalances;
        this.title = title;
        this.description = description;
    }


    public BalanceMap getUserBalances() {
        return userBalances;
    }
}
