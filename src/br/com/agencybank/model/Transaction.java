package br.com.agencybank.model;

import java.util.Date;

public class Transaction {

	private final Date date;
	private final String typeOperation;
	private final Money value;

	public Transaction(Date date, String typeOperation, Money money) {
		this.date = date;
		this.typeOperation = typeOperation;
		this.value = money;
	}
	
	@Override
	public String toString() {
		return BuilderResult.make(date, typeOperation, value);
	}

	

	
}
