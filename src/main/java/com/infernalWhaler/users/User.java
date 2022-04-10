package com.infernalWhaler.users;

import com.infernalWhaler.deposits.Deposit;
import com.infernalWhaler.deposits.GiftDeposit;
import com.infernalWhaler.deposits.MealDeposit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sDeseure
 * @project challenge
 * @date 10/04/2022
 */

public class User implements IUser {

    private String name;
    private List<Deposit> deposits;

    public User(String name) {
        this.name = name;
        this.deposits = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Deposit> getDeposits() {
        return deposits;
    }

    public List<MealDeposit> getMealDeposits() {
        return deposits.stream()
                .filter(MealDeposit.class::isInstance)
                .map(deposit -> (MealDeposit) deposit)
                .collect(Collectors.toList());
    }

    public List<GiftDeposit> getGiftDeposits() {
        return deposits.stream()
                .filter(GiftDeposit.class::isInstance)
                .map(deposit -> (GiftDeposit) deposit)
                .collect(Collectors.toList());
    }

    public Double totalBalance() {
        return getDeposits().stream()
                .filter(deposit -> LocalDate.now().isBefore(deposit.getExpirationDate()))
                .mapToDouble(Deposit::getAmount)
                .sum();
    }

    public Double giftBalance() {
        return getDeposits().stream()
                .filter(GiftDeposit.class::isInstance)
                .filter(deposit -> LocalDate.now().isBefore(deposit.getExpirationDate()))
                .mapToDouble(Deposit::getAmount)
                .sum();
    }

    public Double mealBalance() {
        return getDeposits().stream()
                .filter(MealDeposit.class::isInstance)
                .filter(deposit -> LocalDate.now().isBefore(deposit.getExpirationDate()))
                .mapToDouble(Deposit::getAmount)
                .sum();
    }
}
