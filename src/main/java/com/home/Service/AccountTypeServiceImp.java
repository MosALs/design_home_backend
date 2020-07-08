package com.home.Service;

import com.home.Repository.AccountTypeRepository;
import com.home.entities.AccountTypeEntity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountTypeServiceImp implements AccountTypeService {

    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @Override
    public boolean save(AccountTypeEntity accountType) {
        return accountTypeRepository.save(accountType)!=null;
    }

	@Override
	public List<AccountTypeEntity> getAllAccountTypes() {
		
		return accountTypeRepository.findAll();
	}

	@Override
	public void deleteAccountTypeById(int id) {
	   accountTypeRepository.deleteById(id);
		
		
	}

	@Override
	public AccountTypeEntity getByAcccountTypeId(int id) {
		accountTypeRepository.deleteById(id);
		return null;
	}

	@Override
	public int ModifyByAccountType(String newAccountType, String oldAccountType) {
		return accountTypeRepository.updateAccountTypeName(newAccountType, oldAccountType);
	}

	@Override
	public AccountTypeEntity getByAccountTypeName(String accountTypeName) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
