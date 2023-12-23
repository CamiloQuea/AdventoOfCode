package adventofcode_2023_1;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Utils {
	public Scanner readFile() {
		Scanner reader = null;
		try {
			URL url = getClass().getResource("input.txt");
			File file = new File(url.getPath());
			reader = new Scanner(file);

			return reader;

		} catch (Exception e) {
			System.out.println("An error has occured.");
			e.printStackTrace();
		}

		return reader;
	}
	
	
	public Map<String, String> numberConfig(){
		Map<String, String> numberList = new HashMap<String, String>();
		
		numberList.put("one", "1");
		
		numberList.put("two", "2");
		
		numberList.put("three", "3");
		
		numberList.put("four", "4");
		
		numberList.put("five", "5");
		
		numberList.put("six", "6");
		
		numberList.put("seven", "7");
		
		numberList.put("eight", "8");
		
		numberList.put("nine", "9");

		return numberList;
	}
	
}
