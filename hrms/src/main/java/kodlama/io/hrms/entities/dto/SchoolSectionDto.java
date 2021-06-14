package kodlama.io.hrms.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
 public class SchoolSectionDto {

	private int id;
	private String schoolName;
	private String sectionName;

}
