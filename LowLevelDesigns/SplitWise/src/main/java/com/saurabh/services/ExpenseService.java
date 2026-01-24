package com.saurabh.services;
import com.saurabh.models.*;

import java.util.*;

public class ExpenseService {
    // select * from expenses where groupId = 'groupid';
    private final Map<String, List<Expense>> groupExpenses;

    public ExpenseService(Map<String, List<Expense>> groupExpenses) {
        this.groupExpenses = groupExpenses;
    }

    public List<Expense> getExpensesByGroup(String groupId) {
        return groupExpenses.get(groupId);
    }

    public void addExpense(Expense expense) {

    }

    public PaymentGraph generatePaymentGraph(BalanceMap balances) {
        final var graph = new HashMap<User, BalanceMap>();

        PriorityQueue<Map.Entry<User, Balance>> creditors =
                new PriorityQueue<>(Comparator.comparing(balance -> -balance.getValue().getAmount()));
        PriorityQueue<Map.Entry<User, Balance>> debitors =
                new PriorityQueue<>(Comparator.comparing(balance -> balance.getValue().getAmount()));

        for (var balanceEntry : balances.getBalances().entrySet()) {
            if (balanceEntry.getValue().getAmount() > 0) {
                creditors.add(balanceEntry);
            } else if (balanceEntry.getValue().getAmount() < 0) {
                debitors.add(balanceEntry);
            }
        }

        while (!creditors.isEmpty() && !debitors.isEmpty()) {
            // eliminate by polling heaps
            var largetPositiveValue = creditors.poll();
            var largestNegativeValue = debitors.poll();
            var positiveAmount = largetPositiveValue.getValue().getAmount();
            var negativeAmount = -largestNegativeValue.getValue().getAmount();
            graph.putIfAbsent(largetPositiveValue.getKey(), new BalanceMap(new HashMap<>()));
            graph.get(largetPositiveValue.getKey()).getBalances().put(largestNegativeValue.getKey(), new Balance(negativeAmount, "Dollar"));
            double remaining = positiveAmount - negativeAmount;
            if (remaining > 0) {
                // still positive amount left
                creditors.add(new AbstractMap.SimpleEntry<>(largetPositiveValue.getKey(), new Balance((int)remaining, "Dollar")));
            } else if (remaining < 0) {
                // still negative amount left
                debitors.add(new AbstractMap.SimpleEntry<>(largestNegativeValue.getKey(), new Balance((int)-remaining, "Dollar")));
            }

        }

        return new PaymentGraph(graph);
    }
}
