package com.infernalWhaler.deposits;

import java.time.LocalDate;

/**
 * @author sDeseure
 * @project challenge
 * @date 10/04/2022
 */

public abstract class Deposit {W

    private String nameSender;
    private Double amount;
    private LocalDate distributionDate;
    private LocalDate expirationDate;


    Deposit(String nameSender, Double amount, LocalDate distributionDate, LocalDate expirationDate) {
        this.nameSender = nameSender;
        this.amount = amount;
        this.distributionDate = distributionDate;
        this.expirationDate = expirationDate;
    }

    public String getNameSender() {
        return nameSender;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDate getDistributionDate() {
        return distributionDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}
