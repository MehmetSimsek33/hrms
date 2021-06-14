package kodlama.io.hrms.bussiness.abstracts;


import java.util.List;

import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.dto.CandidateForRegisterDto;

public interface CandidateService {
	
	DataResult<List<Candidate>> getAll();

	Result add(CandidateForRegisterDto candidateForRegisterDto);	

	
	
}
