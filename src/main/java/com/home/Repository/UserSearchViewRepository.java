package com.home.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.home.DTO.PageableDTO;
import com.home.DTO.UserSearchDto;
import com.home.View.UserSearchView;

@Repository
public interface UserSearchViewRepository extends JpaRepository<UserSearchView, Integer> ,JpaSpecificationExecutor<UserSearchView>{
	
	

}
