package com.home.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.home.DTO.LocationAreaDTO;
import com.home.DTO.SearchDtoNew;
import com.home.DTO.SearchGetAll;
import com.home.DTO.ShopSearch;
import com.home.entities.LocationEntity;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, Integer> ,JpaSpecificationExecutor{

	@Query(value = " select new com.home.DTO.LocationAreaDTO(l.locationName,a.areaName)\r\n" + "\r\n"
			+ " from LocationEntity l inner join AreasEntity a on l.areasByAreaId.id=a.id")
	List<LocationAreaDTO> findInfoLocationAndArea();
	
	/////////////

	@Modifying()
	@Transactional
	@Query(value = "UPDATE location l SET l.locationName=:newlocationName WHERE l.locationName=:oldlocationName", nativeQuery = true)
	int updateLocation(@Param("newlocationName") String newlocationName,
			@Param("oldlocationName") String oldlocationName);

	void findByLocationName(String locationName);

	@Query(value = "	select new com.home.DTO.SearchDtoNew(auser.userName, sh.shopName,l.locationName,a.areaName)\r\n"
			+ "			from ShopEntity sh\r\n" + ""
		    + "         inner join LocationEntity l on sh.locationId=l.id\r\n"
			+ "			inner join AreasEntity a on l.areasByAreaId.id=a.id\r\n"
			+ "			inner join AppUserEntity auser on sh.userId=auser.id\r\n"
			+ "			 where a.areaName= :area_name")
	List<SearchDtoNew> search(@Param("area_name") String areaName);

	@Query(value = "select new com.home.DTO.ShopSearch(auser.userName, sh.shopName,l.locationName,a.areaName,ac.accountTypeName, s.specializationName)\r\n"
			+ "						    from ShopEntity sh \r\n"
			+ "				            inner join LocationEntity l on sh.locationId=l.id\r\n"
			+ "						    inner join AreasEntity a on l.areasByAreaId.id=a.id \r\n"
			+ "						    inner join AppUserEntity auser on sh.userId=auser.id\r\n"
			+ "							inner join SpecializationEntity s on sh.specializationId=s.id\r\n"
			+ "							inner join AccountTypeEntity ac on sh.accountTypeId=ac.id\r\n"
			+ "						    where a.areaName= :area_name and \r\n"
			+ "							s.specializationName= :specialization_name and\r\n"
			+ "							 ac.accountTypeName= :account_type_name")
	List<ShopSearch> searchdto(@Param("area_name") String areaName,
			@Param("specialization_name") String specializationName,
			@Param("account_type_name") String accountTypeName);

	/*
	 * @Query(value =
	 * "select sh.shopName,s.specializationName,ac.accountTypeName,l.locationName,ar.areaName,g.governoratName,auser.name,p.mobileOne,p.mobileTwo,p.mobileThree,p.mobileFour,p.landLineOne,p.landLineTwo,p.landLineThree\r\n"
	 * + "from ShopEntity sh\r\n" +
	 * "inner join SpecializationEntity s on sh.specializationId=s.id\r\n" +
	 * "inner join  AccountTypeEntity ac on sh.accountTypeId=ac.id\r\n" +
	 * "inner join LocationEntity l on sh.locationId=l.id\r\n" +
	 * "inner join AreasEntity ar on l.areasByAreaId.id=ar.id\r\n" +
	 * "inner join GovernoratEntity g on ar.governoratByGovernoratId=g.id\r\n" +
	 * "inner join AppUserEntity auser on sh.userId=auser.id\r\n" +
	 * "inner join PhoneEntity p on sh.phoneId=p.id\r\n" + "\r\n" +
	 * "where ac.accountTypeName= :account_type_name and s.specializationName= :specialization_name and ar.areaName= :area_name and g.governoratName= :governorat_name \r\n"
	 * + "\r\n" + "\r\n" + "\r\n" + "\r\n" + "") List<SearchGetAll> allFourDto
	 * (@Param("area_name") String areaName,
	 * 
	 * @Param("specialization_name") String specializationName,
	 * 
	 * @Param("account_type_name") String accountTypeName,
	 * 
	 * @Param("governorat_name") String governoratName);
	 */
	
	
	
	
	@Query(value = "select sh.shopName,s.specializationName,ac.accountTypeName,l.locationName,ar.areaName,g.governoratName,auser.name,p.mobileOne,p.mobileTwo\r\n"
			+ "from ShopEntity sh\r\n"
			+ "inner join SpecializationEntity s on sh.specializationId=s.id\r\n"
			+ "inner join  AccountTypeEntity ac on sh.accountTypeId=ac.id\r\n"
			+ "inner join LocationEntity l on sh.locationId=l.id\r\n"
			+ "inner join AreasEntity ar on l.areasByAreaId.id=ar.id\r\n"
			+ "inner join GovernoratEntity g on ar.governoratByGovernoratId=g.id\r\n"
			+ "inner join AppUserEntity auser on sh.userId=auser.id\r\n"
			+ "inner join PhoneEntity p on sh.phoneId=p.id\r\n" + "\r\n"
			+ "\r\n" + "\r\n" + "\r\n" + "\r\n" + "")
	     List<SearchGetAll> allFourDto1();
	
	@Query(value = "select l.locationName\r\n" +
	"from LocationEntity l")
	List<LocationEntity> findAllName();
	
	
	
	
	
	
	
}
