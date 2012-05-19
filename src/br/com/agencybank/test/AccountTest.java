package br.com.agencybank.test;

import java.util.Date;

import br.com.agencybank.model.Account;
import br.com.agencybank.model.BuilderResult;
import br.com.agencybank.model.Money;
import junit.framework.TestCase;

public class AccountTest extends TestCase {
	
	Account account;
	String accountNumber;
	Money money;
	private Date date;
	
	public void testCreating(){
		assertEquals(accountNumber, account.toString());
	}
	
	public void testEquality(){
		assertTrue(account.equals(account));
		assertFalse(account.equals(Account.Saving("12")));
	}
	
	public void testSaveMoney(){
		account.save(money);
		assertEquals(35.0, account.balance());
	}
	
	public void testWithDrawMoney(){
		account.save(money);
		account.withDraw(new Money(14));
		assertEquals(21.0, account.balance());
	}
	
	public void testSaveNegativeValue(){
		account.save(new Money(-10));
		assertEquals(0.0, account.balance());
	}
	
	public void testWithDrawNegativeValue(){
		account.save(money);
		account.withDraw(new Money(-10));
		assertEquals(35.0, account.balance());
	}
	
	public void testSaveWithTransaction(){
		account.save(money);
		assertEquals(BuilderResult.make(date, "SAVE", money), account.extract());
	}
	
	public void testWithDrawWithTransaction(){
		account.withDraw(money);
		assertEquals(BuilderResult.make(date, "WITHDRAW", money), account.extract());
	}
	
	public void testSaveAndWithDrawTransaction(){
		account.save(money);
		account.withDraw(money);
		StringBuffer report = new StringBuffer();
		report.append(BuilderResult.make(date, "SAVE", money));
		report.append(BuilderResult.make(date, "WITHDRAW", money));
		assertEquals(report.toString(), account.extract());
	}
	
	public void setUp(){
		accountNumber = "1234";
		account = Account.Saving(accountNumber);
		money = new Money(35);
		date = new Date();
	}

}
