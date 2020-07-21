package com.home.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.home.entities.ShopEntity;



@Repository
public interface ShopRepository extends JpaRepository<ShopEntity,Integer>{
	
	@Modifying()
	// اى حاجه تحصل مع الداتا بيز
	@Transactional
	@Query(value = "INSERT INTO dbo.shop\r\n" + 
			"                         (user_id, shop_name, specialization_id, account_type_id, street, active, start_date, location_id)\r\n" + 
			"SELECT        1 AS Expr1, 2 AS Expr2, 3 AS Expr3, 4 AS Expr4, 5 AS Expr5, 6 AS Expr6, 7 AS Expr7, 8 AS Expr8\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"", nativeQuery = true)
	   int updateShop();

	void findByShopName(String shopName);

}
