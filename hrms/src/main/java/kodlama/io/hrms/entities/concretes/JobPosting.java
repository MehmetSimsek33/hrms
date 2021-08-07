package kodlama.io.hrms.entities.concretes;

import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "job_postings")
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "favoriteJobPostings" })
public class JobPosting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "min_salary")
	private int minSalary;
	@Column(name = "max_salary")
	private int maxSalary;
	@Column(name = "open_position")
	private String openPosition;
	@Column(name = "last_date")
	private LocalDate lastDate;
	@Column(name = "status")
	private int status;
	@Column(name = "descriptions")
	private String description;
	
	@ManyToOne()
	@JoinColumn(name = "jobtitle_id")
	private JobTitle jobTitle;

	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;

	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;
	@ManyToOne()
	@JoinColumn(name = "typeOfWork_id")
	private TypeOfWork typeOfWork;
	
	@ManyToOne()
	@JoinColumn(name = "workingTime_id")
	private WorkingTime workingTime;
	
	@OneToMany(mappedBy = "jobPosting")
	private List<FavoriteJobPosting> favoriteJobPostings;

}