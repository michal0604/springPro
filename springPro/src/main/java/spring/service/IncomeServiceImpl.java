package spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.model.Income;
import spring.repository.IncomeRepository;

@Service
public class IncomeServiceImpl implements IncomeService{

	@Autowired
	private IncomeRepository incomeRepository;
	
	@Override
	public Income storeIncome (Income income) {
		incomeRepository.save(income);
		return income;
	}
	
	@Override
	public List<Income> allIncome(){
		return incomeRepository.findAll();
	}
}