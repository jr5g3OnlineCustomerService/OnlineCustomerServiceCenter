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
import com.cg.onlinecustomerservice.dao.OperatorDao;
import com.cg.onlinecustomerservice.dto.OperatorDto;
import com.cg.onlinecustomerservice.entity.Department;
import com.cg.onlinecustomerservice.entity.Operator;
import com.cg.onlinecustomerservice.service.AdminService;
import com.cg.onlinecustomerservice.utils.DepartmentNotFoundException;
import com.cg.onlinecustomerservice.utils.OperatorNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class AdminTest {
	@InjectMocks
	AdminService service;
	@Mock
	DepartmentDao dDao;
	@Mock
	OperatorDao oDao;
	
	@Before
	public void init() {
		//System.out.println("** before method ***");
		//MockitoAnnotations.initMocks(this); 
	}
	//Testing getAllDepartment method
	@Test
	public void testGetAllDepartments() throws DepartmentNotFoundException {
		
		
		List<Department> itemsList = new ArrayList<Department>();
		itemsList.add(new Department(1,"IT"));
		itemsList.add(new Department(2,"Finance"));
		itemsList.add(new Department(3,"Marketing"));
		
		Mockito.when(dDao.findAll()).thenReturn(itemsList);
		List<Department> list = service.findAllDepartments();
		Assertions.assertEquals(3, list.size()); 
		Mockito.verify(dDao,Mockito.times(1)).findAll();
	}
	//Testing getAllOperator method
	@Test
	public void testGetAllOperator() throws OperatorNotFoundException {
		List<Operator> operators=new ArrayList<Operator>();
		operators.add(new Operator(1,"Nikhil","naik","sds","sds","sds"));
		Mockito.when(oDao.findAll()).thenReturn(operators);
		List<Operator> list = service.findAllOperators();
		Assertions.assertEquals(1, list.size());
		Mockito.verify(oDao,Mockito.times(1)).findAll();
	}
	@Test
	public void testAddDepartment() throws DepartmentNotFoundException {
		Department department=new Department();
		department.setDepartmentID(1);
		department.setDepartmentName("IT");
		service.addDepartment(department);
		Assertions.assertNotNull(department.getDepartmentID());
		Mockito.verify(dDao, Mockito.times(1)).save(department);
	}
	@Test(expected=DepartmentNotFoundException.class)
	public void testRemoveDepartment() throws DepartmentNotFoundException {
		Department department=new Department();
		service.removeDepartment(1);
		Assertions.assertNotNull(department.getDepartmentID());
		Mockito.verify(dDao, Mockito.times(1)).deleteById(1);
	}
	@Test(expected=DepartmentNotFoundException.class)
	public void testfindDepartmentById() throws DepartmentNotFoundException {
		Department department=new Department();
		service.findDepartmentById(1);
		Assertions.assertNotNull(department.getDepartmentID());
		Mockito.verify(dDao, Mockito.times(1)).getDeptById(1);
	}
	
}
