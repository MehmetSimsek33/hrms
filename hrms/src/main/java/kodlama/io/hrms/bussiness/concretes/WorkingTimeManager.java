package kodlama.io.hrms.bussiness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.bussiness.abstracts.WorkingTimeService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.SuccessDataResult;
import kodlama.io.hrms.dataAccess.abstracts.WorkingTimeDao;
import kodlama.io.hrms.entities.concretes.WorkingTime;



@Service
public class WorkingTimeManager implements WorkingTimeService {
	@Autowired
	private WorkingTimeDao workingTimeDao;

	@Override
	public DataResult<List<WorkingTime>> getAll()
	{
		return new SuccessDataResult<List<WorkingTime>>(this.workingTimeDao.findAll());
	}}