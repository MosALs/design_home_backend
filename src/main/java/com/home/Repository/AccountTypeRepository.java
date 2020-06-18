package com.home.Repository;

import com.home.entities.AccountTypeEntity;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountTypeEntity,Integer> {


	@Modifying()
	@Transactional
	@Query(value = "UPDATE account_type acc SET acc.accountTypeName=:newAccountType WHERE acc.accountTypeName=:oldAccountType",nativeQuery =true)
	int updateArea(@Param("newAccountType") String newAccountType, @Param("oldAccountType") String oldAccountType);


}
