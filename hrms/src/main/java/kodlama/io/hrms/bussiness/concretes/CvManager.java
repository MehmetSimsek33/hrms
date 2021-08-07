package kodlama.io.hrms.bussiness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;

import kodlama.io.hrms.bussiness.abstracts.CvService;
import kodlama.io.hrms.core.utilities.mappers.ModelMapperUtils;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.core.utilities.result.SuccessDataResult;
import kodlama.io.hrms.core.utilities.result.SuccesResult;
import kodlama.io.hrms.dataAccess.abstracts.CvDao;
import kodlama.io.hrms.entities.concretes.Cv;

import kodlama.io.hrms.entities.dto.CvDto;
import lombok.RequiredArgsConstructor;


@Service

public class CvManager implements CvService {
	@Autowired
	CvDao cvDao;
	
	

	@Override
	public Result add(Cv cv) {
	
		this.cvDao.save(cv);
		return new SuccesResult("Cv ekleme başarılı");
	}

	@Override
	public Result update(Cv cv) {
	
		this.cvDao.save(cv);
		return new SuccesResult("Cv güncelleme başarılı");
	}

	@Override
	public DataResult<List<CvDto>> getAllCvDto() {
		return new SuccessDataResult<List<CvDto>>(ModelMapperUtils.toList(
				this.cvDao.findAll(),
				CvDto.class), null
				);
	}



	@Override
	public DataResult<List<Cv>> getAll() {
		return new SuccessDataResult<List<Cv>>(this.cvDao.findAll());
	}

	@Override
	public DataResult<Cv> getByCvId(int id) {

		return  new SuccessDataResult<Cv>(this.cvDao.getCvsById(id));
	}

	@Override
	public DataResult<CvDto> getByCvDto(int id) {
	
		
		return new SuccessDataResult<CvDto>(ModelMapperUtils.maping(
				this.cvDao.getCvsById(id),
				CvDto.class),null
				);
	}

	@Override
	public Result updateGithub(String gitHubAddress, int cvId) {
	     Cv cv=this.cvDao.getCvsById(cvId);
	        cv.setGitHubAddress(gitHubAddress);
	        this.cvDao.save(cv);
	    	return new SuccesResult("Güncelleme başarılı");
	}

	@Override
	public Result deleteGithub(int cvId) {
		Cv cv=this.cvDao.getCvsById(cvId);
		cv.setGitHubAddress(null);
		  this.cvDao.save(cv);
		    return new SuccesResult("Güncelleme başarılı");
	}

	@Override
	public Result updateLinkedln(String linkedlnAddress, int cvId) {
		  Cv cv=this.cvDao.getCvsById(cvId);
	        cv.setLinkedlnAddress(linkedlnAddress);
	        this.cvDao.save(cv);
	    	return new SuccesResult("Güncelleme başarılı");
	}

	@Override
	public Result deleteLinkedln(int cvId) {
		Cv cv=this.cvDao.getCvsById(cvId);
		cv.setLinkedlnAddress(null);
	    this.cvDao.save(cv);
	    return new SuccesResult("Güncelleme başarılı");
	}

	

	

	
	
	}

	
	




	
	


	


