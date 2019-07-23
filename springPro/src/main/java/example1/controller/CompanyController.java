package example1.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example1.model.Company;
import example1.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {
	
	@Resource
	private CompanyService companyService;
	
	@GetMapping("/")
	public ResponseEntity<List<Company>> findAll() {
		ResponseEntity<List<Company>> result = new ResponseEntity<List<Company>>(companyService.findAll(), HttpStatus.OK);
		return result;
	}
	
	@PostMapping("/")
	public ResponseEntity<Company> create(@RequestBody Company company) {
		System.out.println("beofre: " +company);		
		Company newCompany = companyService.create(company);
		System.out.println("after:" + company);
		ResponseEntity<Company> result = new ResponseEntity<Company>(newCompany, HttpStatus.OK);
		return result;
	}

}
