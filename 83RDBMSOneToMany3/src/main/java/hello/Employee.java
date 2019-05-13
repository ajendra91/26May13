package hello;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Employee {
	
	@Id
	@GeneratedValue
	public int id;
	public String name;
	public String age;
	@OneToMany(cascade={CascadeType.ALL})
	//@JoinColumn(name="did")
	public Set<Department> dset;
	
	public Employee(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Employee(int id, String name, String age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	
	
	
	
	
	

}
