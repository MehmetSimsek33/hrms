package kodlama.io.hrms.bussiness.abstracts;

import java.util.List;


import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.TempEmployer;
import kodlama.io.hrms.entities.dto.EmployerForRegisterDto;


public interface EmployerService {
	Result add(EmployerForRegisterDto employerForRegisterDto);
	DataResult<Employer> getById(int id);
	public Result deleteTempEmploye(int tempEmployeId);
	DataResult<List<Employer>> getAll();
	DataResult<List<TempEmployer>> getAllTempEmployer();
	Result Update(Employer employer);
	Result updateTemp(TempEmployer tempEmployer);
	Result verifyUpdate(int empId);
}