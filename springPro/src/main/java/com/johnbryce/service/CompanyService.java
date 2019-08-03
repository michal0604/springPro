package com.johnbryce.service;

import com.johnbryce.exception.CouponException;
import com.johnbryce.model.Coupon;

public interface CompanyService {

	Coupon createCoupon(Coupon coupon) throws CouponException;
	void removeCouponID(long coupId) throws Exception;
	Coupon updateCoupon(Coupon coupon) throws Exception;

}