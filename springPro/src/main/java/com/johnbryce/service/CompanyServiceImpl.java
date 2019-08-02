package com.johnbryce.service;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.johnbryce.exception.CouponException;
import com.johnbryce.model.Company;
import com.johnbryce.model.Coupon;
import com.johnbryce.repository.CompanyRepository;
import com.johnbryce.utils.Utile;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Resource
	private CompanyRepository companyRepository;
	
	Logger logger = LoggerFactory.getLogger(CompanyServiceImpl.class);
	/* (non-Javadoc)
	 * @see example1.service.CompanyService#findAll()
	 */
	@Override
	public List<Company> findAll() {
		return companyRepository.findAll();
	}

	@Override
	@Transactional
	public Coupon createCoupon(Coupon coupon) {
		logger.debug("Create coupon"+company.toString());
		if (coupon != null) {
			String CoupTitle = coupon.getTitle();
			if (CoupTitle != null) {
				Date startDate = (Date) coupon.getStart_date();
				Date endDate = (Date) coupon.getEnd_date();
				if (startDate.getTime() <= endDate.getTime()) {
					if (startDate.getTime() >= Utile.getCurrentDate().getTime()) {
						if (!couponDAO.isCouponTitleExists(CoupTitle)) {
							long id = couponDAO.insertCoupon(coupon);
							if (id != 0) {
								coupon = couponDAO.getCoupon(id);
							} else {
								throw new CouponException("create coupon failed by company");
							}
							company_CouponDAO.insertCompany_Coupon(companyId, coupon.getCouponId());
							System.out.println("create coupon by company success!!");
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
