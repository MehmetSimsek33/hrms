package kodlama.io.hrms.core.utilities.cloudinary;

import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.core.utilities.result.DataResult;

public interface ImageUploadService {
	
	DataResult<?> save(MultipartFile image);
}
