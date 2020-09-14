package com.home.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.Repository.PhoneRepository;
import com.home.entities.PhoneEntity;

@Service
public class PhoneEntityServiceImp implements PhoneEntityService{

	@Autowired
	private PhoneRepository phoneRepository; 
	
	@Override
	public int save(PhoneEntity phoneEntity) {
	     phoneRepository.save(phoneEntity);
		return 0;
	}

}
