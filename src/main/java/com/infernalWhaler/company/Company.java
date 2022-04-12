package com.infernalWhaler.company;

import com.infernalWhaler.deposits.GiftDeposit;
import com.infernalWhaler.deposits.IDeposit;
import com.infernalWhaler.deposits.MealDeposit;
import com.infernalWhaler.models.Transaction;
import com.infernalWhaler.models.User;

/**
 * @author sDeseure
 * @project challenge
 * @date 10/04/2022
 */

public class Company implements ICompany {

    private final String name;
    private Double balance;

    public Company(String name, Double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance += balance;
    }

    @Override
    public void distributeDeposit(final IDeposit deposit, final User user) {
        final String depositName = deposit.getTransaction().getName();
        final Double depositAmount = deposit.getTransaction().getAmount();

        if (balance < depositAmount) {
            System.out.println("Deposit cannot be executed.\n Your Balance is: '€ " + getBalance() + "'");
            return;
        }

        this.balance -= depositAmount;
        final boolean isMealDeposit = deposit instanceof MealDeposit;

        if (isMealDeposit) {
            final MealDeposit mealDeposit = new MealDeposit(new Transaction(depositName, depositAmount),
                    deposit.getDistributionDate());
            user.getDeposits().add(mealDeposit);
        } else {
            final GiftDeposit giftDeposit = new GiftDeposit(new Transaction(depositName, depositAmount),
                    deposit.getDistributionDate());
            user.getDeposits().add(giftDeposit);
        }
    }
}