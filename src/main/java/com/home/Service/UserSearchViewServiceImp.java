package com.home.Service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.home.DTO.UserSearchDto;
import com.home.Repository.UserSearchViewRepository;
import com.home.View.UserSearchView;

@Service
public class UserSearchViewServiceImp implements UserSearchViewService {

	@Autowired
	UserSearchViewRepository userSearchViewRepository;

	@Override
	public List<UserSearchView> getAllView() {
		System.out.println("wwewewewewe");
		List<UserSearchView> list = userSearchViewRepository.findAll();
		System.out.println("list=====" + list.toString());
		return list;
	}

	@SuppressWarnings({ "unchecked", "serial" })
	@Override
	public List<UserSearchView> findAll(UserSearchDto userSearchDto) {
		return userSearchViewRepository.findAll(new Specification<UserSearchView>() {
			public Predicate toPredicate(Root<UserSearchView> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				if (userSearchDto.getAreaName() != null) {
					predicates.add(criteriaBuilder
							.and(criteriaBuilder.equal(root.get("areaName"), userSearchDto.getAreaName())));
				}
				if (userSearchDto.getAccountTypeName() != null) {
					predicates.add(criteriaBuilder.and(
							criteriaBuilder.equal(root.get("accountTypeName"), userSearchDto.getAccountTypeName())));
				}
				if (userSearchDto.getGovernoratName() != null) {
					predicates.add(criteriaBuilder.and(
							criteriaBuilder.equal(root.get("governoratName"), userSearchDto.getGovernoratName())));
				}
				if (userSearchDto.getSpecializationName() != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("specializationName"),
							userSearchDto.getSpecializationName())));
				}

				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));

			}
		});

	}

	@SuppressWarnings({ "unchecked", "serial" })
	@Override
	public Page<UserSearchView> findAllPage(UserSearchDto userSearchDto, Pageable pageable) {
		
		return (Page<UserSearchView>) userSearchViewRepository.findAll(new Specification<UserSearchView>() {
			public Predicate toPredicate(Root<UserSearchView> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				if (userSearchDto.getAreaName() != null) {
					predicates.add(criteriaBuilder
							.and(criteriaBuilder.equal(root.get("areaName"), userSearchDto.getAreaName())));
				}
				if (userSearchDto.getAccountTypeName() != null) {
					predicates.add(criteriaBuilder.and(
							criteriaBuilder.equal(root.get("accountTypeName"), userSearchDto.getAccountTypeName())));
				}
				if (userSearchDto.getGovernoratName() != null) {
					predicates.add(criteriaBuilder.and(
							criteriaBuilder.equal(root.get("governoratName"), userSearchDto.getGovernoratName())));
				}
				if (userSearchDto.getSpecializationName() != null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("specializationName"),
							userSearchDto.getSpecializationName())));
				}

				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));

			}
			
		},pageable);
	}

}
