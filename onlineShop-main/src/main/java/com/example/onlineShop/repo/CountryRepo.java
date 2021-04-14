package com.example.onlineShop.repo;

import com.example.onlineShop.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepo extends JpaRepository<Country, Long> {
}