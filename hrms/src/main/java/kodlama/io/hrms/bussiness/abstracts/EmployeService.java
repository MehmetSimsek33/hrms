package kodlama.io.hrms.bussiness.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.Employe;
import kodlama.io.hrms.entities.concretes.Employer;

public interface EmployeService {
	Result confirm(Employer employer);

	Result add(Employe employe);
	Result update(Employe employe);
	DataResult<List<Employe>> getAll();
	DataResult<Employe> getByEmployeId(int id);
}