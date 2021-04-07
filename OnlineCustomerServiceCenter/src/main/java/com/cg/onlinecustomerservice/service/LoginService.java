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
		public String loginValidation(Login login) {  //definition of the loginvalidation function used in operatorController 
			
			int id=login.getUserId();
			String pw= login.getPassword();
			boolean log=(loginRepository.existsById(id)&&loginRepository.equals(pw));
			if(log) {
				return "Logged in successfully";
			}
			else {
				return "Please enter correct UserId or Password";
			}

}
}
