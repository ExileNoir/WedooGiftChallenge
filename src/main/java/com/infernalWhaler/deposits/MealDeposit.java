package com.infernalWhaler.deposits;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * @author sDeseure
 * @project challenge
 * @date 10/04/2022
 */

public class MealDeposit extends Deposit {

    public MealDeposit(String nameSender, Double amount, LocalDate distributionDate) {
        super(nameSender, amount, distributionDate, distributionDate
                .plusYears(1)
                .withMonth(2)
                .with(TemporalAdjusters.lastDayOfMonth()));
    }
}