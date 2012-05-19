package br.com.agencybank.test;

import br.com.agencybank.model.Account;
import br.com.agencybank.model.Bank;
import br.com.agencybank.model.Customer;
import br.com.agencybank.model.Money;
import junit.framework.TestCase;

public class BankTest extends TestCase {
	
	Bank bank;
	String agency;
	Account account;
	private Money money;
	
	public void testAgency(){
		assertEquals(agency, bank.toString());
		
	}
	
	public void testadditionAccount(){
		bank.add(account);
		assertEquals(1, bank.numberOfAccount());
	}
	
	public void testClosingAccount(){
		bank.add(account);
		Customer lucas = new Customer();
		lucas.setAccount(account);
		assertTrue(bank.closeAccount(lucas));
	}
	
	public void testTransferMoney(){
		account.save(money);
		Account toAccount = Account.Saving("345");
		bank.transfer(money,account,toAccount);
		assertEquals(0.0, account.balance());
		assertEquals(35.0, toAccount.balance());
	}
	
	public void setUp(){
		bank = new Bank(agency);
		account = Account.Saving("123");
		money = new Money(35);
	}

}
