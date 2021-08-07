package kodlama.io.hrms.bussiness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.bussiness.abstracts.EmployeService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.ErrorDataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.core.utilities.result.SuccesResult;
import kodlama.io.hrms.core.utilities.result.SuccessDataResult;
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

	@Override
	public DataResult<List<Employe>> getAll() {
		return new SuccessDataResult<List<Employe>>(this.employeDao.findAll());
	}

	@Override
	public DataResult<Employe> getByEmployeId(int id) {
		return new SuccessDataResult<Employe>(this.employeDao.getEmployesById(id));

}

	@Override
	public Result update(Employe employe) {
		this.employeDao.save(employe);
		return new SuccesResult("Guncelleme başarili");
	}}