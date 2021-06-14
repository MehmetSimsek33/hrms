package kodlama.io.hrms.core.utilities.cloudinary;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import kodlama.io.hrms.core.utilities.result.DataResult;
import kodlama.io.hrms.core.utilities.result.ErrorDataResult;
import kodlama.io.hrms.core.utilities.result.SuccessDataResult;


public class CloudinaryImageManager implements ImageUploadService{

	private Cloudinary cloudinary;

	@Autowired
	public CloudinaryImageManager(Cloudinary cloudinary) {
		super();
		this.cloudinary = cloudinary;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public DataResult<?> save(MultipartFile file) {
		try {
			Map cloudinaryUploader = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(cloudinaryUploader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ErrorDataResult<Map>();
	}

}
