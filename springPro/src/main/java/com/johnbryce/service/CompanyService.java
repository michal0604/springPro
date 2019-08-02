package com.johnbryce.service;

import com.johnbryce.exception.CouponException;
import com.johnbryce.model.Coupon;

public interface CompanyService {

	Coupon createCoupon(Coupon coupon) throws CouponException;

}