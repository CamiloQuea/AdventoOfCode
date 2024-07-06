package adventofcode_2023_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Engine {

	ArrayList<String> engineLines;
	ArrayList<int[]> symbolsIndexes;
	int width;
	int heigth;

	public Engine(ArrayList<String> engineLines) {
		this.engineLines = engineLines;
		this.symbolsIndexes = getAllIndexesSymbol();
		this.width = getWidth();
		this.heigth = getHeigth();
	}

	public void firstPart() {

		findNumberAround();

	}

	private ArrayList<int[]> getAllIndexesSymbol() {
		ArrayList<int[]> list = new ArrayList<int[]>();
		for (int i = 0; i < this.engineLines.size(); i++) {
			String line = this.engineLines.get(i);
			for (int j = 0; j < line.length(); j++) {
				char character = line.charAt(j);
				if (!Character.isLetter(character) && !Character.isDigit(character)
						&& !Character.isWhitespace(character) && !String.valueOf(character).equals(".")) {
					int[] array = new int[2];
					array[0] = i;
					array[1] = j;
					list.add(array);
				}
			}
		}
		return list;
	}

	private ArrayList<int[]> findNumberAround() {
		ArrayList<int[]> coordenates = new ArrayList<int[]>();
		Map<String, Integer> mapcoords = new HashMap<String, Integer>();  
		for (int i = 0; i < symbolsIndexes.size(); i++) {
			int x = symbolsIndexes.get(i)[0];
			int y = symbolsIndexes.get(i)[1];
	
			int startXIndex = x - 1 < 0 ? 0 : x - 1;
			int startYIndex = y - 1 < 0 ? 0 : y - 1;
			int endXIndex = x + 1 > width - 1 ? width - 1 : x + 1;
			int endYIndex = y + 1 > heigth - 1 ? heigth - 1 : y + 1;
	
			
			for (int j = startXIndex; j <= endXIndex; j++) {
				String line = engineLines.get(j);
				for (int k = startYIndex; k <= endYIndex; k++) {
					char character = line.charAt(k);
					if (!Character.isDigit(character)) {
						continue;
					}
					int[] coordenate = new int[2];
					coordenate[0] = k;
					coordenate[1] = j;
					coordenates.add(coordenate);
					
					int[] startNumberCoords= startCoordsNumber(coordenate);
					
					
					int number= resolveNumberCoords(startNumberCoords);
					
					String key= startNumberCoords[0]+"-"+startNumberCoords[1];
					if (!mapcoords.containsKey(key)) {
						mapcoords.put(key,number);
					}
				
					
					
				
//					System.out.println("THERE'S IN " + j + "-" + k + ": " + character +"; and start at "+ startNumberCoords[0]+"-"+startNumberCoords[1]);
				}
			}
			
			
			
			
		}

			int Total = 0; 
		
		for (String key : mapcoords.keySet()) {
			System.out.println(key + ":" + mapcoords.get(key));
			
			int number = Integer.valueOf( mapcoords.get(key));
			Total+=number;
			
		}
		
		System.out.println("TOTAL: "+Total);
		
		
		
		return coordenates;
	}

	private int[] startCoordsNumber(int[] coordenates) {
		int[] coordenatesStart = new int[2];
		coordenatesStart[0] = coordenates[0];
		coordenatesStart[1] = coordenates[1];
		String line = engineLines.get(coordenates[1]);
		boolean NotFound = true;
		
		for (int i = coordenates[0]; NotFound && i >= 0; i--) {
			char character = line.charAt(i);
			if (Character.isDigit(character)) {
				coordenatesStart[0]=i;
				continue;
			}
			NotFound= false;
		}
		return coordenatesStart;
	}
	
	private int resolveNumberCoords(int[] coordenates) {
		System.out.println(coordenates[0]+"-"+coordenates[1]);
		int startIndex = coordenates[0];
		int endIndex = coordenates[0];
		String line = engineLines.get(coordenates[1]);
		boolean NotFound = true;
		for (int i = endIndex; NotFound && i<line.length(); i++) {
			System.out.println(line.length()+"ERROR ACA:"+i);
			char character = line.charAt(i);
			if (Character.isDigit(character)) {
				endIndex = i;
				continue;
			}
			NotFound = false;
		}
		String numberString = line.substring(startIndex, endIndex+1);
		return Integer.valueOf(numberString);
				
	}

	private int getWidth() {
		return engineLines.get(0).length();
	}

	private int getHeigth() {
		return engineLines.size();
	}

}
