package example1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import example1.model.Company;

public interface  CompanyRepository extends JpaRepository<Company, Long> {

}
