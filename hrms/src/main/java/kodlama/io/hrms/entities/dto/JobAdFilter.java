package kodlama.io.hrms.entities.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdFilter {

	private int cityId;
	private int typeOfWorkId;
	private int workingTimeId;
}
