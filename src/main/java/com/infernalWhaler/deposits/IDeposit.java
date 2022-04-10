package com.infernalWhaler.deposits;

import com.infernalWhaler.models.Transaction;

import java.time.LocalDate;

/**
 * @author sDeseure
 * @project challenge
 * @date 10/04/2022
 */

public interface IDeposit {

    Transaction getTransaction();

    LocalDate getDistributionDate();

    LocalDate getExpirationDate();
}
