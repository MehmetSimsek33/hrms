package kodlama.io.hrms.bussiness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.bussiness.abstracts.SchoolService;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperUtils;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.core.utilities.result.SuccesResult;
import kodlama.io.hrms.core.utilities.result.SuccessDataResult;
import kodlama.io.hrms.dataAccess.abstracts.SchoolDao;
import kodlama.io.hrms.entities.concretes.Language;
import kodlama.io.hrms.entities.concretes.School;
import kodlama.io.hrms.entities.dto.CvLanguageDetailDto;
import kodlama.io.hrms.entities.dto.SchoolDto;
@Service
public class SchoolManager implements SchoolService {
	@Autowired
	SchoolDao schooldao;
	@Override
	public DataResult<List<SchoolDto>> getallSchoolDto() {
		return new SuccessDataResult<List<SchoolDto>>(ModelMapperUtils.toList(
				this.schooldao.findAll(),
				SchoolDto.class)
				);
	}
	@Override
	public DataResult<List<School>> getByCvId(int cvId) {
		   return new SuccessDataResult<List<School>>(this.schooldao.findByCvId(cvId),"Listelendi");
	}
	@Override
	public Result add(School school) {
		this.schooldao.save(school);
		return new SuccesResult("basarili");
	}
	@Override
	public Result deleteSchool(int schoolId) {
		this.schooldao.deleteById(schoolId);
		return new SuccesResult("basarili");
	}

}
