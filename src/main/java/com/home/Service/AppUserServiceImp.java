package com.home.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.home.DTO.DetailedSearchDTO;
import com.home.DTO.SearchCriteriaDto;
import com.home.DTO.UserRegisterationDto;
import com.home.Entity.Address;
import com.home.Entity.AppUser;
import com.home.Repository.AccountTypeRepository;
import com.home.Repository.AppUserRepository;
import com.home.Repository.AreasRepository;
import com.home.Repository.LocationRepository;
import com.home.Repository.PhoneRepository;
import com.home.Repository.ShopRepository;
import com.home.Repository.SpecializationRepository;
import com.home.Repository.UserRoleRepository;
import com.home.entities.AccountTypeEntity;
import com.home.entities.AppUserEntity;
import com.home.entities.AreasEntity;
import com.home.entities.LocationEntity;
import com.home.entities.PhoneEntity;
import com.home.entities.ShopEntity;
import com.home.entities.SpecializationEntity;
import com.home.entities.UserRoleEntity;
import com.home.util.ReturnedResultModel;

@Service
public class AppUserServiceImp implements AppUserService {

	@Autowired
	AppUserRepository appUsersRepository;

	@Autowired
	LocationRepository locationRepository;
	AreasService areasService;
	@Autowired
	ShopRepository shopRepository;
	@Autowired
	UserRoleRepository userRoleRepository;
	@Autowired
	AreasRepository areasRepository;
	@Autowired
	AccountTypeRepository accountTypeRepository;
	@Autowired
	SpecializationRepository specializationRepository;

	@Autowired
	PhoneRepository phoneRepository;

	
	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

//	@Override
//	public List<SearchResultDTO> search(String areaName, String accountType, String specializationName) {
//		return null;
////		return appUsersRepository.search(areaName, accountType, specializationName);
//	}

	@Override
	public ResponseEntity<?> login(String userData, String password) {
		String userName = null;
		String userMobile = null;
		String paasword = null;
		AppUser appUser = null;
		AppUserEntity appUserEntity = null;

		if (userData.startsWith("01")) {
			System.out.println("if 1");
			userMobile = userData;
			appUserEntity = appUsersRepository.findByUserMobileAndPassword(userMobile, password);

		} else if (userData.contains("@")) {
			System.out.println("if 2");
			userName = userData;
			appUserEntity = appUsersRepository.findByUserNameAndPassword(userName, password);
		}

		if (appUserEntity != null) {
			return new ResponseEntity<>(appUserEntity, HttpStatus.OK);
		} else if (password.length() >= 8 && password != null) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "incorrect  or password");

		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "incorrect username or password");
		}
	}

	@Override
	public ReturnedResultModel save(UserRegisterationDto userDto) {
		ReturnedResultModel r= new ReturnedResultModel();
		AreasEntity areaEntity = userDto.getAreasEntity();
		AppUserEntity appUserEntity = userDto.getAppUserEntity();
		ShopEntity shopEntityone = userDto.getShopEntity();
		SpecializationEntity specializationEntity = userDto.getSpecializationEntity();
		AccountTypeEntity accountTypeEntity = userDto.getAccountTypeEntity();
		LocationEntity locationEntity = userDto.getLocationEntity();
		PhoneEntity phoneEntity = userDto.getPhoneEntity();

		if (appUserEntity != null) {
			UserRoleEntity ure = null;
			if (accountTypeEntity != null) {
				String accountTypeName = accountTypeEntity.getAccountTypeName();
				accountTypeEntity = accountTypeRepository.findByAccountTypeName(accountTypeName);
				ure = userRoleRepository.findByUserRoleName(accountTypeName);
				appUserEntity.setUserRoleByUserRoleId(ure);
				appUserEntity.setUserRoleByUserRoleId(ure);
				appUserEntity = appUsersRepository.save(appUserEntity);

				if (areaEntity == null) {
					/*
					 * r.setError("you should enter your area");
					 * r.setStatus(HttpStatus.INTERNAL_SERVER_ERROR); r.setResult(null);
					 * r.setMessage("Failed"); return ResponseEntiot
					 */
					throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "you should enter your area");
				} else {

					String areaName = areaEntity.getAreaName();
					AreasEntity areasEntity = areasRepository.findByAreaName(areaName);
					if (locationEntity == null) {
						throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
								"you should enter your location");
					} else {
						locationEntity.setAreasByAreaId(areasEntity);
						if (locationEntity.getLocationName() == null) {
							throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
									"you should enter your location name");
						}

						else {
							locationRepository.save(locationEntity);
						
							ShopEntity shopEntity = new ShopEntity();
							if (accountTypeEntity != null)

								if (!accountTypeName.equals("محل") || !accountTypeName.equals("شركه")) {

									if (accountTypeName.equals("عميل")) {
										specializationEntity = specializationRepository
												.findBySpecializationName("عميل");
										shopEntity.setSpecializationBySpecializationId(specializationEntity);

									} else if (accountTypeName.equals("صنايعى")) {
										SpecializationEntity entity = checkSpecializationType(specializationEntity);
										shopEntity.setSpecializationBySpecializationId(entity);

									}
									shopEntity.setShopName(null);
									shopEntity.setStartDate(null);
									shopEntity.setStreet(null);

								} else {
									SpecializationEntity entity = checkSpecializationType(specializationEntity);
									shopEntity.setSpecializationBySpecializationId(entity);
									shopEntity.setShopName(shopEntityone.getShopName());
									shopEntity.setStartDate(shopEntityone.getStartDate());
									shopEntity.setStreet(shopEntityone.getStreet());
								}
							if (phoneEntity != null) {
								phoneEntity = phoneRepository.save(phoneEntity);

							} else {

								throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
										"you should enter your phone");

							}

							shopEntity.setUserId(appUserEntity.getId());
							shopEntity.setAccountTypeId(accountTypeEntity.getId());
							// shopEntity.setSpecializationId(specializationEntity.getId());
							shopEntity.setLocationId(locationEntity.getId());
							shopEntity.setPhoneId(phoneEntity.getId());
							shopRepository.save(shopEntity); 
						}

					}

				}

			}
 
			
		}else {	
			
			/*r.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			r.setError("you should enter your appuser");
			return new ResponseEntity<>(r.getStatus());*/
			
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"you should enter your user");
		}
		//r.getMessage();
		r.setMessage("user saved succcessfullty");
		r.setStatus(HttpStatus.OK);
		return r;
//		return ResponseEntity.ok("user saved successfully");
		
	}

	public SpecializationEntity checkSpecializationType(SpecializationEntity specializationEntity) {

		SpecializationEntity entity = new SpecializationEntity();
		if (specializationEntity.getSpecializationName().equals("سباك")) {
			entity = specializationRepository.findBySpecializationName("سباك");
		}
		if (specializationEntity.getSpecializationName().equals("نجار")) {
			entity = specializationRepository.findBySpecializationName("نجار");
		}
		if (specializationEntity.getSpecializationName().equals("سيراميك")) {
			entity = specializationRepository.findBySpecializationName("سيراميك");
		}

		return entity;

	}

	@Override
	public List<AppUser> searchAll(String areaName, String accountType, String specializationName,
			String governoratName) {
		return appUsersRepository.searchALL(areaName, accountType, specializationName, governoratName);
	}

	@Override
	public DetailedSearchDTO findBySearchCriteria(SearchCriteriaDto caseCriteria) {

		DetailedSearchDTO dtot = new DetailedSearchDTO();
		@SuppressWarnings("unchecked")
		List<AppUser> appUsers = appUsersRepository.findAll(new Specification<AppUser>() {
			private static final long serialVersionUID = 1L;
			
		

			@Override
			public Predicate toPredicate(Root<AppUser> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();

				if (StringUtils.isNotBlank(caseCriteria.getSpecializationName())) {
					predicates.add(criteriaBuilder.equal(root.get("specializationId").get("specializationName"),
							caseCriteria.getSpecializationName()));
					dtot.setSpecializationName(caseCriteria.getSpecializationName());

				}

				if (StringUtils.isNotBlank(caseCriteria.getAreaName())) {
					Join<AppUser, Address> join = root.join("addressList", JoinType.INNER);

					Path<Set<String>> areas = join.get("areaId");
					Path<String> areaName = areas.get("areaName");
					predicates.add(criteriaBuilder.equal(areaName, caseCriteria.getAreaName()));
					dtot.setAreaName(caseCriteria.getAreaName());

				}

				if (StringUtils.isNotBlank(caseCriteria.getGovernorateName())) {
					Join<AppUser, Address> join = root.join("addressList", JoinType.INNER);

					Path<Set<String>> areas = join.get("areaId");
					Path<String> governorate = areas.get("governorateId");
					Path<String> governorateName = governorate.get("governoratName");
					predicates.add(criteriaBuilder.equal(governorateName, caseCriteria.getGovernorateName()));
					dtot.setAreaName(caseCriteria.getGovernorateName());

				}

				if (StringUtils.isNotBlank(caseCriteria.getAccount_Type())) {
					predicates.add(criteriaBuilder.equal(root.get("accountType"), caseCriteria.getAccount_Type()));
					dtot.setAccounrType(caseCriteria.getAccount_Type());
				}

				Predicate[] ps = predicates.toArray(new Predicate[predicates.size()]);

				Predicate p = criteriaBuilder.and(ps);

				return p;
			}

		});

		dtot.setAppUsers(appUsers);
		return dtot;
	}

	/*
	 * @Override public ResponseEntity<?> add(UserRegisterationDto dto) {
	 * AppUserEntity appUserEntity = dto.getAppUserEntity(); if (appUserEntity !=
	 * null) { if (appUserEntity.getPassword().length() < 8) { throw new
	 * ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
	 * "Please enter the secret number 8"); }
	 * 
	 * if (appUserEntity.getUserMobile().length() < 11) { throw new
	 * ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
	 * "Please enter the phone number"); }
	 * 
	 * appUserEntity = appUsersRepository.save(appUserEntity); } return null;
	 * 
	 * }
	 */

	/*
	 * @Override public int saveone(AppUserEntity appUserEntity) { // TODO
	 * Auto-generated method stub appUsersRepository.save(appUserEntity); return 0;
	 * }
	 */
}
