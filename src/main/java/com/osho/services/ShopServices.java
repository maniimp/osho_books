package com.osho.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osho.model.Shop;
import com.osho.repository.ShopRepository;

@Service
public class ShopServices {
	
	@Autowired
	ShopRepository shopRepository;

	public List<Shop> getAllItems() {
		return shopRepository.findAll();
	}

	public Shop getItem(Long shopId) {
		return shopRepository.findById(shopId).get();
	}

	public void addItem(Shop shop) {
		shopRepository.save(shop);
	}

	public void deleteItem(Long shopId) {
		shopRepository.deleteById(shopId);
	}

}
