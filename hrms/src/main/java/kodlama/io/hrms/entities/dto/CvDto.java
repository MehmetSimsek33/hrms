package kodlama.io.hrms.entities.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {

	private int id;
	@JsonProperty("firstName")
	private String candidateFirstName;
	@JsonProperty("lastName")
	private String candidateLastName;
	private String gitHubAddress;
	private String linkedlnAddress;
	private String coverLetter;
	private String skill;
	public List<CvLanguageDetailDto> languages;
	public List<SchoolDto> schools;
	public List<jobExperinceDto> job_experiences;
	;
	

}
