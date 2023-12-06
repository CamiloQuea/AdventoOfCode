package adventofcode_2023_3;

import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {

		Utils utils = new Utils();
		
		ArrayList<String> engineLines = utils.readFile();
		
		Engine engine = new Engine(engineLines);
		
		engine.firstPart();

//		for (Iterator<String> iterator = texts.iterator(); iterator.hasNext();) {
//			String line = iterator.next();
//
//		}

//		System.out.println(engine.symbolsIndexes);
	}

}
