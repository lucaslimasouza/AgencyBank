package br.com.agencybank.test;

import br.com.agencybank.model.Money;
import junit.framework.TestCase;

public class MoneyTest extends TestCase {
	
	Money ten;
	Money five;
	
	public void testCreat(){ 
		assertEquals(10.0, ten.getValue());
	}
	
	public void testSum(){
		assertTrue(new Money(20).equals(ten.plus(new Money(10))));
	}

	public void testSubtraction(){
		assertTrue(five.equals(ten.discount(five)));
	}
	
	public void testIsPositive(){
		assertTrue(ten.isPositive());
		assertFalse(new Money(-15).isPositive());
	}
	
	public void setUp(){
		ten = new Money(10.0);
		five = new Money(5);
	}
}
