package com.johnbryce.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
	@Id
	@GeneratedValue
	private long id;
	
	@Basic(optional = false)
	@Column(nullable = false)
	private String name;
	
	@Basic(optional = false)
	@Column(nullable = false)
	private String password;
	
	@Basic(optional = false)
	@Column(nullable = false)
	private String email;
	
	
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
	@Valid
	private List<Coupon> coupons;
}
