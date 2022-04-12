package com.infernalWhaler.company;

import com.infernalWhaler.deposits.IDeposit;
import com.infernalWhaler.models.User;

/**
 * Company Contract
 *
 * @author sDeseure
 * @project challenge
 * @date 10/04/2022
 */

public interface ICompany {

    /**
     * Distribute a meal or gift deposit to a User
     *
     * @param deposit of object IDeposit
     * @param user    of object User
     */
    void distributeDeposit(IDeposit deposit, User user);
}
