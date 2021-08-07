package kodlama.io.hrms.bussiness.abstracts;

import java.util.List;


import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;

import kodlama.io.hrms.entities.concretes.Language;
import kodlama.io.hrms.entities.dto.CvLanguageDetailDto;



public interface LanguageService {
	DataResult<List<CvLanguageDetailDto>> getAllCvLanguageDetailDto();
	//Result addLanguageDto(CvLanguageDetailDto cvLanguageDetailDto);
	Result add(Language language); 
	public Result deleteLanguage(int languageId);
	DataResult<List<Language>> getall();
	public DataResult<List<Language>> getByCvId(int cvId);
	
}
