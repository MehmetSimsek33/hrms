package kodlama.io.hrms.entities.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class CvDetailDto {
	

	@JsonProperty("qualificationInformations")
	
	public List<CvLanguageDetailDto> resumeQualifications;
}
