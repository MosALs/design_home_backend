package com.home.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.home.Entity.Specialization;

@Service
public interface SpecializationService {

	void save(Specialization specialization);

	public Specialization Modify(int id);

	Specialization delete(int id);

	List<Specialization> getAllSpecialization();

	List<Specialization> searchSpecializationByNmae(String specializationName);

}
