package com.home.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.home.DTO.Governorates_AreasDTO;
import com.home.Entity.Areas;
import com.home.Service.AreasService;

@RestController
@RequestMapping(value = "/rest/area")
public class AreasController {

	
	@Autowired
	AreasService areasService;

	// GET
	@RequestMapping(value = "/areas", method = RequestMethod.GET) // localhost:8080/Areas
	List<Areas> getAllAreas() {
		System.out.println("=============getAllAreas");
		return areasService.getAll();
	}

	@GetMapping(value = "area/{governrate_id}") // List <Areas>
	List<Areas> getAllAreasByGovernate(@PathVariable int governrate_id) {
		System.out.println("=============getAllAreasByGovernate"); // return
		return areasService.getByGovernate(governrate_id); // }
	}

	@GetMapping(value = "/areas/area")
	List<Governorates_AreasDTO> getBYALLName() {
		System.out.println("=============getAllAreasByGovernate");
		return areasService.getBYName();
	}

	@RequestMapping(value = "/Areaadd", method = RequestMethod.POST)
	public String add(@RequestBody Areas areas) {
		if (areasService.save(areas)) {
			return "Done";
		} else {
			return "Fail";
		}
	}

	@RequestMapping(value ="/delete",method = RequestMethod.DELETE)
	public String deleteAreaId(@RequestParam int id) {
		areasService.deleteAreas(id);
		return "done";
		
	
	}
	@RequestMapping(value ="/update",method = RequestMethod.PUT)
	public int updateArea(@RequestParam(name="newAreaName") String newAreaName,@RequestParam(name="oldAreaName") String oldAreaName) {
		return areasService.Modify(newAreaName, oldAreaName);
		
	
	}
	
//	@RequestMapping(value ="/update",method = RequestMethod.PUT)
//	public int updateArea(@RequestParam(name="newAreaName") String newAreaName,@RequestParam(name="id") int id) {
//		return areasService.modify(newAreaName, id);
//		
//	
//	}

	
	}
