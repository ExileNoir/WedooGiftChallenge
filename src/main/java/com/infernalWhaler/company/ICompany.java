package com.infernalWhaler.company;

import com.infernalWhaler.deposits.Deposit;
import com.infernalWhaler.users.User;

/**
 * @author sDeseure
 * @project challenge
 * @date 10/04/2022
 */

public interface ICompany {

    void distributeDeposit(Deposit deposit, User user);
}
