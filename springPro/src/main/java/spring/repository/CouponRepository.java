package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.model.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Long>{

	Coupon findByTitle(String title);
	
//	@Query("SELECT c FROM coupon AS c WHERE c.endDate <= startDate")
//	List<Coupon> findExpiredCoupons;

}