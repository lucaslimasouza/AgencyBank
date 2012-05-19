package br.com.agencybank.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class Account {

	protected String number;
	protected Money money;
	protected String kindOf;
	private List<Transaction> transactions;
	
	public Account(String number, Money money, String kindOf) {
		this.money = money;
		this.number = number;
		this.kindOf = kindOf;
		transactions = new ArrayList<Transaction>();
	}
	
	public static Account Saving(String number){
		return new Account(number, new Money(0.0), "SAVING");
	}
	
	public void save(Money  money) {
		if(money.isPositive()){
			this.money = money;
			transactions.add(new Transaction(new Date(),"SAVE", money));
		}
	}
	
	public Double balance() {
		return money.getValue();
	}
	
	public void withDraw(Money money) {
		if(money.isPositive()){
			this.money = this.money.discount(money);
			transactions.add(new Transaction(new Date(),"WITHDRAW", money));
		}
	}

	@Override
	public boolean equals(Object obj) {
		Account accountCompared = (Account) obj;
		return (this.toString().equals(accountCompared.toString()));
	}
	
	@Override
	public String toString() {
		return number;
	}

	public String extract() {
		StringBuffer historic = new StringBuffer();
		buildingHistoric(historic);
		return historic.toString();
	}

	private void buildingHistoric(StringBuffer historic) {
		Iterator transactionIterator = transactions.iterator();
		while(transactionIterator.hasNext()){
			Transaction transction = (Transaction) transactionIterator.next();
			historic.append(transction.toString());
		}
	}


}
