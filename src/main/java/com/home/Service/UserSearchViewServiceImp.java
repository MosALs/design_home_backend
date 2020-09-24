package com.home.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.View.UserSearchView;
import com.home.repositories.UserSearchViewRepository;

@Service
public class UserSearchViewServiceImp implements UserSearchViewService{

	
	@Autowired
	UserSearchViewRepository userSearchViewRepository;
	@Override
	public List<UserSearchView> getAllView() {
		System.out.println("wwewewewewe");
		List<UserSearchView> list= userSearchViewRepository.findAll();
		System.out.println("list====="+list.toString());
		return list;
	}

	
}
