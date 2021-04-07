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
import com.cg.onlinecustomerservice.dao.OperatorDao;
import com.cg.onlinecustomerservice.dao.SolutionDao;
import com.cg.onlinecustomerservice.entity.Customer;
import com.cg.onlinecustomerservice.entity.Department;
import com.cg.onlinecustomerservice.entity.Issue;
import com.cg.onlinecustomerservice.service.AdminService;
import com.cg.onlinecustomerservice.service.OperatorService;
import com.cg.onlinecustomerservice.utils.CustomerNotFoundException;
import com.cg.onlinecustomerservice.utils.DepartmentNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class OperatorTest {
	@InjectMocks
	AdminService Adservice;
	@InjectMocks
	OperatorService opService;
	@Mock
	DepartmentDao dDao;
	@Mock
	OperatorDao oDao;
	@Mock
	SolutionDao solDao;
	@Mock
	CustomerDao custDao;
	@Before
	public void init() {
		//System.out.println("** before method ***");
		//MockitoAnnotations.initMocks(this); 
	}
	@Test(expected=CustomerNotFoundException.class)
	public void testfindCustomerById() throws CustomerNotFoundException {
		Customer customer=new Customer();
		opService.findCustomerById(0);
		Assertions.assertNotNull(customer.getCustomerId());
		Mockito.verify(custDao, Mockito.times(1)).findCustomerById(1);
	}
	
	@Test(expected=CustomerNotFoundException.class)
	public void testfindCustomerByEmail() throws CustomerNotFoundException {
		Customer customer=new Customer();
		opService.findCustomerByEmail("Nikhil");
		Assertions.assertNotNull(customer.getFirstname());
		Mockito.verify(custDao, Mockito.times(1)).findCustomerByEmail("Nikhil");
	}
	
}
