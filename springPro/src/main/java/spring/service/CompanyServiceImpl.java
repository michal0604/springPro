package spring.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.model.ClientType;
import spring.model.Company;
import spring.model.Coupon;
import spring.repository.CompanyRepository;
import spring.repository.CouponRepository;
import spring.utils.CouponClientFacade;

@Service
public class CompanyServiceImpl implements CompanyService, CouponClientFacade {


//	private long compId;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private CouponRepository couponRepository;
	
//	@Override
//	public List<Company> findAll(){
//		return companyRepository.findAll();
//	}
	
	@Override
	public boolean checkIfTitleAlreadyExists(String title) {
		if (couponRepository.findByTitle(title) != null) {
			return true;
		}
		return false;
	}
	@Override
	public Coupon createCoupon(Coupon coupon) throws Exception {
		if (checkIfTitleAlreadyExists(coupon.getTitle())== false) {
			couponRepository.save(coupon);
			Company comp = companyRepository.findById((long) 1).get();
			comp.getCoupons().add(coupon);
			companyRepository.save(comp);
		}else {
			throw new Exception("The title " + coupon.getTitle() +" already exist, please try another title");
		}
		return coupon;
	}
	
	@Override 
	public void updateCoupon(Coupon coupon, Date endDate, double price) {
		coupon.setEndDate(endDate);
		coupon.setPrice(price);
		couponRepository.save(coupon);
	}
	
	
	@Override
	public void deleteCoupon(long id) {
		couponRepository.deleteById(id);
	}
	
	@Override
	public Company companyById(long id) {
		return companyRepository.findById(id).get();
	}
	@Override
	public CouponClientFacade login(String name, String password, ClientType clientType) {
		// TODO Auto-generated method stub
		return null;
	}
	
	


}
