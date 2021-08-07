package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import kodlama.io.hrms.entities.concretes.JobPosting;
import kodlama.io.hrms.entities.dto.JobAdFilter;


public interface JobPostingDao extends JpaRepository<JobPosting, Integer>{
	List<JobPosting> getByStatus(boolean status);
	
	JobPosting getById(int id);
	
	List<JobPosting> getByStatus(boolean status, Sort sort);

	List<JobPosting> getByStatusAndEmployerId(boolean status, int employerId);
	@Modifying
	@Transactional
	@Query("update JobPosting set status=:status where id=:id ")
	int updateStatus(@Param("status") int status, @Param("id") int id);
	
	 @Query("Select j from kodlama.io.hrms.entities.concretes.JobPosting j where"
			 
			 	+ " ((:#{#filter.cityId}) IS 0 OR j.city.id IN (:#{#filter.cityId}))"
				+ " and ((:#{#filter.typeOfWorkId}) IS 0 OR j.typeOfWork.id IN (:#{#filter.typeOfWorkId}))"
				+ " and ((:#{#filter.workingTimeId}) IS 0 OR j.workingTime.id IN (:#{#filter.workingTimeId}))"
				+ " and j.status=1")
	    public Page<JobPosting> getByFilter(@Param("filter") JobAdFilter jobAdFilter, Pageable pageable);
}
