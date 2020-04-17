package com.home.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.home.Entity.Countries;
@Service
public interface CountriesService {

	boolean save(Countries countries);

	public int Modify(String newcountryName,String oldcountryName);

	void delete(int id);

	List<Countries> getAllCountries();
	
	List<Countries> searchCountriesByName (String countryName);

}
