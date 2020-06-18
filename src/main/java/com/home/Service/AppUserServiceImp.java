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
import com.home.DTO.SearchResultDTO;
import com.home.DTO.UserRegisterationDto;
import com.home.Entity.Address;
import com.home.Entity.AppUser;
import com.home.Entity.Specialization;
import com.home.Repository.AddressRepository;
import com.home.Repository.AppUserRepository;

@Service
public class AppUserServiceImp implements AppUserService {

	@Autowired
	AppUserRepository appUsersRepository;
	@Autowired
	AddressRepository addressRepository;
	AreasService areasService;

	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SearchResultDTO> search(String areaName, String accountType, String specializationName) {
		return null;
//		return appUsersRepository.search(areaName, accountType, specializationName);
	}

	@Override
	public ResponseEntity<?> login(String userData, String password) {
		String userName = null;
		String userMobile = null;
		String paasword = null;
		AppUser appUser = null;

		if (userData.startsWith("01")) {
			System.out.println("if 1");
			userMobile = userData;
			appUser = appUsersRepository.findByUserMobileAndPassword(userMobile, password);
		} else if (userData.contains("@")) {
			System.out.println("if 2");
			userName = userData;
			appUser = appUsersRepository.findByUserNameAndPassword(userName, password);
		}

		if (appUser != null) {
			return new ResponseEntity<>(appUser, HttpStatus.OK);
		} else if (password.length() >= 8 && password != null) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "incorrect  or password");

		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "incorrect username or password");
		}
	}

	@Override
	public ResponseEntity<?> save(UserRegisterationDto userDto) {

		Address address = userDto.getAddress();
		System.out.println("address ===== " + address.toString());

		AppUser appUser = userDto.getAppUser();
		Specialization specialization = userDto.getSpecialization();

		if (appUser != null) {
			if (appUser.getPassword().length() < 8) {
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Please enter the secret number 8");
			} else if (appUser.getPassword() == null) {

			}

			else if (appUser.getUserMobile() != null && appUser.getUserMobile().length() < 11) {
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Please enter the phone number");
			} else if (appUser.getAccountType() == null) {
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Please enter the type");
			}
			System.out.println(appUser.getAccountType());
			if (!appUser.getAccountType().equals("عميل")) {
				
					if(appUser.getSpecializationId() == null ) {
						throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Please enter the Specialization");
					}

			}
			appUser = appUsersRepository.save(appUser);
			address.setAppuserId(appUser);
			System.out.println("appUser id:===" + appUser.getId());
			addressRepository.save(address);
			return new ResponseEntity<>(appUser, HttpStatus.OK);
		}

		else {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "user is not saved successfully");
		}

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
			public Predicate toPredicate(Root<AppUser> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder){
				List<Predicate> predicates = new ArrayList<>();
			 
				 
				if(StringUtils.isNotBlank(caseCriteria.getSpecializationName())) {
					predicates.add(criteriaBuilder.equal(root.get("specializationId").get("specializationName"),caseCriteria.getSpecializationName()));
					dtot.setSpecializationName(caseCriteria.getSpecializationName());

				}
				
				if (StringUtils.isNotBlank(caseCriteria.getAreaName())) {
					Join<AppUser,Address> join = root.join("addressList", JoinType.INNER);

					Path<Set<String>> areas = join.get("areaId");
					Path<String> areaName = areas.get("areaName");
					predicates.add(criteriaBuilder.equal(areaName, caseCriteria.getAreaName()));
					dtot.setAreaName(caseCriteria.getAreaName());

				}
				
				if (StringUtils.isNotBlank(caseCriteria.getGovernorateName())) {
					Join<AppUser,Address> join = root.join("addressList", JoinType.INNER);
					
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

				
				Predicate[] ps =  predicates.toArray(new Predicate[predicates.size()]);
				
				Predicate p = criteriaBuilder.and(ps);
				
				
				return p;
			}

		});
				
		dtot.setAppUsers(appUsers);
		return dtot;
	}
	
	
	
	
	}


