package com.home.Controller;

import org.dom4j.tree.AbstractBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.home.Entity.Branches;
import com.home.Service.BranchesService;
@RestController
@RequestMapping(value="/rest/branch")
public class BranchesController {
	
	@Autowired
	BranchesService branchesService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String add(@RequestBody Branches branches) {
		if (branchesService.save(branches)) {
			return "Done";
		} else {
			return "Fail";
		}
	}
	
	
	

}
