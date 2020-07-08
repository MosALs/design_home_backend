package com.home.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.Repository.ShopRepository;
import com.home.entities.ShopEntity;

@Service
public class ShopServiceImp implements ShopService {

	
	@Autowired
	ShopRepository shopRepository;
	@Override
	public int save(ShopEntity shopEntity) {
			shopRepository.save(shopEntity);
		return 0;
	}

	@Override
	public List<ShopEntity> getAllShop() {
        
		shopRepository.findAll();
		return null;
	}

	@Override
	public int getByShopID(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getByshopName(String shopName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteByshopID(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int ModifyByshop(String newshopName, String oldshopNamee) {
		// TODO Auto-generated method stub
		return 0;
	}

}
