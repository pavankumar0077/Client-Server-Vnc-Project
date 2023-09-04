package com.idrbt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idrbt.entity.Account;
import com.idrbt.repository.AccountRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }



	@Override
	public Account saveAccount(Account account) {
	  return accountRepository.save(account);

	}

	@Override
	public Account getAccountByNum(Long accountNum) {
		return accountRepository.findById(accountNum).get();
	}



	@Override
	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

}
