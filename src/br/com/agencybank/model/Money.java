package br.com.agencybank.model;

public class Money {

	private Double value;

	public Money(double value) {
		this.value = new Double(value);
	}

	public Double getValue(){
		return value;
	}

	public Money plus(Money money) {
		return new Money(value += money.getValue());
	}

	public Money discount(Money money) {
		return new Money(value -= money.getValue());
	}

	@Override
	public boolean equals(Object obj) {
		Money moneyCompared = (Money) obj;
		return this.getValue().equals(moneyCompared.getValue());
	}

	public boolean isPositive() {
		return value > 0.0;
	}

}
