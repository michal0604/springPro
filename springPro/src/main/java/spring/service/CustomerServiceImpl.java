package spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.exception.CouponException;
import spring.model.ClientType;
import spring.model.Coupon;
import spring.repository.CouponRepository;
import spring.repository.CustomerRepository;
import spring.utils.CouponClientFacade;

@Service
public class CustomerServiceImpl implements CustomerService, CouponClientFacade {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CouponRepository couponRepository;
	
	
	public void purchaseCoupon (long couponId) throws CouponException {
		Optional<Coupon> coupon = couponRepository.findById(couponId);
		
		if (coupon==null) {
			throw new CouponException("coupon is exists, try new coupon");
		}
		
		
	}


	@Override
	public CouponClientFacade login(String name, String password, ClientType clientType) {
		// TODO Auto-generated method stub
		return null;
	}
}