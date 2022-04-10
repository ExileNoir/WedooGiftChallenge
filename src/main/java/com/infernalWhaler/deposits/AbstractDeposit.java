package com.infernalWhaler.deposits;

import com.infernalWhaler.models.Transaction;

import java.time.LocalDate;

/**
 * @author sDeseure
 * @project challenge
 * @date 10/04/2022
 */

abstract class AbstractDeposit implements IDeposit {

    private final Transaction transaction;
    private final LocalDate distributionDate;
    private final LocalDate expirationDate;


    protected AbstractDeposit(Transaction transaction, LocalDate distributionDate, LocalDate expirationDate) {
        this.transaction = transaction;
        this.distributionDate = distributionDate;
        this.expirationDate = expirationDate;
    }

    @Override
    public Transaction getTransaction() {
        return transaction;
    }

    @Override
    public LocalDate getDistributionDate() {
        return distributionDate;
    }

    @Override
    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}
