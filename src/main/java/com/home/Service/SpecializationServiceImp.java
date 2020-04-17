package com.home.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.Entity.Specialization;
import com.home.Repository.SpecializationRepository;

@Service
public class SpecializationServiceImp implements SpecializationService {

	@Autowired
	private SpecializationRepository specializationRepository;

	@Override
	public void save(Specialization specialization) {
		// TODO Auto-generated method stub

	}

	@Override
	public Specialization Modify(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Specialization delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Specialization> getAllSpecialization() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Specialization> searchSpecializationByNmae(String specializationName) {
		// TODO Auto-generated method stub
		return null;
	}

}
