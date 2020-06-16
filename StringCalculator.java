package main;


public class StringCalculator {

	int Add(String numbers) {
		String[] newLinesSeparatedString = numbers.split("\n");

		String delimiter = newLinesSeparatedString[0].substring(2);

		return calulatedelimiterSeparatedNumbers(newLinesSeparatedString[1] , delimiter);

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
		else
			return Integer.parseInt(num);
	}

}
