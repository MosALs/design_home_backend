package com.home.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.home.View.UserSearchView;

@Repository
public interface UserSearchViewRepository extends JpaRepository<UserSearchView, Integer>{
	

}
