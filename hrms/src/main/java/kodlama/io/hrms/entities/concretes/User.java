package kodlama.io.hrms.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

@Entity
@Data
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id")
	    private int id;
	
		@NotBlank
		@NotNull
	    @Column(name="email_address")
	    private String emailAdress;
		@NotBlank
		@NotNull
	    @Column(name="password")
	    private String password;
	    

	    
}
