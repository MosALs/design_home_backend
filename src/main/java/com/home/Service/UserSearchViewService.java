package com.home.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.home.View.UserSearchView;


@Service
public interface UserSearchViewService {

	List <UserSearchView> getAllView();
	
	
	
}
