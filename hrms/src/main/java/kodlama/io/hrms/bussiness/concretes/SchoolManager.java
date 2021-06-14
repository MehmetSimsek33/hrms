package kodlama.io.hrms.bussiness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.bussiness.abstracts.SchoolService;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperUtils;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.SuccessDataResult;
import kodlama.io.hrms.dataAccess.abstracts.SchoolDao;
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

}
