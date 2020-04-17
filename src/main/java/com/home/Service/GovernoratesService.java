package com.home.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.home.Entity.Governorates;

@Service
public interface GovernoratesService {

	void save(Governorates governorates);

	public Governorates Modify(int id);

	Governorates delete(int id);

	List<Governorates> getAllGovernorates();

	List<Governorates> searchGovernoratesByName(String governoratName);

}
