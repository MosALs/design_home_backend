package com.home.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.home.entities.SpecializationEntity;

@Service
public interface SpecializationService {

	int save(SpecializationEntity specializationEntity);

	 List<SpecializationEntity> getAllspecialization();
	 
	int getBySpecializationID(int id);
	
	int getBySpecializationName(String specializationName);

	int deleteBySpecializationID(int id);

	int ModifyBySpecializationName(String newspecializationName, String oldspecializationName);


}
