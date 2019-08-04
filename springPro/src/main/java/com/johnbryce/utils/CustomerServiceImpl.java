package com.johnbryce.utils;

import com.johnbryce.service.CouponClientService;

public interface CustomerServiceImpl extends CouponClientService {

	@Override
	CouponClientService login(String name, String password) throws Exception;

}
