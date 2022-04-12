package com.infernalWhaler.models;

/**
 * Transaction
 *
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

    /**
     * Get transaction name
     *
     * @return Object of String name
     */
    public String getName() {
        return name;
    }

    /**
     * Get transaction amount
     *
     * @return Object of Double amount
     */
    public Double getAmount() {
        return amount;
    }
}
