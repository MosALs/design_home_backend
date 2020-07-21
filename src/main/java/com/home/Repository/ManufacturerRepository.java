package com.home.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.home.entities.LocationEntity;
@Repository
public interface ManufacturerRepository extends JpaRepository<LocationEntity,Integer> {

}
