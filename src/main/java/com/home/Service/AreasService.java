package com.home.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.home.entities.AreasEntity;

@Service
public interface AreasService {

    int save(AreasEntity areasEntity);

	int Modify(String newAreaName, String oldAreaName);

	int deleteAreas(int id);

	List<AreasEntity> getAll();

	List<AreasEntity> getAreasByGovernorateId(int governrateId);

	AreasEntity getAreaByName(String areaName);

}
