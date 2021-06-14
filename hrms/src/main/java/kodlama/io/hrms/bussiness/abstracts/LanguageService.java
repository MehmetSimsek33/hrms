package kodlama.io.hrms.bussiness.abstracts;

import java.util.List;


import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;

import kodlama.io.hrms.entities.concretes.Language;
import kodlama.io.hrms.entities.dto.CvLanguageDetailDto;



public interface LanguageService {
	DataResult<List<CvLanguageDetailDto>> getAllCvLanguageDetailDto();
	Result add(Language language); 
	
}
