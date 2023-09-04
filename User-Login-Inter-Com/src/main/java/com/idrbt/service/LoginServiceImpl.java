package com.idrbt.service;

import com.idrbt.dto.AccountDto;
import com.idrbt.dto.LoginDto;
import com.idrbt.dto.ResponseDto;
import com.idrbt.entity.Login;
import com.idrbt.repository.LoginRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.NoSuchElementException;

@Service
public class LoginServiceImpl implements LoginService {

    private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private final LoginRepository loginRepository;

    @Autowired
    private RestTemplate restTemplate;

    public LoginServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public Login saveLoginDetails(Login login) {
        return loginRepository.save(login);
    }

    @Override
    public ResponseDto getLoginAccountDetails(Long accountNum) {
        try {
            ResponseDto responseDto = new ResponseDto();
            Login login = loginRepository.findByAccountNum(accountNum)
                    .orElseThrow(() -> new NoSuchElementException("Login not found"));

            LoginDto loginDto = mapToLogin(login);

            ResponseEntity<AccountDto> responseEntity = restTemplate.getForEntity(
                    "http://192.168.138.156:9901/api/accounts/" + login.getAccountNum(),
                    AccountDto.class
            );

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                AccountDto accountDto = responseEntity.getBody();
                responseDto.setAccount(accountDto);
            } else {
                log.warn("External service returned status code: {}", responseEntity.getStatusCode());
            }

            responseDto.setLoginDto(loginDto);
            return responseDto;
        } catch (RestClientException e) {
            log.error("Error while communicating with external service: {}", e.getMessage());
            throw new RuntimeException("Error communicating with external service", e);
        }
    }

    private LoginDto mapToLogin(Login login) {
        LoginDto loginDto = new LoginDto();
        loginDto.setLoginId(login.getLoginId());
        loginDto.setUsername(login.getUsername());
        loginDto.setPassword(login.getPassword());
        loginDto.setEmail(login.getEmail());
        loginDto.setAccount_Num(login.getAccountNum());
        return loginDto;
    }
}
