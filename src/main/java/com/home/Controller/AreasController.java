package com.home.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.home.Service.AreasService;
import com.home.entities.AreasEntity;

@RestController
@RequestMapping(value = "/rest/areas")
public class AreasController {

	@Autowired
	AreasService areasService;

	@GetMapping
	List<AreasEntity> getAllAreas() {
		return areasService.getAll();
	}

	@GetMapping(value = "/name")
	AreasEntity getAreaByName(@RequestParam String areaName) {
		return areasService.getAreaByName(areaName);
	}

	/*
	 * @GetMapping(value = "/govId/{governrateId}") List<AreasEntity>
	 * getAreasByGovernorateId(@PathVariable int governrateId) { return
	 * areasService.getAreasByGovernorateId(governrateId); }
	 */
//

//
//	@RequestMapping(value = "/Areaadd", method = RequestMethod.POST)
//	public String add(@RequestBody Areas areas) {
//		if (areasService.save(areas)) {
//			return "Done";
//		} else {
//			return "Fail";
//		}
//	}
//
//	@RequestMapping(value ="/delete",method = RequestMethod.DELETE)
//	public String deleteAreaId(@RequestParam int id) {
//		areasService.deleteAreas(id);
//		return "done";
//
//
//	}
//	@RequestMapping(value ="/update",method = RequestMethod.PUT)
//	public int updateArea(@RequestParam(name="newAreaName") String newAreaName,@RequestParam(name="oldAreaName") String oldAreaName) {
//		return areasService.Modify(newAreaName, oldAreaName);
//
//
//	}
//
//	@RequestMapping(value ="/update",method = RequestMethod.PUT)
//	public int updateArea(@RequestParam(name="newAreaName") String newAreaName,@RequestParam(name="id") int id) {
//		return areasService.modify(newAreaName, id);
//		
//	
//	}

}
