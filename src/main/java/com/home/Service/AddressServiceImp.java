package com.home.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.Entity.Address;
import com.home.Repository.AddressRepository;

import java.util.List;

@Service
public class AddressServiceImp implements AddressService{

	@Autowired
	AddressRepository branchesRepository;
	@Override
	public boolean save(Address address) {
		
		return branchesRepository.save(address)!=null;
	}

	@Override
	public List<Address> findByAddressId_Id(int id) {
		return null;
	}

	@Override
	public Address getByAddressId(int id) {
		return null;
	}


}
