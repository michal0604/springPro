package com.johnbryce.service;

import java.util.List;
import java.util.Set;

import com.johnbryce.exception.CouponException;
import com.johnbryce.model.Company;
import com.johnbryce.model.Coupon;

public interface CompanyService extends CouponClientService {

	Coupon createCoupon(Coupon coupon) throws CouponException;
	void removeCouponID(long coupId) throws Exception;
	Coupon updateCoupon(Coupon coupon) throws Exception;
	Company getCompany();
	Coupon getCoupon(long coupId) throws Exception;
	List<Coupon> getCoupons();
	

}