package com.home.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.home.DTO.Governorates_AreasDTO;
import com.home.Entity.Areas;

@Service
public interface AreasService {

	boolean save(Areas areas);

	int Modify(String newAreaName, String oldAreaName);

	Areas delete(Areas areas);

	void deleteAreas(int id);

	List<Areas> getAll();

	// Areas getBYId (int id);
	List<Governorates_AreasDTO> getBYName();

	List<Areas> getByGovernate(int governorate_id);

	
}
