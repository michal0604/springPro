package example1.service;

import java.util.List;

import example1.model.Company;

public interface CompanyService {

	List<Company> findAll();

	Company create(Company company);

}