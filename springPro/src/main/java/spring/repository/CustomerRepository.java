package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	Customer findByCustomerName(String customerName);
	
	Customer findByCustomerNameAndPassword(String customerName, String password);

}
