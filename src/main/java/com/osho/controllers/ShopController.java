package com.osho.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osho.model.Shop;
import com.osho.services.ShopServices;

@RestController
@RequestMapping("/shop")
public class ShopController {
	
	@Autowired
	ShopServices shopServices;
	
	@GetMapping("/shop")
	public List<Shop> displayAllUSers()
	{
		return shopServices.getAllItems();
	}
	
	@GetMapping("/shop/{shopId}")
	public Shop display(@PathVariable Long shopId)
	{
		return shopServices.getItem(shopId);
	}
	
	@PostMapping("/shop")
	public void addShop(@RequestBody Shop shop)
	{
		shopServices.addItem(shop);
	}
	
	@DeleteMapping("/shop/{shopId}")
	public void deleteUser(@PathVariable Long shopId)
	{
		shopServices.deleteItem(shopId);
	}

	
}
