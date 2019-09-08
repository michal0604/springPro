package spring.service;

import java.util.List;

import spring.model.Company;
import spring.model.Customer;

public interface AdminService {

	Company createCompany(Company company) throws Exception;

	void deleteCompany(long id);

	List<Company> allCompanies();

	Company companyById(long id);

	Customer createCustomer(Customer customer) throws Exception;

	void deleteCustomer(long id);

	boolean checkIfCompanyNameAlreadyExists(String companyName);

	void updateCompany(Company company, String password, String email);

	void updateCustomer(Customer customer, String password);

	List<Customer> allCustomers();

	Customer customerById(long id);

	boolean checkIfCustomerNameAlreadyExists(String customerName);

}
