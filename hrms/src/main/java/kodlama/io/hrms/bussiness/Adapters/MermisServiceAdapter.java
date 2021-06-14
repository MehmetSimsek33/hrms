package kodlama.io.hrms.bussiness.Adapters;




import java.util.Locale;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.bussiness.abstracts.CandidateCheckServices;
import kodlama.io.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;
@Service
public class MermisServiceAdapter implements CandidateCheckServices {

	@Override
	public boolean checkIfRealPerson(Candidate candidates) {
			try {
	            KPSPublicSoap client = new KPSPublicSoapProxy();

	            boolean isValid = client.TCKimlikNoDogrula(
	            		Long.valueOf(candidates.getIdentificationNumber()),
	            		candidates.getFirstName().toUpperCase(new Locale("tr")),
	            		candidates.getLastName().toUpperCase(new Locale("tr"))
	            		,candidates.getBirthDate().getYear());
	            System.out.println(isValid);
	            return isValid;
	            
	        } catch (Exception e) {

	            System.out.println("Giriş bilgileri doğru değil");
	        }
			
			return false;
			
		}
	

}