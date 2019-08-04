package com.johnbryce.service;

import java.sql.Date;
import java.util.Optional;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchProperties;
import org.springframework.stereotype.Service;

import com.johnbryce.exception.CouponException;
import com.johnbryce.model.Company;
import com.johnbryce.model.Coupon;
import com.johnbryce.repository.CouponRepository;
import com.johnbryce.utils.Utile;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Resource
	private CouponRepository couponRepository;
	private Company company;
	Logger logger = LoggerFactory.getLogger(CompanyServiceImpl.class);

	@Override
	public CouponClientService login(String name, String password) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	@Transactional
	public Coupon createCoupon(Coupon coupon) throws CouponException {
			if (coupon != null) {
			logger.debug("Create coupon"+coupon.toString());
			String CoupTitle = coupon.getTitle();
			if (CoupTitle != null) {
				Date startDate = coupon.getStartDate();
				Date endDate =  coupon.getEndDate();
				if (startDate.getTime() <= endDate.getTime()) {
					if (startDate.getTime() >= Utile.getCurrentDate().getTime()) {
						if (couponRepository.findByTitle(CoupTitle).isEmpty()/*== null*/) {
							coupon = couponRepository.save(coupon);
							return coupon;
						} else {
							throw new CouponException("Coupon Title is Already Exists! Create New Coupon is Canceled!");
						}
					}else {
						throw new CouponException("invalid coupon start time is in the past");
					}
				}else {
					throw new CouponException("invalid coupon start time in after the end time");
				}
			}else {
				throw new CouponException("invalid coupon has no title");
			}
		}else {
			throw new CouponException("invalid null coupon");
		}
	}
	
	@Override
	@Transactional
	public void removeCouponID(long coupId) throws Exception {
		Optional<Coupon> findById = couponRepository.findById(coupId);
		if (coupId > 0 || findById.isPresent()) {
			if(company.getCoupons().contains(findById.get())) {
				couponRepository.deleteById(coupId);
			}else {
				throw new CouponException("cannot delete coupon  that doesn't belog to the company");
			}
		}else{
			throw new CouponException("invalid coupon id");
		}
	}
	
	@Override
	@Transactional
	public Coupon updateCoupon(Coupon coupon) throws Exception {
		if (coupon != null) {
			long couponId = coupon.getId();
			Optional<Coupon> findById = couponRepository.findById(couponId);
			if (findById.isPresent() && company.getCoupons().contains(findById.get()) ) {
				Double CoupPrice = coupon.getPrice();
				if (CoupPrice > 0) {
					Date startDate = coupon.getStartDate();
					Date endDate = coupon.getEndDate();
					if (startDate.getTime() <= endDate.getTime()) {
						couponRepository.delete(coupon);
						return couponRepository.save(coupon);
					} else {
						throw new CouponException("Update Coupon as the end date is before the start date");
					}

				} else {
					throw new CouponException(" Update Coupon failed due to invalid price");
				}

			} else {
				throw new CouponException("cannot update coupon as there is no coupon with that id in the coupmany");
			}
		}else {
			throw new CouponException("invalid null coupon");
		}
	}

}