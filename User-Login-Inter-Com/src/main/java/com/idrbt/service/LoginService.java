package com.idrbt.service;

import com.idrbt.dto.ResponseDto;
import com.idrbt.entity.Login;

public interface LoginService {

    Login saveLoginDetails(Login login);

    ResponseDto getLoginAccountDetails(Long accountNum);
}
