package spring.utils;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import spring.exception.CouponException;
import spring.model.ClientType;
import spring.model.Company;
import spring.model.Customer;
import spring.repository.CompanyRepository;
import spring.repository.CustomerRepository;
import spring.service.AdminService;
import spring.service.AdminServiceImpl;
import spring.service.CompanyServiceImpl;
import spring.service.CustomerServiceImpl;

@Service
public class CouponSystem {

	@Autowired
	private ApplicationContext context;
	
	@Autowired
	AdminService adminFacade;
	
	@Autowired
	private CompanyRepository companyRepo;
	
	@Autowired
	private CustomerRepository customerRepo;
	
	
	
//	@PostConstruct
	//here will be couponsThread
	
//	@PreDestroy
	//here will be couponsThread
	
	
	
	
	
	public CouponClientFacade login (String name, String password, ClientType clientType) throws CouponException {
		switch (clientType) {
		case ADMIN:
			if (name.equals("admin")&&password.equals("1234")) {
				return (CouponClientFacade) adminFacade ;
			}
		case COMPANY:
			Company comp = companyRepo.findCompanyByCompanyNameAndPassword(name, password);
			if (comp!=null) {
				CompanyServiceImpl company =  context.getBean(CompanyServiceImpl.class);
				comp.setId(comp.getId());
				return company;
			}
		case CUSTOMER:
			Customer cust = customerRepo.findByCustomerNameAndPassword(name, password);
			if (cust!=null) {
				CustomerServiceImpl customer = context.getBean(CustomerServiceImpl.class);
				cust.setId(cust.getId());
				return customer;
			}
		}
		throw new CouponException("Login Falied! Invalid User or Password!");
	}
}
