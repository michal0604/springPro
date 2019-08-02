package com.johnbryce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.johnbryce.model.Company;

public interface  CompanyRepository extends JpaRepository<Company, Long> {
	
	Company findByNameAndPassword(String name, String password);

	void deleteCompanyById(int companyId);

	Company findByName(String name);

}