package kodlama.io.hrms.entities.dto;

import java.time.LocalDate;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDto {


	private String schoolName;
	private String section;
	private LocalDate yearOfEntry;
	private LocalDate yearOfGraduation;
}
