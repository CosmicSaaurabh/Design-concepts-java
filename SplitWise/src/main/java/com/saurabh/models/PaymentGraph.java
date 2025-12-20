package com.saurabh.models;

import javax.swing.*;
import java.util.Map;

public class PaymentGraph {
    // Adjacency matrix representation of the payment graph
    // You can use a Map<User, Map<User, Balance>> to represent who owes whom and how much
    // For simplicity, let's assume a fixed number of users and use a 2D array
    // In a real-world scenario, you would likely use a more dynamic structure
    // private final Map<User, Map<User, Balance>> paymentGraph;
    private final Map<User, BalanceMap> paymentGraph;

    public PaymentGraph(Map<User, BalanceMap> paymentGraph) {
        this.paymentGraph = paymentGraph;
    }
}
