package spring.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.model.Company;
import spring.model.Coupon;
import spring.repository.CouponRepository;
import spring.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private CouponRepository couponRepository;

	
	@PostMapping("/createCoupon")
	public ResponseEntity<Coupon> createCoupon(@RequestBody Coupon coupon) throws Exception{ 
		Coupon coupon2 = companyService.createCoupon(coupon);
		ResponseEntity<Coupon> result = new ResponseEntity<Coupon>(coupon2, HttpStatus.OK);

		return result;
	}
	
	@PostMapping("/updateCoupon")
	public ResponseEntity<Coupon> updateCoupon(@RequestParam long id, @RequestParam Date endDate, @RequestParam double price) {
		Coupon coupon = null;
		coupon = couponRepository.findById(id).get();
		if (coupon !=null) {
			companyService.updateCoupon(coupon, endDate, price);
			ResponseEntity<Coupon> result = new ResponseEntity<>(coupon,HttpStatus.OK);
			return result;
		}
		return null;
	}
	
	@DeleteMapping("/deleteCoupon/{id}")
	public void deleteCoupon(@PathVariable long id) {
		Coupon coupon= null;
		coupon = couponRepository.findById(id).get();
		if (coupon!=null) {
			 companyService.deleteCoupon(id);
		}
	}
	///no coupon by id??
	@GetMapping("/companyById/{id}")
	public Company companyById(@PathVariable long id) {
		return companyService.companyById(id);
	}
}
