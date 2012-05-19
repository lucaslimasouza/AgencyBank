package br.com.agencybank.test;

import java.util.Date;

import br.com.agencybank.model.BuilderResult;
import br.com.agencybank.model.Money;
import br.com.agencybank.model.Transaction;
import junit.framework.TestCase;

public class TransactionTest extends TestCase {
	
	private Date date;
	private String typeOperation;
	private Money money;

	public void testAdd(){
		Transaction transaction = new Transaction(date, typeOperation,money);		
		assertEquals(BuilderResult.make(date, typeOperation, money), transaction.toString());
	}

	public void setUp(){
		date = new Date();
		typeOperation = "SAVE";
		money = new Money(10);
	}
	

}
