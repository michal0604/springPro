package spring.utils;

import spring.model.ClientType;

public interface CouponClientFacade {
	
	public CouponClientFacade login (String name, String password, ClientType clientType);

}