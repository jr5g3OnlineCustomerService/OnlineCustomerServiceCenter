package com.cg.onlinecustomerservice.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
@ControllerAdvice
public class ExceptionHandlers {
	@ExceptionHandler(value=CustomerNotFoundException.class)
	public ResponseEntity<Object> exception(CustomerNotFoundException exception){
	  return new ResponseEntity<Object>("Customer not found...",HttpStatus.NOT_FOUND);
	}
    
	@ExceptionHandler(value=DepartmentNotFoundException.class)
	public ResponseEntity<Object> exception(DepartmentNotFoundException exception){
	  return new ResponseEntity<Object>("Department not found...",HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value=DuplicateCustomerException.class)
	public ResponseEntity<Object> exception(DuplicateCustomerException exception){
	  return new ResponseEntity<Object>("Duplicate Customer...",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=InvalidCredentialException.class)
	public ResponseEntity<Object> exception(InvalidCredentialException exception){
	  return new ResponseEntity<Object>("Invalid Credentials...",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=IssueNotFoundException.class)
	public ResponseEntity<Object> exception(IssueNotFoundException exception){
	  return new ResponseEntity<Object>("No issue found...",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=OperatorNotFoundException.class)
	public ResponseEntity<Object> exception(OperatorNotFoundException exception){
	  return new ResponseEntity<Object>("Operator not found...",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value=SolutionNotFoundException.class)
	public ResponseEntity<Object> exception(SolutionNotFoundException exception){
	  return new ResponseEntity<Object>("Solution not found...",HttpStatus.NOT_FOUND);
	}
}
