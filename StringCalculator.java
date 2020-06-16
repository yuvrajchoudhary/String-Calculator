package main;


public class StringCalculator {

	int Add(String numbers) throws InvalidNumbers {
		String[] newLinesSeparatedString = numbers.split("\n");

		String delimiter = newLinesSeparatedString[0].substring(2);
		/**
		 * Step 5 handling exception
		 */
		if (newLinesSeparatedString[1].contains("-")) {
			String message = checkNegativeNumber(newLinesSeparatedString[1], delimiter);
			throw new InvalidNumbers("negatives not allowed - "+ message);
		}

		return calulatedelimiterSeparatedNumbers(newLinesSeparatedString[1] , delimiter);

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
