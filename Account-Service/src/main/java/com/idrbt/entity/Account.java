package com.idrbt.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Accounts")
public class Account {
	
	@Id       
	@Column(name = "Account_num")
	private Long accountNum;

	@Column(name = "Account_type")
	private String accountType;

//	format (yyyy-mm-dd)
	@Column(name = "Account_opening_date")
	private LocalDate accountOpeningDate;

//    private String accountOpeningDate;

	@Column(name = "Account_balance")
	private double balance;

	public Account() {
		super();
	}

	public Account(Long accountNum, String accountType, LocalDate accountOpeningDate, double balance) {
		super();
		this.accountNum = accountNum;
		this.accountType = accountType;
		this.accountOpeningDate = accountOpeningDate;
		this.balance = balance;
	}

	public Long getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(Long accountNum) {
		this.accountNum = accountNum;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public LocalDate getAccountOpeningDate() {
		return accountOpeningDate;
	}

	public void setAccountOpeningDate(LocalDate accountOpeningDate) {
		this.accountOpeningDate = accountOpeningDate;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountNum=" + accountNum + ", accountType=" + accountType + ", accountOpeningDate="
				+ accountOpeningDate + ", balance=" + balance + "]";
	}

}
