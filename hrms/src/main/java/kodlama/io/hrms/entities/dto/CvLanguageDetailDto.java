package kodlama.io.hrms.entities.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CvLanguageDetailDto {
	private String languageName;
    private int level;
}
