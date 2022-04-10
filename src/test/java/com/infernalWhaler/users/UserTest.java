package com.infernalWhaler.users;

import com.infernalWhaler.company.Company;
import com.infernalWhaler.deposits.Deposit;
import com.infernalWhaler.deposits.GiftDeposit;
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

        final Deposit maelOne = new MealDeposit(wedooGift.getName(), 30.0, LocalDate.now());
        final Deposit giftOne = new GiftDeposit(wedooGift.getName(), 40.0, LocalDate.now());
        final Deposit giftTwo = new GiftDeposit(wedooGift.getName(), 50.0, LocalDate.now());
        final Deposit giftThree = new GiftDeposit(wedooGift.getName(), 40.0, LocalDate.of(1983, Month.FEBRUARY, 1));

        user.getDeposits().add(maelOne);
        user.getDeposits().add(giftOne);
        user.getDeposits().add(giftTwo);
        user.getDeposits().add(giftThree);
    }

    @Test
    void getDepositsSize() {
        assertEquals(4, user.getDeposits().size());
    }

    @Test
    void getMealDepositSize() {
        assertEquals(1, user.getMealDeposits().size());
    }

    @Test
    void getGiftDepositSize() {
        assertEquals(3, user.getGiftDeposits().size());
    }

    @Test
    void totalBalanceValid() {
        assertEquals(120.0, user.totalBalance());
    }

    @Test
    void totalBalanceNonValid() {
        assertNotEquals(160.0, user.totalBalance());
    }

    @Test
    void giftBalance() {
        assertEquals(90.0, user.giftBalance());
    }

    @Test
    void mealBalance() {
        assertEquals(30.0, user.mealBalance());
    }
}