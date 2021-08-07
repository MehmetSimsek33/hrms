package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.hrms.entities.concretes.Cv;
import kodlama.io.hrms.entities.dto.CvDto;



public interface CvDao extends JpaRepository<Cv, Integer> {
	
	Cv getCvsById(int id);

}