package br.com.agencybank.model;

import java.util.Date;

public class BuilderResult {
	
	private static StringBuffer result;
	

	private static void buildValue(double value) {
		result.append(" ");
		result.append("VALUE = ");
		result.append(value);
	}

	private static void buildTypeOperation(String typeOperation) {
		result.append("OPERATION = ");
		result.append(typeOperation);
	}

	private static void buildDate(Date date) {
		result.append(date.toString());
		result.append(" ");
	}

	public static String make(Date date, String typeOperation, Money value) {
		result = new StringBuffer();
		buildDate(date);
		buildTypeOperation(typeOperation);
		buildValue(value.getValue());
		return result.toString();
	}


}
