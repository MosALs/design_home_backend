package com.home.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.home.entities.AccountTypeEntity;

@Service
public interface AccountTypeService {

	boolean save(AccountTypeEntity accountType);

	List<AccountTypeEntity> getAllAccountTypes();

	AccountTypeEntity getByAcccountTypeId(int id);
	
	AccountTypeEntity getByAccountTypeName(String accountTypeName);

	void deleteAccountTypeById(int id);

	int ModifyByAccountType(String newAccountType, String oldAccountType);

}
