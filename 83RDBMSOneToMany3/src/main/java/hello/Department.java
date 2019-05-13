package hello;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Department {
	
	@Id
	@GeneratedValue
	public int did;
	public String dname;
	public String length;
	
	public Department(String dname, String length) {
		super();
		this.dname = dname;
		this.length = length;
	}
	

	
	
}
