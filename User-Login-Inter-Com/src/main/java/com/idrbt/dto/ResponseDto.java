package com.idrbt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {

	private AccountDto account;
	private LoginDto loginDto;

	public ResponseDto() {
		super();
	}

	public ResponseDto(AccountDto account, LoginDto loginDto) {
		super();
		this.account = account;
		this.loginDto = loginDto;
	}

	public AccountDto getAccount() {
		return account;
	}

	public void setAccount(AccountDto account) {
		this.account = account;
	}

	public LoginDto getLoginDto() {
		return loginDto;
	}

	public void setLoginDto(LoginDto loginDto) {
		this.loginDto = loginDto;
	}

	@Override
	public String toString() {
		return "ResponseDto [account=" + account + ", loginDto=" + loginDto + "]";
	}

}
