package com.home.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.Entity.Governorates;
import com.home.Repository.GovernoratesRepository;
import com.home.entities.GovernoratEntity;

@Service
public class GovernoratesServiceImp implements GovernoratesService{

	@Autowired
	private GovernoratesRepository governoratesRepository;
	@Override
	public int save(GovernoratEntity governoratEntity) {
		governoratesRepository.save(governoratEntity);
		return 0;
	}

	@Override
	public int ModifyByGovernoratName(String newgovernoratName, String oldgovernoratName) {
		governoratesRepository.updateGovernorat(newgovernoratName, oldgovernoratName);
		return 0;
	}

	@Override
	public int deleteByGovernoratId(int id) {
		governoratesRepository.deleteById(id);
		return 0;
	}

	@Override
	public List<GovernoratEntity> getAllGovernorates() {
		governoratesRepository.findAll();
		return null;
	}

	@Override
	public List<GovernoratEntity> searchGovernoratesByName(String governoratName) {
		governoratesRepository.findBygovernoratName(governoratName);
		return null;
	}


}
