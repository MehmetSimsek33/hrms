package kodlama.io.hrms.bussiness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kodlama.io.hrms.bussiness.abstracts.UserService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.SuccessDataResult;
import kodlama.io.hrms.dataAccess.abstracts.UserDao;
import kodlama.io.hrms.entities.concretes.User;



public class UserManager implements UserService {
	@Autowired
	UserDao userdao;
	
	@Override
	public 	DataResult<List<User>> getAll() {
		
		return new SuccessDataResult<List<User>>(userdao.findAll(),"Listeleme basarili");
	}
	





}
