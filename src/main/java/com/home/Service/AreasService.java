package com.home.Service;

import java.util.List;

import com.home.entities.AreasEntity;
import org.springframework.stereotype.Service;

@Service
public interface AreasService {

//    boolean save(Areas areas);

//    int Modify(String newAreaName, String oldAreaName);

//    Areas delete(Areas areas);

//    void deleteAreas(int id);

    List<AreasEntity> getAll();

    List<AreasEntity> getAreasByGovernorateId(int governrateId);

    AreasEntity getAreaByName(String areaName);

    // Areas getBYId (int id);
//    List<Governorates_AreasDTO> getBYName();

//    List<Areas> getByGovernate(int governorate_id);

}
