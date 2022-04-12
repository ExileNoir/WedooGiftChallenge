package com.infernalWhaler.deposits;

import com.infernalWhaler.models.Transaction;

import java.time.LocalDate;

/**
 * Gift Deposit
 *
 * @author sDeseure
 * @project challenge
 * @date 10/04/2022
 * @see IDeposit
 * @see AbstractDeposit
 */

public class GiftDeposit extends AbstractDeposit {

    public GiftDeposit(Transaction transaction, LocalDate distributionDate) {
        super(transaction, distributionDate, distributionDate.plusDays(364));
    }
}
