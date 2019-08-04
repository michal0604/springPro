package com.johnbryce.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.johnbryce.exception.CouponException;
import com.johnbryce.model.Company;
import com.johnbryce.model.Coupon;
import com.johnbryce.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {
	
	@Resource
	private CompanyService companyService;
	
//	@GetMapping("/")
//	public ResponseEntity<List<Company>> findAll() {
//		ResponseEntity<List<Company>> result = new ResponseEntity<List<Company>>(companyService., HttpStatus.OK);
//		return result;
//	}
	
	@PostMapping("/")
	public ResponseEntity<Coupon> create(@RequestBody Coupon coupon) throws CouponException {
		System.out.println("beofre: " +coupon);		
		Coupon newCoupon = companyService.createCoupon(coupon);
		System.out.println("after:" + coupon);
		ResponseEntity<Coupon> result = new ResponseEntity<Coupon>(newCoupon, HttpStatus.OK);
		return result;
	}

}
