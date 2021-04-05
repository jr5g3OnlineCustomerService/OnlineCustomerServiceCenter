package com.cg.onlinecustomerservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.cg.onlinecustomerservice.dao.LoginDao;
import com.cg.onlinecustomerservice.entity.Login;

public class LoginService implements ILoginService {
		@Autowired
		LoginDao loginRepository;
		@Override
		public String loginValidation(Login login) {
			if(loginRepository.equals(login)) {
				return "Logged in successfully";
			}
			else {
				return "Please enter correct UserId or Password";
			}

}
}
