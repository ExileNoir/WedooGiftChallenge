package com.infernalWhaler.users;

import com.infernalWhaler.deposits.GiftDeposit;
import com.infernalWhaler.deposits.MealDeposit;

import java.util.List;

/**
 * @author sDeseure
 * @project challenge
 * @date 10/04/2022
 */

public interface IUser {

    List<MealDeposit> getMealDeposits();

    List<GiftDeposit> getGiftDeposits();

    Double totalBalance();

    Double giftBalance();

    Double mealBalance();
}
