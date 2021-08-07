package kodlama.io.hrms.entities.concretes;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.Nullable;

@Data
@Entity
@Table(name = "cvs")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "schools", "languages",
	"images","job_experiences","candidates","skills" })
public class Cv {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "github_address")
	private String gitHubAddress;

	@Column(name = "linkedln_address")
	private String linkedlnAddress;

	@Column(name = "cover_letter")
	private String coverLetter;

	 @Column(name = "skill")
	 	private String skill;

	@OneToMany(mappedBy = "cv")
	private List<Skill> skills;
	@OneToMany(mappedBy = "cv")
	private List<Language> languages;

	@OneToMany(mappedBy = "cv")
	private List<School> schools;
	
	@OneToMany(mappedBy = "cv")
	private List<JobExperince> job_experiences;

	 @OneToOne(mappedBy = "cv")
     @JsonIgnore
	  private Image image;

	 	@OneToOne(optional = false, fetch = FetchType.LAZY)
		@JoinColumn(name = "candidate_id")
		private Candidate candidate;
	

}