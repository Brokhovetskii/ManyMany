package com.example.manytomany.Repository;

import com.example.manytomany.DBmodels.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
    List<Shop> findByAddressContainsIgnoreCase(String address);

}
