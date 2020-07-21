package com.home.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.home.Entity.Governorates;
import com.home.entities.GovernoratEntity;

@Service
public interface GovernoratesService {

	int save(GovernoratEntity governoratEntity);

    int ModifyByGovernoratName(String newgovernoratName,String oldgovernoratName);

	int deleteByGovernoratId(int id);

	List<GovernoratEntity> getAllGovernorates();

	List<GovernoratEntity> searchGovernoratesByName(String governoratName);

}
