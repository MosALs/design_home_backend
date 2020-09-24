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

import com.home.DTO.DetailedSearchDTO;
import com.home.DTO.SearchCriteriaDto;
import com.home.DTO.ShopSearch;
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
import com.home.entities.AppUserEntity;
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
        
		shopRepository.findAll();
		return null;
	}

	@Override
	public int getByShopID(int id) {
		// TODO Auto-generated method stub
		return 0;
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


	@Override
	public DetailedSearchDTO findBySearchCriteria(SearchCriteriaDto caseCriteria) {
		
		DetailedSearchDTO dtot = new DetailedSearchDTO();
		List<ShopEntity> shopEntity= shopRepository.findAll(new Specification<ShopEntity>(){
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<ShopEntity> root,CriteriaQuery<?> query,CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>(); 
		
				if (StringUtils.isNotBlank(caseCriteria.getAreaName())) {
					Join<AppUser, Address> join = root.join("addressList", JoinType.INNER);
					Path<Set<String>> areas = join.get("areaId");
					Path<String> areaName = areas.get("areaName");
					predicates.add(criteriaBuilder.equal(areaName, caseCriteria.getAreaName()));
					dtot.setAreaName(caseCriteria.getAreaName());
				}
				
			    if (StringUtils.isNotBlank(caseCriteria.getAreaName())) {
                    System.out.println("if");
                    Join<AppUserEntity, ShopEntity> userJoinShop = root.join("shopsById", JoinType.INNER);

                    Path<Set<String>> location = userJoinShop.get("locationByLocationId");
                    Path<?> area = location.get("areasByAreaId");
                    Path<?> areaName = area.get("areaName");
                    predicates.add(criteriaBuilder.equal(areaName, caseCriteria.getAreaName()));
                    dtot.setAreaName(caseCriteria.getAreaName());

                }

				Predicate[] ps = predicates.toArray(new Predicate[predicates.size()]);

				Predicate p = criteriaBuilder.and(ps);

				return p;
			}

		});

		dtot.setShopEntityList(shopEntity);
		return dtot;
	}



}
				
				
