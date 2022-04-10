package com.infernalWhaler.deposits;

import java.time.LocalDate;

/**
 * @author sDeseure
 * @project challenge
 * @date 10/04/2022
 */

public class GiftDeposit extends Deposit {

    public GiftDeposit(String nameSender, Double amount, LocalDate distributionDate) {
        super(nameSender, amount, distributionDate, distributionDate.plusDays(364));
    }
}
