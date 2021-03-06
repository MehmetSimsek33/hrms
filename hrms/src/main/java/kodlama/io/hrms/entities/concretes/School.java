package kodlama.io.hrms.entities.concretes;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "schools")
@AllArgsConstructor
@NoArgsConstructor

public class School {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "school_name")
	private String schoolName;

	@Column(name = "section")
	private String section;
	@Column(name = "year_of_entry")
	private LocalDate yearOfEntry;
	
	@Column(name = "year_of_graduation")
	private LocalDate yearOfGraduation;
	
	@ManyToOne()
	@JoinColumn(name = "cv_id")
	private Cv cv;
}