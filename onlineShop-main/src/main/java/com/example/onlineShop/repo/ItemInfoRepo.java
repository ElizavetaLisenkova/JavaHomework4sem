package com.example.onlineShop.repo;

import com.example.onlineShop.entity.ItemInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemInfoRepo extends JpaRepository<ItemInfo, Long> {
}
