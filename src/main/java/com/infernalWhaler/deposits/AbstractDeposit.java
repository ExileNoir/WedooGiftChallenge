package com.infernalWhaler.deposits;

import com.infernalWhaler.models.Transaction;

import java.time.LocalDate;

/**
 * Default Deposit
 *
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

    /**
     * Get transaction Object
     *
     * @return Transaction object
     * @see IDeposit#getTransaction()
     */
    @Override
    public Transaction getTransaction() {
        return transaction;
    }

    /**
     * Get distribution date
     *
     * @return LocalDate object of distribution
     * @see IDeposit#getDistributionDate()
     */
    @Override
    public LocalDate getDistributionDate() {
        return distributionDate;
    }

    /**
     * Get expiration date
     *
     * @return LocalDate object of expiration
     * @see IDeposit#getExpirationDate()
     */
    @Override
    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}
