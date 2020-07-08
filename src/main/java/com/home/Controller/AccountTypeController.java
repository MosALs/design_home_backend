package com.home.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.home.Service.AccountTypeService;
import com.home.entities.AccountTypeEntity;

@RestController
@RequestMapping(value = "/rest/AccountType")
public class AccountTypeController {

	@Autowired
	AccountTypeService accountTypeService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String add(@RequestBody AccountTypeEntity accountType) {
		if (accountTypeService.save(accountType)) {
			return "Done";
		} else {
			return "Fail";
		}
	}

	// get All AccountTypeEntity
	@GetMapping("/getAllAcc")
	//@RequestMapping(value = "/getAllAcc", method = RequestMethod.GET)
	List<AccountTypeEntity> getAllAccountTypes() {
		return accountTypeService.getAllAccountTypes();
	}

	// delete by id account type

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String deleteAccountTypeId(@RequestParam int id) {
		// public String deleteAreaId(@PathVariable int id) {
		accountTypeService.deleteAccountTypeById(id);
		return "done";
	}

	// Update Account Type

	@RequestMapping(value = "/updateName", method = RequestMethod.PUT)
	public int updateAccountTypeName(@RequestParam(name = "newAccountType") String newAccountType,
			@RequestParam(name = "oldAccountType") String oldAccountType) {
		return accountTypeService.ModifyByAccountType(newAccountType, oldAccountType);

	}

	@GetMapping("/getAccountName")
	AccountTypeEntity getAccountName(@PathVariable String accountTypeName){
		return accountTypeService.getByAccountTypeName(accountTypeName);
		
	}
	
}