package com.home.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.DTO.Governorates_AreasDTO;
import com.home.Entity.Areas;
import com.home.Repository.AreasRepository;

@Service
public class AreasServiceImp implements AreasService {

	@Autowired
	private AreasRepository areasRepository;

	@Override
	public List<Areas> getAll() {
			System.out.println("asd");
	
		return areasRepository.findAll();
	}

	@Override
	public List<Governorates_AreasDTO> getBYName() {
		// TODO Auto-generated method stub
		return areasRepository.findInfo();
	}

	@Override
	public List<Areas> getByGovernate(int governorate_id) {
		// TODO Auto-generated method stub
		return areasRepository.findByGovernorateId(governorate_id);
	}


	@Override
	public boolean save(Areas areas) {

		return areasRepository.save(areas) != null;
	}

	@Override
	public Areas delete(Areas areas) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAreas(int id) {
		 areasRepository.deleteById(id);
		
	}

	@Override
	public int Modify(String newAreaName, String oldAreaName) {
		return areasRepository.updateArea(newAreaName, oldAreaName);
		
	}


}





