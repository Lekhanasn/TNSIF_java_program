package com.mall.shopmanagement.repository;

import com.mall.shopmanagement.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Integer> {
}
