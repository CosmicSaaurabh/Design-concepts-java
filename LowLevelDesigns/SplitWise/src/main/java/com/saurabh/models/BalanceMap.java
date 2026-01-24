package com.saurabh.models;

import java.util.Map;

public class BalanceMap {
    // for each user, what is his balance for an expense in a group/individual
    private final Map<User, Balance> userBalances;

    public BalanceMap(Map<User, Balance> userBalances) {
        this.userBalances = userBalances;
    }

    public Map<User, Balance> getBalances() {
        return userBalances;
    }
}
