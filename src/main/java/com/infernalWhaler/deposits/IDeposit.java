package com.infernalWhaler.deposits;

import com.infernalWhaler.models.Transaction;

import java.time.LocalDate;

/**
 * Deposit Contract
 *
 * @author sDeseure
 * @project challenge
 * @date 10/04/2022
 */

public interface IDeposit {

    /**
     * Get transaction Object
     *
     * @return Transaction object
     */
    Transaction getTransaction();

    /**
     * Get distribution date
     *
     * @return LocalDate object of distribution
     */
    LocalDate getDistributionDate();

    /**
     * Get expiration date
     *
     * @return LocalDate object of expiration
     */
    LocalDate getExpirationDate();
}
