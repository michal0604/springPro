package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.exception.CompanyException;
import spring.exception.CustomerException;
import spring.model.ClientType;
import spring.model.Company;
import spring.model.Customer;
import spring.repository.CompanyRepository;
import spring.repository.CustomerRepository;
import spring.utils.CouponClientFacade;

@Service
public class AdminServiceImpl implements AdminService, CouponClientFacade {

//	@Autowired
//	private CouponRepository couponRepository;
		
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	
	
	@Override
	public boolean checkIfCompanyNameAlreadyExists(String companyName) {
		if (companyRepository.findByCompanyName(companyName) != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public Company createCompany(Company company) throws CompanyException  {
		if (checkIfCompanyNameAlreadyExists(company.getCompanyName())==false) {
			companyRepository.save(company);
		}else {
			throw new CompanyException("The company " + company.getCompanyName()+" already exist, please try another name");
		}
		return company;
    }
	
	@Override
	public void deleteCompany(long id) {
		companyRepository.deleteById(id);
	}
	
	@Override
	public void updateCompany(Company company, String password, String email) {
		company.setPassword(password);
		company.setEmail(email);
		companyRepository.save(company);
	}
	
	@Override
	public List<Company> allCompanies(){
		return companyRepository.findAll();
	}
	
	@Override
	public Company companyById(long id) {
		return companyRepository.findById(id).get();
	}
	
	
	
	@Override
	public boolean checkIfCustomerNameAlreadyExists(String customerName) {
		if (customerRepository.findByCustomerName(customerName) != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public Customer createCustomer(Customer customer) throws CustomerException  {
		if (checkIfCustomerNameAlreadyExists(customer.getCustomerName())==false) {
			customerRepository.save(customer);
		}else {
			throw new CustomerException("The customer " + customer.getCustomerName() +" already exist, please try another name");
		}
		return customer;
	}
	
	@Override
	public void updateCustomer(Customer customer, String password) {
		customer.setPassword(password);
		customerRepository.save(customer);
	}
	
	@Override
	public void deleteCustomer(long id) {
		customerRepository.deleteById(id);
	}
	
	@Override
	public List<Customer> allCustomers(){
		return customerRepository.findAll();
	}
	
	@Override
	public Customer customerById(long id) {
		return customerRepository.findById(id).get();
	}

	@Override
	public CouponClientFacade login(String name, String password, ClientType clientType) {
		// TODO Auto-generated method stub
		return new AdminServiceImpl();
	}

	


}
