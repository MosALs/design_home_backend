package com.home.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.home.entities.ProductTransactionEntity;

@Repository
public interface ProductTransactionRepository extends JpaRepository<ProductTransactionEntity,Integer>{

}
