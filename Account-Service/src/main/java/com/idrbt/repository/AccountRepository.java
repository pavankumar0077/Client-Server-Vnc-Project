package com.idrbt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idrbt.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
