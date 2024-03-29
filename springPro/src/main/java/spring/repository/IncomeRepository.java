package spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.model.Income;

@Repository
public interface  IncomeRepository extends JpaRepository<Income, Long> {

}
