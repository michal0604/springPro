package spring.service;

import java.sql.Date;

import spring.model.Company;
import spring.model.Coupon;

public interface CompanyService {

//	List<Company> findAll();

	Coupon createCoupon(Coupon coupon) throws Exception;

	boolean checkIfTitleAlreadyExists(String title);

	void updateCoupon(Coupon coupon, Date endDate, double price);

	Company companyById(long id);

	void deleteCoupon(long id);


}
