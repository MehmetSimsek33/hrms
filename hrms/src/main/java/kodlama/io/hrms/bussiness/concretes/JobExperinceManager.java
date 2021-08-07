package kodlama.io.hrms.bussiness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.bussiness.abstracts.JobExperinceService;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperUtils;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.core.utilities.result.SuccesResult;
import kodlama.io.hrms.core.utilities.result.SuccessDataResult;
import kodlama.io.hrms.dataAccess.abstracts.jobExperinceDao;
import kodlama.io.hrms.entities.concretes.JobExperince;
import kodlama.io.hrms.entities.concretes.Language;
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


	@Override
	public DataResult<List<JobExperince>> getByCvId(int cvId) {
		   return new SuccessDataResult<List<JobExperince>>(this.jobexperincedao.findByCvId(cvId),"Listelendi");
	}


	@Override
	public Result add(JobExperince jobExperince) {
		 
				this.jobexperincedao.save(jobExperince);
				return new SuccesResult("basarili");
	}


	@Override
	public Result deleteJobExperince(int jobExperinceId) {
		this.jobexperincedao.deleteById(jobExperinceId);
		return new SuccesResult("basarili");
	}
}
