package com.osho.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.osho.model.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long>{

}
