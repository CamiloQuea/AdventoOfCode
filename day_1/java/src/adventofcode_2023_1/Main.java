package adventofcode_2023_1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Utils utils = new Utils();

		Scanner reader = utils.readFile();

		ArrayList<String> list = new ArrayList<String>();

		Map<String, String> numberConfig = utils.numberConfig();

		while (reader.hasNextLine()) {
			String value = reader.nextLine();

			String firstValue = "";

			String posibleLast = "";

			for (int i = 0; i < value.length(); i++) {

				char valueAtIndex = value.charAt(i);

				String stringChar = String.valueOf(valueAtIndex);

				Boolean isDigit = stringChar.matches("\\d+");

				if (!isDigit) {
					
					String partialText = value.substring(i, value.length());

					stringChar = textToValue(partialText);

				}

				if(stringChar=="") {
					continue;
				}
				
				System.out.println(stringChar);
				if (firstValue == "" )
					firstValue = stringChar;
				posibleLast = stringChar;
			}

			String finalValue = firstValue + posibleLast;

			list.add(finalValue);

			System.out.println(value + " - " + finalValue);

		}

		int totalSum = 0;

		for (int i = 0; i < list.size(); i++) {

			totalSum += Integer.parseInt(list.get(i));

		}

		System.out.println("FINAL SUM IS: " + totalSum);

	}

	public static String textToValue(String text) {
		Utils utils = new Utils();
		Map<String, String> numberConfig = utils.numberConfig();

		String value = "";

		for (int i = 1; i < text.length(); i++) {

			String key = text.substring(0, i + 1);

			String valueOfKey = numberConfig.get(key);

			if (valueOfKey != null) {

				value = valueOfKey;

			}

		}

		return value;
	}

}
