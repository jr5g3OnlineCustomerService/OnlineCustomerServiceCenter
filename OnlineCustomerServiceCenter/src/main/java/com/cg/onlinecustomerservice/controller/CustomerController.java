package com.cg.onlinecustomerservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinecustomerservice.dao.CustomerDao;
import com.cg.onlinecustomerservice.dao.IssueDao;
import com.cg.onlinecustomerservice.dto.ChatDto;
import com.cg.onlinecustomerservice.entity.Customer;
import com.cg.onlinecustomerservice.entity.Issue;
import com.cg.onlinecustomerservice.entity.Solution;
import com.cg.onlinecustomerservice.service.CustomerService;

import com.cg.onlinecustomerservice.utils.CustomerAlreadyExistingException;
import com.cg.onlinecustomerservice.utils.CustomerNotFoundException;
import com.cg.onlinecustomerservice.utils.InvalidCredentialException;
import com.cg.onlinecustomerservice.utils.IssueNotFoundException;
import com.cg.onlinecustomerservice.utils.SolutionNotFoundException;

@RestController
@RequestMapping("/customer")
public class CustomerController {  //Customer is One of the Three actors
	@Autowired
	CustomerService service;
    
     @Autowired 
     IssueDao idao;
     @Autowired
     CustomerDao customerDao;
     @PostMapping("/login") //Takes  Login in credentials and shows successful or  not
	public ResponseEntity<Customer> loginValidation(@RequestBody Customer customer)throws InvalidCredentialException {
		Customer str=service.customerLogin(customer);
		if(str==null) {
			throw new InvalidCredentialException();
		}
		return new ResponseEntity<Customer>(str,HttpStatus.OK);
	}
	@PostMapping("/addCustomer") //adds customer for given input data given
	public String registerCustomer(@Valid @RequestBody Customer customer) {
		Customer cust = customerDao.checkCustomer(customer.getEmail());
		if(cust!=null)
		{
		throw new CustomerAlreadyExistingException();
		}
		service.registerCustomer(customer);
		return "Customer added";
		}
	
	/*@GetMapping("/allCustomers") //shows the contents of the customer table and exception if table is empty
	public ResponseEntity<List<Customer>> ViewAllCustomers() throws CustomerNotFoundException{
		List<Customer> response=service.ViewAllCustomers();
		if(response.size()>0)
		{
		return new ResponseEntity<List<Customer>>(response,HttpStatus.OK);
	}
		else {
			throw new ListEmptyException();
		}
	}*/
	@GetMapping("/viewIssuesById") //shows Issue having given id value and exception if it does not exist
	public ResponseEntity<Issue> viewIssuesById(@RequestBody int code) throws IssueNotFoundException{
		Issue response=service.viewIssuesById(code);
		if(!idao.findById(code).isPresent())
			throw new IssueNotFoundException();
		else
			return new ResponseEntity<Issue>(response,HttpStatus.OK);
	}
	@GetMapping("/allIssues") //shows the issue table and exception if table is empty 
	public ResponseEntity<List<Issue>> ViewAllIssues() throws IssueNotFoundException{
		List<Issue> issues=service.ViewAllIssues();
		if (issues!=null)
			return new ResponseEntity<List<Issue>>(issues,HttpStatus.OK);
		else 
			throw new IssueNotFoundException();
	}//
	@GetMapping("/viewSolutionsById") //Shows solution for given ID and exception if the ID value given does not exist
	public ResponseEntity<Solution> viewSolutionsById(@RequestBody int code) throws SolutionNotFoundException{
		Solution response=service.viewSolutionsById(code);
		if (response!=null)
			return new ResponseEntity<Solution>(response,HttpStatus.OK);
		else 
			throw new SolutionNotFoundException();
	}
	@GetMapping("/allSolutions")  //displays the solution table
	public ResponseEntity<List<Solution>> ViewAllSolution() throws SolutionNotFoundException{
		List<Solution> issues=service.ViewAllSolutions();
		if(issues!=null)
		    return new ResponseEntity<List<Solution>>(issues,HttpStatus.OK);
		else 
			throw new SolutionNotFoundException();
	}
	@PutMapping("/ChangePassword")  //for given login credentials allows to update password
	public String changePassword(@RequestBody Customer customer) {
		if(!customerDao.existsById(customer.getCustomerId()))
			throw new CustomerNotFoundException();
		service.changePassword(customer);
		return "Updated";
	}
	
	@PutMapping("/reopenissue")  //re-activates issue for given id and exception if value does not exist
	public ResponseEntity<Issue> changeIssueStatus(@RequestBody int id) throws IssueNotFoundException {
		if(!idao.findById(id).isPresent())
			throw new IssueNotFoundException();
		else {
		Issue issues=service.reOpenIssue(id);
		return new ResponseEntity<Issue>(issues,HttpStatus.OK);
		}
		}
	@PostMapping("/addComplaints") //adds customer for given input data given
	public ResponseEntity<String> addComplaints(@Valid @RequestBody ChatDto chatDto) {
		Customer cust = customerDao.findCustomerById(chatDto.getCustomerId());
		if(cust==null)
		{
		throw new CustomerNotFoundException();
		}
		else {
		service.addChat(chatDto);
		return new ResponseEntity<String>("Added complaints",HttpStatus.OK);
		}

}
}

