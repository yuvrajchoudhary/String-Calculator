package main;


public class StringCalculator {

	int Add(String numbers) {
		int sum = 0;
		
		if(	numbers.contains(",\n") || numbers.contains("\n,")) {
			// string is NOT ok
			return 0;
		}
		
		String[] newLinesSeparatedNumbers = numbers.split("\n");
		
		for (String str : newLinesSeparatedNumbers) {
			if(str.contains(",")) {
				sum = sum + calulateCommaSeparatedNumbers(str);				
			}
			else {
				sum = sum + calculateNumber(str);
			}
			
		}	
		
		return sum;
	}
	
	private int calulateCommaSeparatedNumbers (String str) {
		int calValue = 0;
		String[] commaSeparatedNumbers = str.split(",");
		for (String newStr : commaSeparatedNumbers) {
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
