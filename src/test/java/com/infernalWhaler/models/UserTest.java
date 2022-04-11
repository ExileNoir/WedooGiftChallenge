package com.infernalWhaler.models;

import com.infernalWhaler.company.Company;
import com.infernalWhaler.deposits.GiftDeposit;
import com.infernalWhaler.deposits.IDeposit;
import com.infernalWhaler.deposits.MealDeposit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author sDeseure
 * @project challenge
 * @date 10/04/2022
 */

class UserTest {

    private User user;
    private Company wedooGift;

    @BeforeEach
    void setUp() {
        user = new User("Steven");
        wedooGift = new Company("WedooGift", 100.00);

        final IDeposit maelOne = new MealDeposit(new Transaction(wedooGift.getName(), 30.0), LocalDate.now());
        final IDeposit giftOne = new GiftDeposit(new Transaction(wedooGift.getName(), 40.0), LocalDate.now());
        final IDeposit giftTwo = new GiftDeposit(new Transaction(wedooGift.getName(), 50.0), LocalDate.now());
        final IDeposit giftThree = new GiftDeposit(new Transaction(wedooGift.getName(), 40.0), LocalDate.of(1983, Month.FEBRUARY, 1));

        user.getDeposits().add(maelOne);
        user.getDeposits().add(giftOne);
        user.getDeposits().add(giftTwo);
        user.getDeposits().add(giftThree);
    }

    @Test
    void getDepositsSize() {
        final int totalDeposits = user.getDeposits().size();

        assertEquals(4, totalDeposits);
    }

    @Test
    void getMealDepositSize() {
        final int totalMealDeposits = user.getMealDeposits().size();

        assertEquals(1, totalMealDeposits);
    }

    @Test
    void getGiftDepositSize() {
        final int totalGiftDeposits = user.getGiftDeposits().size();

        assertEquals(3, totalGiftDeposits);
    }

    @Test
    void totalBalanceValid() {
        final Double totalBalance = user.totalBalance();

        assertEquals(120.0, totalBalance);
    }

    @Test
    void totalBalanceNonValid() {
        final Double totalBalance = user.totalBalance();

        assertNotEquals(160.0, totalBalance);
    }

    @Test
    void giftBalance() {
        final Double giftBalance = user.giftBalance();

        assertEquals(90.0, giftBalance);
    }

    @Test
    void mealBalance() {
        final Double mealBalance = user.mealBalance();

        assertEquals(30.0, mealBalance);
    }
}