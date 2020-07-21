package com.home.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.Repository.AreasRepository;
import com.home.entities.AreasEntity;

@Service
public class AreasServiceImp implements AreasService {

	@Autowired
	private AreasRepository areasRepository;

	@Override
	public List<AreasEntity> getAll() {
		System.out.println("asd");

		return areasRepository.findAll();
	}

	@Override
	public List<AreasEntity> getAreasByGovernorateId(int governoratId) {
		return areasRepository.findByGovernoratId(governoratId);
	}

	@Override
	public AreasEntity getAreaByName(String areaName) {
		return areasRepository.findByAreaName(areaName);
	}

	@Override
	public int save(AreasEntity areasEntity) {
		areasRepository.save(areasEntity);
		return 0;
	}

	@Override
	public int Modify(String newAreaName, String oldAreaName) {
		areasRepository.updateArea(newAreaName, oldAreaName);
		return 0;
	}

	@Override
	public int deleteAreas(int id) {
		areasRepository.deleteById(id);
		return 0;
	}

}
