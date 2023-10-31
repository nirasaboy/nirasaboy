package in.ashokit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Table;

import lombok.Data;
@Entity
//@Table(name = "CITIZEN_APPS")//
@Data
public class CitizenAppEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appid;
	private String fullname;
	private String email;
	private Long phno;
	private String ssn;
	private String gender;
	private Integer dob;
	
	

}
