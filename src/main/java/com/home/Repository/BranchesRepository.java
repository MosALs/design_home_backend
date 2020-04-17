package com.home.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.home.Entity.Branches;

@Repository
public interface BranchesRepository extends JpaRepository<Branches, Integer>{
	
	
	@Modifying()
	@Transactional
	@Query(value = "UPDATE Branches b SET b.addresName=:newaddresName WHERE b.addresName=:oldaddresName")
	int updateArea(@Param("newaddresName") String newAreaName, @Param("newaddresName") String oldAreaName);

}
