package com.infernalWhaler.models;

/**
 * @author sDeseure
 * @project challenge
 * @date 10/04/2022
 */

public class Transaction {

    private final String name;
    private final Double amount;

    public Transaction(String name, Double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public Double getAmount() {
        return amount;
    }
}
