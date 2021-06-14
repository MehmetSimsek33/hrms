package kodlama.io.hrms.bussiness.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.bussiness.abstracts.EmployeService;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.core.utilities.result.SuccesResult;
import kodlama.io.hrms.dataAccess.abstracts.EmployeDao;
import kodlama.io.hrms.entities.concretes.Employe;
import kodlama.io.hrms.entities.concretes.Employer;

@Service
public class EmployeManager implements EmployeService {


	@Autowired
	EmployeDao employeDao;

	@Override
	public Result confirm(Employer employer) {

		return new SuccesResult("Sistem çalışanı tarafından" + employer.getCompanyName() + " adlı firma doğrulandı.");
	}

	@Override
	public Result add(Employe employe) {
		this.employeDao.save(employe);
		return new SuccesResult("Kullanıcı başarıyla eklendi");

	}

}