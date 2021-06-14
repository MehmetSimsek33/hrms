package kodlama.io.hrms.bussiness.abstracts;

import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.entities.concretes.Image;

public interface ImageService {
	
	Result add(Image image);
	Result add(Image image, MultipartFile file);

}
