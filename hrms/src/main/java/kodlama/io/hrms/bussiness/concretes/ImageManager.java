package kodlama.io.hrms.bussiness.concretes;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.bussiness.abstracts.ImageService;
import kodlama.io.hrms.core.utilities.cloudinary.ImageUploadService;
import kodlama.io.hrms.core.utilities.result.Result;
import kodlama.io.hrms.core.utilities.result.SuccesResult;
import kodlama.io.hrms.dataAccess.abstracts.ImageDao;
import kodlama.io.hrms.entities.concretes.Image;


import java.util.Map;
@Service
public class ImageManager implements ImageService {

	
	
	  private ImageDao imageDao;;
	  private ImageUploadService cloudinaryService;
	  @Autowired
	  public ImageManager(ImageDao imageDao, ImageUploadService cloudinaryService) {
		super();
		this.imageDao = imageDao;
		this.cloudinaryService = cloudinaryService;
	}
	

	 
	 
	 @Override
		public Result add(Image image) {
			this.imageDao.save(image);
			return new SuccesResult();
		}
	 
	 @Override
		public Result add(Image image, MultipartFile file) {
		   Map<String,String> result = (Map<String,String>) this.cloudinaryService.save(file).getData();
			String url = result.get("url");
			image.setImageUrl(url);
			image.setUploadedDate(LocalDate.now());
		
			return add(image);

		}
	

}