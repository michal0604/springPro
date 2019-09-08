package spring.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.OffsetDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="COUPON")

public class Coupon implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Basic(optional = false)
	@Column(nullable = false, name="title")
	private String title;
	
	@Basic(optional = false)
	@Column(nullable = false, name="startDate")
	private Date startDate;
	
	@Basic(optional = false)
	@Column(nullable = false, name="endDate")
	private Date endDate;
	
	@Basic(optional = false)
	@Column(nullable = false, name="amount")
	private int amount;
	
	
	
	@Basic(optional = false)
	@Column(nullable = false, name="message")
	private String message;
	
	@Basic(optional = false)
	@Column(nullable = false, name="price")
	private double price;

	@Basic(optional = false)
	@Column(nullable = false, name="image")
	private String image;
	
	@Basic(optional = false)
	@Column(nullable = false, name="type")
	@Enumerated(EnumType.STRING)
	private CouponType type;
	
	

}


