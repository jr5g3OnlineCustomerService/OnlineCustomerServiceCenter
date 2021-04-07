package OnlineCustomerServiceCenter;

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
import com.cg.onlinecustomerservice.entity.Customer;
import com.cg.onlinecustomerservice.entity.Department;
import com.cg.onlinecustomerservice.entity.Issue;
import com.cg.onlinecustomerservice.service.AdminService;
import com.cg.onlinecustomerservice.service.CustomerService;
import com.cg.onlinecustomerservice.utils.DepartmentNotFoundException;
import com.cg.onlinecustomerservice.utils.IssueNotFoundException;

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
	@Before
	public void init() {
		//System.out.println("** before method ***");
		//MockitoAnnotations.initMocks(this); 
	}
	@Test
	public void testAddCustomer() {
		Customer customer=new Customer();
		customer.setCustomerId(1);
		customer.setFirstname("Nikhil");
		customer.setLastname("Naik");
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
		custService.viewIssuesById(1);
		Assertions.assertNotNull(issue.getIssueId());
		Mockito.verify(IssDao, Mockito.times(1)).findById(1);
	}
}
