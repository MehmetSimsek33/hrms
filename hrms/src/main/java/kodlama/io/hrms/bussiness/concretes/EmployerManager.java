package kodlama.io.hrms.bussiness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.bussiness.abstracts.EmployeService;
import kodlama.io.hrms.bussiness.abstracts.EmployerService;

import kodlama.io.hrms.core.utilities.abstracts.VerificationEmailService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.ErrorResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.core.utilities.result.SuccessDataResult;
import kodlama.io.hrms.core.utilities.result.SuccesResult;
import kodlama.io.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrms.dataAccess.abstracts.TempEmployerDao;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.TempEmployer;
import kodlama.io.hrms.entities.dto.EmployerForRegisterDto;
import lombok.var;

@Service
public class EmployerManager implements EmployerService {

	@Autowired
	EmployerDao employerDao;
	@Autowired
	VerificationEmailService verificationEmailService;
	@Autowired
	EmployeService employeService;
	@Autowired
	TempEmployerDao tempEmployerDao;
	
	@Override
	public Result add(EmployerForRegisterDto employerForRegisterDto) {
		var employer = new Employer();
		employer.setId(employerForRegisterDto.getId());
		employer.setCompanyName(employerForRegisterDto.getCompanyName());
		employer.setWebAddress(employerForRegisterDto.getWebAddress());
		employer.setEmailAdress(employerForRegisterDto.getEmailAdress());
		employer.setPassword(employerForRegisterDto.getPassword());

		if (employer.getPassword().equals(employerForRegisterDto.getRepeatPassword())) {
			if (employer.getCompanyName() != null && employer.getEmailAdress() != null
					&& employer.getPassword() != null && employer.getWebAddress() != null) {
				this.employerDao.save(employer);
				if (verificationLink()) {
					this.employerDao.save(employer);
					return new SuccesResult("Kullan??c?? ba??ar??yla eklendi");
				}

				else if (this.employeService.confirm(employer) != null) {

					this.employerDao.save(employer);
					return new SuccesResult("Kullan??c?? ba??ar??yla eklendi");

				} else {
					return new ErrorResult("Kullan??c?? do??rulama linkine t??klamad?????? i??in kayd?? ge??ersiz say??ld??.");
				}

			} else {

				return new ErrorResult("B??t??n alanlar??n doldurulmas?? zorunludur !");
			}
		} else {
			return new ErrorResult("Yazd??????n??z ??ifreler birbiriyle uyu??muyor l??tfen kontrol ediniz.");
		}

	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

	private boolean verificationLink() {
		Boolean aBoolean = this.verificationEmailService.verificationEmail("Link kullan??c??ya ula??t??.");
		if (!aBoolean) {
			System.out.println("Kullan??c?? do??rulama linkine t??klad??.");
			return true;
		} else {

			return false;
		}
	}

	@Override
	public Result Update(Employer employer) {
		this.employerDao.save(employer);
		return new SuccesResult("Employer g??ncellendi");
	
	}

	@Override
	public Result updateTemp(TempEmployer tempEmployer) {
		tempEmployer.setId(0);
		 Employer employer=this.employerDao.getById(tempEmployer.getEmpId());
		 this.tempEmployerDao.save(tempEmployer);
		 employer.setStatusUpdate(true);
		 this.employerDao.save(employer);
		 return new SuccesResult("G??ncelleme iste??i g??nderildi");
	}

	@Override
	public DataResult<Employer> getById(int id) {
		  return new SuccessDataResult<Employer>(this.employerDao.getById(id),"Data listelendi");
	}

	@Override
	public Result verifyUpdate(int empId) {
		 if(!this.tempEmployerDao.existsById(empId)){
	            return new ErrorResult("B??yle bir g??ncelleme talebi yok");
	        }
		TempEmployer tempEmployer=this.tempEmployerDao.findById(empId);
		Employer employer=this.employerDao.getById(tempEmployer.getEmpId());
		 tempEmployer.setVerifyed(true);
		 this.tempEmployerDao.save(tempEmployer);
		 
		 employer.setEmailAdress(tempEmployer.getEmail());
		 employer.setCompanyName(tempEmployer.getCompanyName());
		 employer.setPhone(tempEmployer.getPhone());
		 employer.setWebAddress(tempEmployer.getWebAddress());
		 employer.setStatusUpdate(false);
		 this.employerDao.save(employer);
		 deleteTempEmploye(empId);
		  return new SuccesResult("Bilgiler g??ncellendi");
	}

	@Override
	public DataResult<List<TempEmployer>> getAllTempEmployer() {
		return new SuccessDataResult<List<TempEmployer>>(this.tempEmployerDao.findAll());
	}

	@Override
	public Result deleteTempEmploye(int tempEmployeId) {
		TempEmployer tempEmployer=this.tempEmployerDao.findById(tempEmployeId);
		Employer employer=this.employerDao.getById(tempEmployer.getEmpId());
		this.tempEmployerDao.deleteById(tempEmployeId);
		 employer.setStatusUpdate(false);
		 this.employerDao.save(employer);
		return new SuccesResult("basarili");
	}



	}

