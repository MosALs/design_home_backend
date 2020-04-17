package com.home.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.home.DTO.SearchResultDTO;
import com.home.Entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {

//	@Procedure(value = "SelectUserSearch")
	@Query(value="select a.area_name ,s.specialization_name, u.user_name , "
			+ "u.user_mobile , u.account_type from branches b  inner join"
			+ " users u on b.user_id = u.id inner join areas a on a.id = b.area_id "
			+ "inner join specialization s on s.id=u.specialization_id"
			+ " where a.area_name = :area_name  and u.account_type= :account_type and"
			+ " s.specialization_name= :specialization_name",nativeQuery = true) 
	List<SearchResultDTO> search(@Param ("area_name")String areaName,@Param("account_type") String accountType,@Param("specialization_name") String specializationName);
///////////////////////////////////////////////////
	/*@Query(value="select * from users u \r\n" + 
			"inner join specialization s on s.id = u.specialization_id\r\n" + 
			"inner join branches b on b.user_id = u.id\r\n" + 
			"inner join areas a on a.id = b.area_id\r\n" + 
			"where u.user_name='mostafa@ggg' and u.password='123'")
	*/
	
	
	Users findByUserNameAndPassword(String userName, String password);
	Users findByUserMobileAndPassword(String userMobile, String password);
	

	

	
}
