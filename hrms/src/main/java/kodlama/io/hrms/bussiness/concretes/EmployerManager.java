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
import kodlama.io.hrms.entities.concretes.Employer;
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
					return new SuccesResult("Kullanıcı başarıyla eklendi");
				}

				else if (this.employeService.confirm(employer) != null) {

					this.employerDao.save(employer);
					return new SuccesResult("Kullanıcı başarıyla eklendi");

				} else {
					return new ErrorResult("Kullanıcı doğrulama linkine tıklamadığı için kaydı geçersiz sayıldı.");
				}

			} else {

				return new ErrorResult("Bütün alanların doldurulması zorunludur !");
			}
		} else {
			return new ErrorResult("Yazdığınız şifreler birbiriyle uyuşmuyor lütfen kontrol ediniz.");
		}

	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

	private boolean verificationLink() {
		Boolean aBoolean = this.verificationEmailService.verificationEmail("Link kullanıcıya ulaştı.");
		if (!aBoolean) {
			System.out.println("Kullanıcı doğrulama linkine tıkladı.");
			return true;
		} else {

			return false;
		}
	}
	}

