package OnlineCustomerServiceCenter;
import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.cg.onlinecustomerservice.dao.DepartmentDao;
import com.cg.onlinecustomerservice.entity.Department;
import com.cg.onlinecustomerservice.service.AdminService;

@RunWith(MockitoJUnitRunner.class)
public class LibraryTest {
	@InjectMocks
	AdminService service;
	@Mock
	DepartmentDao dDao;
	
	@Before
	public void init() {
		System.out.println("** before method ***");
		MockitoAnnotations.initMocks(this); 
	}
	
	@Test
	public void testGetAllDepartments() {
		//List<Department> departments = service.findAllDepartments();
		
		List<Department> itemsList = new ArrayList<Department>();
		itemsList.add(new Department(1,"IT"));
		itemsList.add(new Department(2,"Finance"));
		itemsList.add(new Department(3,"Marketing"));
		
		Mockito.when(dDao.findAll()).thenReturn(itemsList);
		List<Department> list = service.findAllDepartments();
		Assertions.assertEquals(3, list.size()); 
		Mockito.verify(dDao,Mockito.times(1)).findAll();
	}
}
