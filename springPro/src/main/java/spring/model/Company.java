package spring.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@Table(name="company")
@NoArgsConstructor
public class Company implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Basic(optional = false)
	@Column(nullable = false, name="companyName")
	private String companyName;
	
	
	@Basic(optional = false)
	@Column(nullable = false, name="password")
	private String password;
	
	
	@Basic(optional = false)
	@Column(nullable = false, name="email")
	private String email;
	
	
//    @OneToMany//(cascade=CascadeType.PERSIST)
	private List<Coupon> coupons;
    
	@Access(AccessType.PROPERTY)
	
	@OneToMany
    public List<Coupon> getCoupons(){
    	return coupons;
    }
    
    public void setCoupons(List<Coupon>coupons) {
    	this.coupons=coupons;
    }
    
   
    }
    
  

