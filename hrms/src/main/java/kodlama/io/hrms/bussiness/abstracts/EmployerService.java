package kodlama.io.hrms.bussiness.abstracts;

import java.util.List;


import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.dto.EmployerForRegisterDto;


public interface EmployerService {
	Result add(EmployerForRegisterDto employerForRegisterDto);

	DataResult<List<Employer>> getAll();
}