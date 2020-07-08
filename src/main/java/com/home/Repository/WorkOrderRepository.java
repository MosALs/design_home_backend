package com.home.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.home.entities.WorkOrderEntity;

@Repository
public interface WorkOrderRepository extends JpaRepository<WorkOrderEntity,Integer>{

}
