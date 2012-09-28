package br.com.bruno.model;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Invoice {

	@Id
	@GeneratedValue
	private Long id;
	private BigDecimal ammount;
	private Calendar dueDate;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getAmmount() {
		return ammount;
	}
	public void setAmmount(BigDecimal ammount) {
		this.ammount = ammount;
	}
	public Calendar getDueDate() {
		return dueDate;
	}
	public void setDueDate(Calendar dueDate) {
		this.dueDate = dueDate;
	}
	
}
