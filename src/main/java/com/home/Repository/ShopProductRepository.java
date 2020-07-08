package com.home.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.home.entities.ShopProductEntity;

@Repository
public interface ShopProductRepository extends JpaRepository<ShopProductEntity, Integer>{

}
