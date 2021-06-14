package kodlama.io.hrms.bussiness.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.bussiness.abstracts.CandidateCheckServices;
import kodlama.io.hrms.bussiness.abstracts.CandidateService;
import kodlama.io.hrms.core.utilities.abstracts.VerificationEmailService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.ErrorResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.core.utilities.result.SuccessDataResult;
import kodlama.io.hrms.dataAccess.abstracts.CandidateDao;
import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.dto.CandidateForRegisterDto;
import lombok.var;

@Service
public class CandidateManager implements CandidateService {
	@Autowired
	CandidateDao candidateDao;
	@Autowired
	CandidateCheckServices candidateCheckService;
	@Autowired
	VerificationEmailService verificationEmailService;

	@Override
	public Result add(CandidateForRegisterDto candidateForRegisterDto) {
		var candidate = new Candidate();
		candidate.setId(candidateForRegisterDto.getId());
		candidate.setFirstName(candidateForRegisterDto.getFirstName());
		candidate.setLastName(candidateForRegisterDto.getLastName());
		candidate.setBirthDate(LocalDate.parse(candidateForRegisterDto.getBirthDate()));
		candidate.setIdentificationNumber(candidateForRegisterDto.getIdentificationNumber());
		candidate.setEmailAdress(candidateForRegisterDto.getEmailAdress());
		candidate.setPassword(candidateForRegisterDto.getPassword());
		if (mandatoryField(candidate)) {
			if (identificationNumberAndEmail(candidate)) {
				if (candidate.getPassword().equals(candidateForRegisterDto.getRepeatPassword()))  {
					if (this.candidateCheckService.checkIfRealPerson(candidate)) {

						if (verificationLink()) {
							this.candidateDao.save(candidate);

						} else {
							return new ErrorResult("Kullanıcı doğrulama linkine tıklamadığı için kayıt başarısız !");
						}

					}
					else {

						return new ErrorResult("Mernis Dogrulanamadi.");
						}
				} 
				else {

					return new ErrorResult("Yazdığınız şifreler birbiriyle uyuşmuyor lütfen kontrol ediniz.");
				}

			} else {
				return new ErrorResult("Email veya TC Kimlik numaranız sistemde zaten kayıtlı !");
			}
		} else {
			return new ErrorResult("Hiç bir alan boş geçilemez !");
		}
		return null;

	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll());
	}

	private boolean verificationLink() {
		Boolean aBoolean = this.verificationEmailService.verificationEmail("Link kullanıcıya ulaştı.");
		if (aBoolean) {
			System.out.println("Kullanıcı doğrulama linkine tıkladı.");
			return true;
		} else {

			return false;
		}
	}

	private boolean mandatoryField(Candidate candidate) {
		if (candidate.getBirthDate() != null && candidate.getEmailAdress() != "" && candidate.getFirstName() != ""
				&& candidate.getLastName() != "" && candidate.getPassword() != "") {
			return true;
		} else {

			return false;
		}
	}

	private boolean identificationNumberAndEmail(Candidate candidate) {
		for (Candidate emailcheck : this.candidateDao.findAll()) {
			if (emailcheck.getIdentificationNumber().equals(candidate.getIdentificationNumber())
					|| emailcheck.getEmailAdress().equals(candidate.getEmailAdress())) {

				return false;

			} else {
				return true;
			}

		}
		return false;
	}

}