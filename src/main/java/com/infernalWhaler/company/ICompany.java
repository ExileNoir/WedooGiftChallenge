package com.infernalWhaler.company;

import com.infernalWhaler.deposits.IDeposit;
import com.infernalWhaler.models.User;

/**
 * @author sDeseure
 * @project challenge
 * @date 10/04/2022
 */

public interface ICompany {

    void distributeDeposit(IDeposit deposit, User user);
}
