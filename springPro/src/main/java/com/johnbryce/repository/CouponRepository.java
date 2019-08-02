package com.johnbryce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.johnbryce.model.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long>{
	
	List<Coupon> findByTitle(String title);

}
