package kodlama.io.hrms.core.utilities.Adapters;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.core.utilities.abstracts.VerificationEmailService;
import kodlama.io.hrms.core.utilities.verificaitonEmail.VerificationEmailManager;
@Service
public class VerificationEmailManagerAdapter implements VerificationEmailService{
	
	VerificationEmailManager email = new VerificationEmailManager();
	@Override
	public Boolean verificationEmail(String message) {
		email.verificationEmail(message);
		return true;
	

	}

}