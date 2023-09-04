package com.idrbt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {

	private Long account_Num;
	private Long loginId;
	private String username;
	private String password;
	private String email;

	public LoginDto() {
		super();
	}

	public LoginDto(Long account_Num, Long loginId, String username, String password, String email) {
		super();
		this.account_Num = account_Num;
		this.loginId = loginId;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public Long getAccount_Num() {
		return account_Num;
	}

	public void setAccount_Num(Long account_Num) {
		this.account_Num = account_Num;
	}

	public Long getLoginId() {
		return loginId;
	}

	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "LoginDto [account_Num=" + account_Num + ", loginId=" + loginId + ", username=" + username
				+ ", password=" + password + ", email=" + email + "]";
	}

}
