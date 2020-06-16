package main;

public class StringCalculator {

	int Add(String numbers) {
		int sum = 0;
		String[] commaSeparatedNumbers = numbers.split(",");
		for (String str : commaSeparatedNumbers) {
			if (str.equalsIgnoreCase(""))
				sum = sum + 0;
			else
				sum = sum + Integer.parseInt(str);
		}	
		
		return sum;
	}

}
