package com.cg.onlinecustomerservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinecustomerservice.dao.LoginDao;
import com.cg.onlinecustomerservice.entity.Login;
@Service
public class LoginService implements ILoginService {
		@Autowired
		LoginDao loginRepository;
		@Override
		public String loginValidation(Login login) {
			
			int id=login.getUserId();
			boolean log=loginRepository.existsById(id);
			if(log) {
				return "Logged in successfully";
			}
			else {
				return "Please enter correct UserId or Password";
			}

}
}
