package br.com.agencybank.model;

import java.util.ArrayList;
import java.util.List;

public class Bank {

	private final String agency;
	private List<Account> accounts;

	public Bank(String agency){
		this.agency = agency;
		this.accounts = new ArrayList<Account>();
	}
	
	@Override
	public String toString() {
		return agency;
	}

	public void add(Account account) {
		accounts.add(account);
	}
	
	public int numberOfAccount(){
		return accounts.size();
	}

	public boolean closeAccount(Customer customer) {		
		return accounts.remove(customer.getAccount());	
	}

	public void transfer(Money money, Account fromAccount, Account toAccount) {
		Money moneyToTransfer = new Money(money.getValue());
		fromAccount.withDraw(money);
		toAccount.save(moneyToTransfer);		
	}
}
