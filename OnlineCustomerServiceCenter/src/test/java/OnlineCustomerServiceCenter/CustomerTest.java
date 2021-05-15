package OnlineCustomerServiceCenter;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.cg.onlinecustomerservice.dao.CustomerDao;
import com.cg.onlinecustomerservice.dao.DepartmentDao;
import com.cg.onlinecustomerservice.dao.IssueDao;
import com.cg.onlinecustomerservice.dao.OperatorDao;
import com.cg.onlinecustomerservice.dao.SolutionDao;
import com.cg.onlinecustomerservice.entity.Customer;
import com.cg.onlinecustomerservice.entity.Department;
import com.cg.onlinecustomerservice.entity.Issue;
import com.cg.onlinecustomerservice.entity.Solution;
import com.cg.onlinecustomerservice.service.AdminService;
import com.cg.onlinecustomerservice.service.CustomerService;
import com.cg.onlinecustomerservice.utils.DepartmentNotFoundException;
import com.cg.onlinecustomerservice.utils.IssueNotFoundException;
import com.cg.onlinecustomerservice.utils.SolutionNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class CustomerTest {
	@InjectMocks
	AdminService service;
	@InjectMocks
	CustomerService custService;
	@Mock
	DepartmentDao dDao;
	@Mock
	OperatorDao oDao;
	@Mock
	CustomerDao custDao;
	@Mock
	IssueDao IssDao;
	@Mock
	SolutionDao solDao;
	@Before
	public void init() {
		//System.out.println("** before method ***");
		//MockitoAnnotations.initMocks(this); 
	}
	@Test
	public void testAddCustomer() {
		Customer customer=new Customer();
		customer.setCustomerId(1);
		customer.setFirstName("Nikhil");
		customer.setLastName("Naik");
		customer.setEmail("nik@gmail.com");
		customer.setMobile("9988776655");
		customer.setCity("Mangalore");
		custService.registerCustomer(customer);
		Assertions.assertNotNull(customer.getCustomerId());
		Mockito.verify(custDao, Mockito.times(1)).save(customer);
	}
	@Test(expected=IssueNotFoundException.class)
	public void testfindIssueById() throws IssueNotFoundException {
		Issue issue=new Issue();
		custService.viewAllIssuesById(1);
		Assertions.assertNotNull(issue.getIssueId());
		Mockito.verify(IssDao, Mockito.times(1)).findById(1);
	}
	@Test(expected=SolutionNotFoundException.class)
	public void testfindSolutionById() throws SolutionNotFoundException {
		Solution issue=new Solution();
		custService.viewSolutionsById(1);
		Assertions.assertNotNull(issue.getSolutionId());
		Mockito.verify(solDao, Mockito.times(1)).findById(1);
	}
	
}
