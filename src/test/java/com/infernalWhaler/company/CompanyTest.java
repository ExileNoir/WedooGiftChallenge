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
        final Double balance = wedooGift.getBalance();

        assertEquals(100.0, balance);
    }

    @Test
    void setBalanceValid() {
        wedooGift.setBalance(20.0);

        final Double balance = wedooGift.getBalance();

        assertEquals(120.0, balance);
    }

    @Test
    void distributeDepositValid() {
        final IDeposit mealDeposit = new MealDeposit(new Transaction(wedooGift.getName(), 30.0), LocalDate.now());
        final IDeposit giftDeposit = new GiftDeposit(new Transaction(wedooGift.getName(), 40.0), LocalDate.now());
        wedooGift.distributeDeposit(mealDeposit, steven);
        wedooGift.distributeDeposit(giftDeposit, steven);

        final Double companyBalance = wedooGift.getBalance();
        final int totalDeposits = steven.getDeposits().size();
        final int totalMealDeposits = steven.getMealDeposits().size();
        final int totalGiftDeposits = steven.getGiftDeposits().size();
        final Double mealBalance = steven.mealBalance();
        final Double giftBalance = steven.giftBalance();

        assertEquals(30.0, companyBalance);
        assertEquals(2, totalDeposits);
        assertEquals(1, totalMealDeposits);
        assertEquals(1, totalGiftDeposits);
        assertEquals(30.0, mealBalance);
        assertEquals(40.0, giftBalance);
    }

    @Test
    void distributeDepositNonValid() {
        final IDeposit mealDeposit = new MealDeposit(new Transaction(wedooGift.getName(), 30.0), LocalDate.now());
        final IDeposit giftDeposit = new GiftDeposit(new Transaction(wedooGift.getName(), 40.0), LocalDate.now());
        final IDeposit giftDepositTwo = new GiftDeposit(new Transaction(wedooGift.getName(), 50.0), LocalDate.now());
        wedooGift.distributeDeposit(mealDeposit, steven);
        wedooGift.distributeDeposit(giftDeposit, steven);
        wedooGift.distributeDeposit(giftDepositTwo, steven);

        final Double companyBalance = wedooGift.getBalance();
        final int totalDeposits = steven.getDeposits().size();
        final int totalMealDeposits = steven.getMealDeposits().size();
        final int totalGiftDeposits = steven.getGiftDeposits().size();
        final Double mealBalance = steven.mealBalance();
        final Double giftBalance = steven.giftBalance();

        assertEquals(30.0, companyBalance);
        assertNotEquals(3, totalDeposits);
        assertEquals(1, totalMealDeposits);
        assertNotEquals(2, totalGiftDeposits);
        assertEquals(30.0, mealBalance);
        assertNotEquals(90.0, giftBalance);
    }
}