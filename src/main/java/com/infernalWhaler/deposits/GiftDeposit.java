package com.infernalWhaler.deposits;

import com.infernalWhaler.models.Transaction;

import java.time.LocalDate;

/**
 * @author sDeseure
 * @project challenge
 * @date 10/04/2022
 */

public class GiftDeposit extends AbstractDeposit {

    public GiftDeposit(Transaction transaction, LocalDate distributionDate) {
        super(transaction, distributionDate, distributionDate.plusDays(364));
    }
}
