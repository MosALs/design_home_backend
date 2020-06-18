package com.home.services;

import com.home.DTO.DetailedSearchDTO;
import com.home.DTO.SearchCriteriaDto;
import com.home.entities.AppUserEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("appUserEntityServie")
public interface AppUserService {

    DetailedSearchDTO findBySearchCriteria(SearchCriteriaDto searchCriteriaDto);

    Optional<AppUserEntity> getUserSummary(int id);
}
