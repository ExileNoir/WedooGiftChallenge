package com.infernalWhaler.models;

import com.infernalWhaler.deposits.GiftDeposit;
import com.infernalWhaler.deposits.IDeposit;
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

public class User {

    private final String name;
    private final List<IDeposit> deposits;

    public User(String name) {
        this.name = name;
        this.deposits = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<IDeposit> getDeposits() {
        return deposits;
    }

    public List<IDeposit> getMealDeposits() {
        return deposits.stream()
                .filter(MealDeposit.class::isInstance)
                .map(MealDeposit.class::cast)
                .collect(Collectors.toList());
    }

    public List<IDeposit> getGiftDeposits() {
        return deposits.stream()
                .filter(GiftDeposit.class::isInstance)
                .map(GiftDeposit.class::cast)
                .collect(Collectors.toList());
    }

    public Double totalBalance() {
        return getDeposits().stream()
                .filter(deposit -> LocalDate.now().isBefore(deposit.getExpirationDate()))
                .mapToDouble(deposit -> deposit.getTransaction().getAmount())
                .sum();
    }

    public Double giftBalance() {
        return getDeposits().stream()
                .filter(GiftDeposit.class::isInstance)
                .filter(deposit -> LocalDate.now().isBefore(deposit.getExpirationDate()))
                .mapToDouble(deposit -> deposit.getTransaction().getAmount())
                .sum();
    }

    public Double mealBalance() {
        return getDeposits().stream()
                .filter(MealDeposit.class::isInstance)
                .filter(deposit -> LocalDate.now().isBefore(deposit.getExpirationDate()))
                .mapToDouble(deposit -> deposit.getTransaction().getAmount())
                .sum();
    }
}
