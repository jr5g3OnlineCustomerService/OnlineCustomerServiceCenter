package com.cg.onlinecustomerservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinecustomerservice.dao.ChatDao;
import com.cg.onlinecustomerservice.dao.CustomerDao;
import com.cg.onlinecustomerservice.dao.IssueDao;
import com.cg.onlinecustomerservice.dao.LoginDao;
import com.cg.onlinecustomerservice.dao.SolutionDao;
import com.cg.onlinecustomerservice.dto.ChatDto;
import com.cg.onlinecustomerservice.entity.Chat;
import com.cg.onlinecustomerservice.entity.Customer;
import com.cg.onlinecustomerservice.entity.Issue;
import com.cg.onlinecustomerservice.entity.Login;
import com.cg.onlinecustomerservice.entity.Solution;
import com.cg.onlinecustomerservice.utils.CustomerNotFoundException;
import com.cg.onlinecustomerservice.utils.InvalidCredentialException;
import com.cg.onlinecustomerservice.utils.IssueNotFoundException;
import com.cg.onlinecustomerservice.utils.SolutionNotFoundException;


@Service
public class CustomerService implements ICustomerService{
	@Autowired
	LoginDao loginDao;
	@Autowired
	CustomerDao customerDao;
	@Autowired
	IssueDao issueDao;
	@Autowired
	SolutionDao solutionDao;
	@Autowired
	ChatDao chatDao;
	
  
  //customer table insertion
	@Override
	public String registerCustomer(Customer customer)
	{
		Customer cust= customerDao.save(customer);
		if(cust!=null)
			return "Customer inserted";
		else{
			return "Could not Insert";
		}
	}
	//view issues using id
	@Override
	public Issue viewIssuesById(int issueid) {		
			return issueDao.getIssueById(issueid);
	}
	//Change password
	/*@Override
	public String changePassword(Login login)
	{	
		int id=0;
		id=login.getUserId();
		if(id!=0) {
			Login log=loginDao.findById(id).get();
			log.setPassword(login.getPassword());
			loginDao.save(log);
			return "Email updated";
		}
		else {
			return "User not found";
		}
	}*/
	//viewing all issue
	@Override
	public List<Issue> ViewAllIssues() {
		List<Issue> response=issueDao.findAll();
		return response;
	}
	//viewing all customers
	@Override
	public List<Customer> ViewAllCustomers() {
		List<Customer>response=customerDao.findAll();
		return response;
	}
	//changing issue status
	@Override
	public Issue reOpenIssue(int id) {
		Issue result=issueDao.getIssueById(id);
		result.setIssueStatus("Pending");
		issueDao.save(result);
		return result;}
		/*int id=issue.getIssueId();
		Issue result=issueDao.findById(id).get();
		result.setIssueStatus(issue.getIssueStatus());
		issueDao.save(result);
		return result;*/
	//viewing solution using ID
	@Override
	public Solution viewSolutionsById(int code) {		
			return solutionDao.getSolutionById(code);
	}
	//viewing all solution
	@Override
	public List<Solution> ViewAllSolutions()  {
		List<Solution> response=solutionDao.findAll();
		return response;
	}
	@Override
	public String addChat(ChatDto chatDto) {
		Chat chat=new Chat();
		chat.setChatDate(chatDto.getChatDate());
		chat.setFirstName(chatDto.getFirstName());
		chat.setLastName(chatDto.getLastName());
		chat.setEmail(chatDto.getEmail());
		chat.setComplaints(chatDto.getOpinion());
		Customer cust=customerDao.findCustomerById(chatDto.getCustomerId());
		chat.setCustomer(cust);
		chatDao.save(chat);
		return "Chat is added";
	
	}

	@Override
	public Customer customerLogin(Customer customer) {
		// TODO Auto-generated method stub
		Customer cust = customerDao.customerLogin(customer.getPassword(),customer.getEmail());
		return cust;
	}
	@Override
	public String changePassword(Customer customer) {
		int id=customer.getCustomerId();
		Customer cust=customerDao.findCustomerById(id);
		cust.setPassword(customer.getPassword());
		customerDao.save(cust);
		return "Updated";
		
	}
}
