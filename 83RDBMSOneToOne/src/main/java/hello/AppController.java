package hello;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	
	@Autowired
	public EmployeeDao employeeDao;
	
	@Autowired
	public DepartmentDao departmentDao;
	
	@PostConstruct
	public void add() {
		
		
		
		
	}
	
	
}
