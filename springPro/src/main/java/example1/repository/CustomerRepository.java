package example1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import example1.model.Customer;



@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	void deleteCustomerById(int customerId);

	Customer findByNameAndPassword(String name, String password);

	Customer findByName(String name);
}