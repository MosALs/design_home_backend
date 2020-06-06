package com.home.Service;

import java.util.List;

import com.home.entities.AreasEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.Repository.AreasRepository;

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

//	@Override
//	public List<Governorates_AreasDTO> getBYName() {
//		// TODO Auto-generated method stub
//		return areasRepository.findInfo();
//	}
//
//	@Override
//	public List<Areas> getByGovernate(int governorate_id) {
//		// TODO Auto-generated method stub
//		return areasRepository.findByGovernorateId(governorate_id);
//	}
//

//	@Override
//	public boolean save(AreasEntity areas) {
//
//		return areasRepository.save(areas) != null;
//	}
//
//	@Override
//	public Areas delete(Areas areas) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void deleteAreas(int id) {
//		 areasRepository.deleteById(id);
//
//	}
//
//	@Override
//	public int Modify(String newAreaName, String oldAreaName) {
//		return areasRepository.updateArea(newAreaName, oldAreaName);
//
//	}


}





