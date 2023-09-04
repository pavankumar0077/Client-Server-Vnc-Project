package com.idrbt.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
	
	private Long accountNum;
	private String accountType;
	private LocalDate accountOpeningDate;
	private double balance;
	
	
	public AccountDto() {
		super();
	}


	public AccountDto(Long accountNum, String accountType, LocalDate accountOpeningDate, double balance) {
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
		return "AccountDto [accountNum=" + accountNum + ", accountType=" + accountType + ", accountOpeningDate="
				+ accountOpeningDate + ", balance=" + balance + "]";
	}
	

}
