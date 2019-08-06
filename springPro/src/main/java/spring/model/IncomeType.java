package spring.model;

public enum IncomeType {
	CUSTOMER_PURCHASE("customer purchase"),
	COMPANY_NEW_COUPON("company created new coupon"),
	COMPANY_UPDATE_COUPON("company updated coupon");
	
	private String description;

	private IncomeType(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}


	
	
	
}
