package spring.model;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="INCOME")

public class Income {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
  private long id;
	
	@Basic(optional = false)
	@Column(nullable = false, name="name")
  private String name;
	
	@Basic(optional = false)
	@Column(nullable = false, name="date")
  private Date date;
	
	@Basic(optional = false)
	@Column(nullable = false, name="description")
  private IncomeType description;
	
	@Basic(optional = false)
	@Column(nullable = false, name="amount")
	private double amount;
}
