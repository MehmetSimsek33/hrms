package kodlama.io.hrms.bussiness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlama.io.hrms.bussiness.abstracts.LanguageService;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperUtils;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.core.utilities.result.SuccessDataResult;
import kodlama.io.hrms.core.utilities.result.SuccesResult;
import kodlama.io.hrms.dataAccess.abstracts.LanguageDao;
import kodlama.io.hrms.entities.concretes.Language;
import kodlama.io.hrms.entities.dto.CvLanguageDetailDto;
@Service
public class LanguageManager implements LanguageService{
	
	private LanguageDao languageDao;
	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}
	@Override
	public DataResult<List<CvLanguageDetailDto>> getAllCvLanguageDetailDto() {
		return new SuccessDataResult<List<CvLanguageDetailDto>>(ModelMapperUtils.toList(
				this.languageDao.findAll(),
				CvLanguageDetailDto.class)
				);
	}
	@Override
	public Result add(Language language) {
		this.languageDao.save(language);
		return new SuccesResult("basarili");
	}

	@Override
	public DataResult<List<Language>> getall() {
		return new SuccessDataResult<List<Language>>(this.languageDao.findAll());
	}

	

	 @Override
	    public DataResult<List<Language>> getByCvId(int cvId) {
	      
	        return new SuccessDataResult<List<Language>>(this.languageDao.findByCvId(cvId),"Listelendi");
	    }
	@Override
	public Result deleteLanguage(int languageId) {
		this.languageDao.deleteById(languageId);
		return new SuccesResult("basarili");
	}
	

	

}
