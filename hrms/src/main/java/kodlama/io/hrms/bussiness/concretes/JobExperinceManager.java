package kodlama.io.hrms.bussiness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.bussiness.abstracts.JobExperinceService;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperUtils;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.SuccessDataResult;
import kodlama.io.hrms.dataAccess.abstracts.jobExperinceDao;
import kodlama.io.hrms.entities.dto.CvDetailDto;
import kodlama.io.hrms.entities.dto.CvLanguageDetailDto;
import kodlama.io.hrms.entities.dto.jobExperinceDto;

@Service
public class JobExperinceManager implements JobExperinceService {
	@Autowired
	jobExperinceDao jobexperincedao;

	
	@Override
	public DataResult<List<jobExperinceDto>> getalljobExperinceDto() {
			return new SuccessDataResult<List<jobExperinceDto>>(ModelMapperUtils.toList(
					this.jobexperincedao.findAll(),
					jobExperinceDto.class)
					);
		}
}
