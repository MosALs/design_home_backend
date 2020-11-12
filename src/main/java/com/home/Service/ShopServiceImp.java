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
import org.springframework.stereotype.Service;

import com.home.DTO.DetailedSearchDTONew;
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
import com.home.entities.LocationEntity;
import com.home.entities.ShopEntity;

@Service
public class ShopServiceImp implements ShopService {

	
	@Autowired
	AppUserRepository appUsersRepository;
	@Autowired
	LocationRepository locationRepository;
	AreasService areasService;
	@Autowired
	ShopRepository shopRepository;
	ShopService shopService;
	
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
	public int save(ShopEntity shopEntity) {
			shopRepository.save(shopEntity);
		return 0;
	}

	@Override
	public List<ShopEntity> getAllShop() {
        
		return shopRepository.findAll();
	
	}

	@Override
	public ShopEntity getByShopID(int id) {
		return shopRepository.getOne(id);
	}

	@Override
	public int getByshopName(String shopName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteByshopID(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int ModifyByshop(String newshopName, String oldshopNamee) {
		// TODO Auto-generated method stub
		return 0;
	}

		
	}

	
				
				
