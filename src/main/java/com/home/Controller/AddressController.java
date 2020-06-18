package com.home.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.home.Entity.Address;
import com.home.Service.AddressService;
@RestController
@RequestMapping(value="/rest/address")
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String add(@RequestBody Address address) {
		if (addressService.save(address)) {
			return "Done";
		} else {
			return "Fail";
		}
	}

	
	
	

}
