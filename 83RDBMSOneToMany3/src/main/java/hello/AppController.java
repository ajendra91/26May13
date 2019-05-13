package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@RestController
public class AppController {
	
	@Autowired
	public EmployeeDao employeeDao;
	
	@Autowired
	public DepartmentDao departmentDao;
	
	@PostConstruct
	public void add() {
		
		



		Department dept1=new Department("java","5");
		Department dept2=new Department("php","6");
		Department dept3=new Department("dot","7");
		Department dept4=new Department("c++","8");

		departmentDao.save(dept1);
		departmentDao.save(dept2);
		departmentDao.save(dept3);
		departmentDao.save(dept4);

		Set<Department> dset1 =new HashSet<Department>();
		dset1.add(dept1);dset1.add(dept2);dset1.add(dept3);dset1.add(dept4);


		Set<Department> dset2 =new HashSet<Department>();
		dset2.add(dept1);dset2.add(dept4);

		Employee emp1=new Employee(1,"ajendra","25",dset1);
		Employee emp2=new Employee(2,"manish","75",dset2);

		//employeeDao.save(emp1);
		//employeeDao.save(emp2);

		employeeDao.save(new HashSet<Employee>() {{
			add(emp1);
			add(emp2);
		}});
		
	}
	
	//@ManyToOne
	//@JoinColumn(name = "forumId")
	//private Forum forum;
	
	
}
