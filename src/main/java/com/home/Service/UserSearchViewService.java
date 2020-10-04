package com.home.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.home.DTO.UserSearchDto;
import com.home.View.UserSearchView;

@Service
public interface UserSearchViewService {

	List<UserSearchView> getAllView();

	List<UserSearchView> findAll(UserSearchDto userSearchDto);

	Page<UserSearchView> findAllPage(UserSearchDto userSearchDto,Pageable pageable);
}
