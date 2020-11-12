package com.home.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.home.View.UserSearchView;

@Repository
public interface UserSearchViewRepository extends JpaRepository<UserSearchView, Integer>,
JpaSpecificationExecutor<UserSearchView>{

	UserSearchView findAllById(int id);
	List<UserSearchView> findByName(String shopName);
	
	
	

}
