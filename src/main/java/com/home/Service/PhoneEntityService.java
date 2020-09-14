package com.home.Service;

import org.springframework.stereotype.Service;

import com.home.entities.PhoneEntity;

@Service
public interface PhoneEntityService {

	  int save(PhoneEntity phoneEntity);
}
