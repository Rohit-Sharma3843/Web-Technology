package com.bank.ejb;

import jakarta.ejb.Stateless;

@Stateless
public class BankService {

    private double balance = 0.0;

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) throw new RuntimeException("Insufficient balance");
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}