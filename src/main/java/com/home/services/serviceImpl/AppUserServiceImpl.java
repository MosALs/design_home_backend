package com.home.services.serviceImpl;

import com.fasterxml.jackson.annotation.JsonView;
import com.home.DTO.DetailedSearchDTO;
import com.home.DTO.SearchCriteriaDto;
import com.home.Entity.Address;
import com.home.Entity.AppUser;
import com.home.entities.AppUserEntity;
import com.home.entities.LocationEntity;
import com.home.entities.ShopEntity;
import com.home.entities.ShopProductEntity;
import com.home.jsonfilter.View;
import com.home.repositories.AppUserRepository;
import com.home.services.AppUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Qualifier("appUserEntityReposistory")
    @Autowired
    AppUserRepository appUsersRepository;


    @Override
    public DetailedSearchDTO findBySearchCriteria(SearchCriteriaDto caseCriteria) {
        DetailedSearchDTO dtot = new DetailedSearchDTO();

        List<AppUserEntity> appUsers = appUsersRepository.findAll(new Specification<AppUserEntity>() {
            private static final long serialVersionUID = 1L;
            @Override
            public Predicate toPredicate(Root<AppUserEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder){
                List<Predicate> predicates = new ArrayList<>();


//                if(StringUtils.isNotBlank(caseCriteria.getSpecializationName())) {
//                    predicates.add(criteriaBuilder.equal(root.get("specializationId").get("specializationName"),caseCriteria.getSpecializationName()));
//                    dtot.setSpecializationName(caseCriteria.getSpecializationName());
//
//                }

                if (StringUtils.isNotBlank(caseCriteria.getAreaName())) {
                    System.out.println("if");
                    Join<AppUserEntity, ShopEntity> userJoinShop = root.join("shopsById", JoinType.INNER);

                    Path<Set<String>> location = userJoinShop.get("locationByLocationId");
                    Path<?> area = location.get("areasByAreaId");
                    Path<?> areaName = area.get("areaName");
                    predicates.add(criteriaBuilder.equal(areaName, caseCriteria.getAreaName()));
                    dtot.setAreaName(caseCriteria.getAreaName());

                }
//                if (StringUtils.isNotBlank(caseCriteria.getGovernorateName())) {
//                    Join<AppUser, Address> join = root.join("addressList", JoinType.INNER);
//
//                    Path<Set<String>> areas = join.get("areaId");
//                    Path<String> governorate = areas.get("governorateId");
//                    Path<String> governorateName = governorate.get("governoratName");
//                    predicates.add(criteriaBuilder.equal(governorateName, caseCriteria.getGovernorateName()));
//                    dtot.setAreaName(caseCriteria.getGovernorateName());
//
//
//                }


//                if (StringUtils.isNotBlank(caseCriteria.getAccount_Type())) {
//                    predicates.add(criteriaBuilder.equal(root.get("accountType"), caseCriteria.getAccount_Type()));
//                    dtot.setAccounrType(caseCriteria.getAccount_Type());
//                }


                Predicate[] ps =  predicates.toArray(new Predicate[predicates.size()]);

                Predicate p = criteriaBuilder.and(ps);


                return p;
            }

        });






      //  dtot.setAppUserEntity(appUserEntity);
        return dtot;
    }

    @Override
    public Optional<AppUserEntity> getUserSummary(int id) {
        return appUsersRepository.findById(id);
    }
}
