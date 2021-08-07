package kodlama.io.hrms.bussiness.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.entities.concretes.WorkingTime;

public interface WorkingTimeService {
	
	DataResult<List<WorkingTime>> getAll();


}
