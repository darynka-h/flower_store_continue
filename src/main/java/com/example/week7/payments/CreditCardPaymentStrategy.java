package com.example.week7.payments;

import lombok.Getter;

public class CreditCardPaymentStrategy implements Payment{
    @Getter
    private double balance;

    public CreditCardPaymentStrategy(){
        this.balance = 0;
    }
    public CreditCardPaymentStrategy(double balance){
        this.balance = Math.max(balance, 0);
    }

    public void putMoney(double money){
        this.balance += Math.max(money, 0);
    }

    public double takeMoney(double money){
        if (money > balance){
            return -1;
        }
        else{
            balance -= Math.max(money, 0);
            return Math.max(money, 0);
        }
    }

    @Override
    public boolean pay(double price) {
        return takeMoney(price) != -1;
    }
}
