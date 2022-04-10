package com.infernalWhaler.company;

import com.infernalWhaler.deposits.Deposit;
import com.infernalWhaler.deposits.GiftDeposit;
import com.infernalWhaler.deposits.MealDeposit;
import com.infernalWhaler.users.User;

/**
 * @author sDeseure
 * @project challenge
 * @date 10/04/2022
 */

public class Company implements ICompany {

    private String name;
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

    public void distributeDeposit(final Deposit deposit, final User user) {
        if (balance < deposit.getAmount()) {
            System.out.println("Deposit cannot be executed.\n Your Balance is: '€ " + getBalance() + "'");
            return;
        }

        this.balance -= deposit.getAmount();
        final boolean isMaelDeposit = deposit instanceof MealDeposit;

        if (isMaelDeposit) {
            final MealDeposit mealDeposit = new MealDeposit(deposit.getNameSender(), deposit.getAmount(), deposit.getDistributionDate());
            user.getDeposits().add(mealDeposit);
        } else {
            final GiftDeposit giftDeposit = new GiftDeposit(deposit.getNameSender(), deposit.getAmount(), deposit.getDistributionDate());
            user.getDeposits().add(giftDeposit);
        }
    }
}