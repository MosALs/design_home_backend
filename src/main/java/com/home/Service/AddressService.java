package com.home.Service;

import java.util.List;

import com.home.Entity.Address;

public interface AddressService {

	boolean save(Address address);

	List<Address> findByAddressId_Id(int id);
	
	Address getByAddressId(int id);

}
