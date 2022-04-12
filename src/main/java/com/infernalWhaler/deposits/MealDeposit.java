package com.infernalWhaler.deposits;

import com.infernalWhaler.models.Transaction;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * Meal Deposit
 *
 * @author sDeseure
 * @project challenge
 * @date 10/04/2022
 * @see IDeposit
 * @see AbstractDeposit
 */

public class MealDeposit extends AbstractDeposit {

    public MealDeposit(Transaction transaction, LocalDate distributionDate) {
        super(transaction, distributionDate, distributionDate
                .plusYears(1)
                .withMonth(2)
                .with(TemporalAdjusters.lastDayOfMonth()));
    }
}