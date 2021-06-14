package kodlama.io.hrms.core.utilities.config;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlama.io.hrms.core.utilities.cloudinary.CloudinaryImageManager;
import kodlama.io.hrms.core.utilities.cloudinary.ImageUploadService;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class AppConfiguration {


    @Bean
    public Cloudinary cloudinaryService(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dx3jsfibq",
                "api_key", "887343544833199",
                "api_secret", "7p9st9dqSOp-fGh9smE32etDvNI"));
    }


    @Bean
    public ImageUploadService imageService(){
        return new CloudinaryImageManager(cloudinaryService());
    }
}