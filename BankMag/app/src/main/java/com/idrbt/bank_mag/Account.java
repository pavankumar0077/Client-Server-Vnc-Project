package com.idrbt.bank_mag;

public class Account {
    private String accountNum;
    private String accountType;
    private String accountOpeningDate;
    private double balance;
    private String username;

    public Account(String accountNum, String accountType, String accountOpeningDate, double balance, String username) {
        this.accountNum = accountNum;
        this.accountType = accountType;
        this.accountOpeningDate = accountOpeningDate;
        this.balance = balance;
        this.username = username;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getAccountOpeningDate() {
        return accountOpeningDate;
    }

    public double getBalance() {
        return balance;
    }

    public String getUsername() {
        return username;
    }
}
