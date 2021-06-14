package kodlama.io.hrms.bussiness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlama.io.hrms.bussiness.abstracts.CvService;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperUtils;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.core.utilities.result.SuccessDataResult;
import kodlama.io.hrms.core.utilities.result.SuccesResult;
import kodlama.io.hrms.dataAccess.abstracts.CvDao;
import kodlama.io.hrms.entities.concretes.Cv;
import kodlama.io.hrms.entities.dto.CvDetailDto;
import kodlama.io.hrms.entities.dto.CvDto;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CvManager implements CvService {
	@Autowired
	CvDao cvDao;
	
	

	@Override
	public Result add(CvDto cvdto) {
	
		return new SuccesResult("Cv ekleme başarılı");
	}


	@Override
	public DataResult<List<CvDto>> getAllCvDto() {
		return new SuccessDataResult<List<CvDto>>(ModelMapperUtils.toList(
				this.cvDao.findAll(),
				CvDto.class)
				);
	}


	@Override
	public DataResult<List<CvDetailDto>> getDetailDtoById(int id) {
		return new SuccessDataResult<List<CvDetailDto>>(ModelMapperUtils.toList(
				this.cvDao.findAll(),
				CvDetailDto.class)
				);
	}

	@Override
	public DataResult<List<Cv>> getAll() {
		return new SuccessDataResult<List<Cv>>(this.cvDao.findAll());
	}


	
	


	

}
