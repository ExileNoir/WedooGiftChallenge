package com.infernalWhaler.company;

import com.infernalWhaler.deposits.GiftDeposit;
import com.infernalWhaler.deposits.IDeposit;
import com.infernalWhaler.deposits.MealDeposit;
import com.infernalWhaler.models.Transaction;
import com.infernalWhaler.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author sDeseure
 * @project challenge
 * @date 10/04/2022
 */

class CompanyTest {
    private Company wedooGift;
    private User steven;

    @BeforeEach
    void setUp() {
        wedooGift = new Company("WedooGift", 100.0);
        steven = new User("Steven");
    }

    @Test
    void getBalanceValid() {
        assertEquals(100.0, wedooGift.getBalance());
    }

    @Test
    void setBalanceValid() {
        wedooGift.setBalance(20.0);
        assertEquals(120.0, wedooGift.getBalance());
    }

    @Test
    void distributeDepositValid() {
        final IDeposit mealDeposit = new MealDeposit(new Transaction(wedooGift.getName(), 30.0), LocalDate.now());
        final IDeposit giftDeposit = new GiftDeposit(new Transaction(wedooGift.getName(), 40.0), LocalDate.now());
        wedooGift.distributeDeposit(mealDeposit, steven);
        wedooGift.distributeDeposit(giftDeposit, steven);

        assertEquals(30.0, wedooGift.getBalance());

        assertEquals(2, steven.getDeposits().size());
        assertEquals(1, steven.getMealDeposits().size());
        assertEquals(1, steven.getGiftDeposits().size());

        assertEquals(30.0, steven.mealBalance());
        assertEquals(40.0, steven.giftBalance());
    }

    @Test
    void distributeDepositNonValid() {
        final IDeposit mealDeposit = new MealDeposit(new Transaction(wedooGift.getName(), 30.0), LocalDate.now());
        final IDeposit giftDeposit = new GiftDeposit(new Transaction(wedooGift.getName(), 40.0), LocalDate.now());
        final IDeposit giftDepositTwo = new GiftDeposit(new Transaction(wedooGift.getName(), 50.0), LocalDate.now());
        wedooGift.distributeDeposit(mealDeposit, steven);
        wedooGift.distributeDeposit(giftDeposit, steven);
        wedooGift.distributeDeposit(giftDepositTwo, steven);

        assertEquals(30.0, wedooGift.getBalance());

        assertNotEquals(3, steven.getDeposits().size());
        assertEquals(1, steven.getMealDeposits().size());
        assertNotEquals(2, steven.getGiftDeposits().size());

        assertEquals(30.0, steven.mealBalance());
        assertNotEquals(90.0, steven.giftBalance());
    }
}