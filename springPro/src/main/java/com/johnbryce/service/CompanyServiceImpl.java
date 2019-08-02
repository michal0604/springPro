package com.johnbryce.service;

import java.sql.Date;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.johnbryce.exception.CouponException;
import com.johnbryce.model.Coupon;
import com.johnbryce.repository.CouponRepository;
import com.johnbryce.utils.Utile;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Resource
	private CouponRepository couponRepository;
	
	Logger logger = LoggerFactory.getLogger(CompanyServiceImpl.class);

	@Override
	@Transactional
	public Coupon createCoupon(Coupon coupon) {
		logger.debug("Create coupon"+coupon.toString());
		if (coupon != null) {
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
		return companyRepository.save(company);
	}

}
