package com.idrbt.service;

import java.util.List;

import com.idrbt.entity.Account;

public interface AccountService {
	
	Account saveAccount(Account account);
	
	Account getAccountByNum(Long accountNum);
	
	List<Account> getAllAccounts();

}
