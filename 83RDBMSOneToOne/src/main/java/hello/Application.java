package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(DucatJpaOneToOneApplication.class, args);
		
		
		ApplicationContext ctx=SpringApplication.run(Application.class, args);
		EmployeeDao dao=(EmployeeDao)ctx.getBean("employeeDao");
		System.out.println("Saving country objects...");
		
		Employee c1=new Employee(1,"java","India",new Department("President","R.N.Kovind"));
		Employee c2=new Employee(2,"php","UK",new Department("Queen","Elizabeth II"));
		dao.save(c1);
		dao.save(c2);
		System.out.println("Successfully saved.");
		System.out.println("Fetching all Countries...");
		
		
		Iterable<Employee> itr=dao.findAll();
		System.out.println("Country\tHOS Title\tHos Name");
		for(Employee c : itr)
			{
			
				 Department hos=c.department;
				 System.out.println(c.name+"\t"+
				 hos.length+"\t"+hos.dname);
			 
			}
		
	}

}
