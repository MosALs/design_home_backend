package com.home.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.home.Entity.Countries;
import com.home.entities.CountriesEntity;

@Repository
public interface CountriesRepository extends JpaRepository<CountriesEntity, Integer> {

	// upDate
	@Modifying()
	@Transactional
	@Query(value = "UPDATE Countries c SET c.countryName=:newcountryName WHERE c.countryName=:oldcountryName")
	int updatecountry(@Param("newcountryName") String newaddresName, @Param("oldcountryName") String oldaddresName);

	// like
	@Query("select c from Countries c where c.countryName like '%countryName%'")
	List<CountriesEntity> findCountriesBYcountryName(@Param("countryName") String countryName);

}
