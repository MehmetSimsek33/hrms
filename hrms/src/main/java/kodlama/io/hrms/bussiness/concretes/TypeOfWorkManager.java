package kodlama.io.hrms.bussiness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.bussiness.abstracts.TypeOfWorkService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.SuccessDataResult;
import kodlama.io.hrms.dataAccess.abstracts.TypeOfWorkDao;
import kodlama.io.hrms.entities.concretes.TypeOfWork;

@Service
public class TypeOfWorkManager implements TypeOfWorkService {

	@Autowired
	private TypeOfWorkDao typeOfWorkDao;

	@Override
	public DataResult<List<TypeOfWork>> getAll() {
	return new SuccessDataResult<List<TypeOfWork>>(this.typeOfWorkDao.findAll());
	}

}