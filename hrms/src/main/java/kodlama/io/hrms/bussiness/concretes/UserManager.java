package kodlama.io.hrms.bussiness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.bussiness.abstracts.UserService;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.SuccessDataResult;
import kodlama.io.hrms.dataAccess.abstracts.UserDao;
import kodlama.io.hrms.entities.concretes.User;


@Service
public class UserManager implements UserService {
	@Autowired
	UserDao userDao;
	
	@Override
	public 	DataResult<List<User>> getAll() {
		
		return new SuccessDataResult<List<User>>(userDao.findAll(),"Listeleme basarili");
	}

    @Override
    public User get(int id) {
        return userDao.findById(id).get();
    }

    @Override
    public User getByEmail(String email) {
        return this.userDao.getByemailAdress(email);
    }



}
