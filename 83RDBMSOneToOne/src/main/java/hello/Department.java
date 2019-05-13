package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
