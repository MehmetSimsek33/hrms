package kodlama.io.hrms.entities.dto;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class jobExperinceDto {
	private String businessName;	
	private String section;
	private LocalDate startDate;
	private LocalDate finishDate;
}
