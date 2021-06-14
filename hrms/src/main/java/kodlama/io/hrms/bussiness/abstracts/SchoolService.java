package kodlama.io.hrms.bussiness.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.entities.dto.SchoolDto;

public interface SchoolService {


	DataResult<List<SchoolDto>> getallSchoolDto();
}
