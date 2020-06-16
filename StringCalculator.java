package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

	int Add(String numbers) throws InvalidNumbers, InvalidDelimiter{
		String[] newLinesSeparatedString = numbers.split("\n");

		String delimiter = "ABAB";
		List<String> allDelimiter  = new  ArrayList<>();
		allDelimiter = checkingDelimiter(newLinesSeparatedString[0]);
		
		for (String del : allDelimiter) {
			if (del.length()> 1) {
				throw new InvalidDelimiter("length longer than one char" + del);
			}
		}
		
		allDelimiter.forEach((del) -> {
			newLinesSeparatedString[1] = newLinesSeparatedString[1].replace(del, delimiter);
		});
		
		
		if (newLinesSeparatedString[1].contains("-")) {
			String message = checkNegativeNumber(newLinesSeparatedString[1], delimiter);
			throw new InvalidNumbers("negatives not allowed - "+ message);
		}

		return calulatedelimiterSeparatedNumbers(newLinesSeparatedString[1] , delimiter);

	}

	private List<String> checkingDelimiter(String string) {
		List<String> list = new ArrayList<>();
		string = string.substring(3, string.length() -1);
		string = string.replace("][", "CCC");
		list = new ArrayList<String>(Arrays.asList(string.split("CCC")));		
		return list;
	}

	private String checkNegativeNumber(String string, String delimiter) {
		String message = "";
		String[] numbers = string.split(delimiter);
		for (String str : numbers) {
			if (str.contains("-")) {
				message = message + str + " ";
			}
		}
				
		
		return message;
	}

	private int calulatedelimiterSeparatedNumbers (String str, String delimiter) {
		int calValue = 0;
		String[] delimiterSeparatedNumbers = str.split(delimiter);
		for (String newStr : delimiterSeparatedNumbers) {
			calValue = calValue + calculateNumber(newStr);
		}		
		return calValue;		
	}

	private int calculateNumber(String num) {
		if (num.equalsIgnoreCase(""))
			return 0;
		else if (Integer.parseInt(num) > 1000)
			return 0;
		else
			return Integer.parseInt(num);
	}

}

class InvalidNumbers extends Exception {
	public InvalidNumbers( String message) {
		super(message);		
	}
}
class InvalidDelimiter extends Exception {
	public InvalidDelimiter( String message) {
		super(message);		
	}
}
