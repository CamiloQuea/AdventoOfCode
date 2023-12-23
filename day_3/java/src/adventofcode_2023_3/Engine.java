package adventofcode_2023_3;

import java.util.ArrayList;

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
		for (int i = 0; i < symbolsIndexes.size(); i++) {
			int x = symbolsIndexes.get(i)[0];
			int y = symbolsIndexes.get(i)[1];
			System.out.println(x + "-" + y);
			int startXIndex = x - 1 < 0 ? 0 : x - 1;
			int startYIndex = y - 1 < 0 ? 0 : y - 1;
			int endXIndex = x + 1 > width - 1 ? width - 1 : x + 1;
			int endYIndex = y + 1 > heigth - 1 ? heigth - 1 : y + 1;
			System.out.println(
					"THE RANGE IS GONNA BE: " + startXIndex + "-" + startYIndex + "; " + endXIndex + "-" + endYIndex);
			for (int j = startXIndex; j <= endXIndex; j++) {
				String line = engineLines.get(j);
				for (int k = startYIndex; k <= endYIndex; k++) {
					char character = line.charAt(k);
					if (!Character.isDigit(character)) {
						continue;
					}
					int[] coordenate = new int[2];
					coordenate[0] = j;
					coordenate[1] = k;
					coordenates.add(coordenate);
					
					int[] startNumberCoords= resolveNumber(coordenate);
					
					System.out.println("THERE'S IN " + j + "-" + k + ": " + character +"; and start at "+ startNumberCoords[0]+"-"+startNumberCoords[1]);
				}
			}
		}

		return coordenates;
	}

	private int[] resolveNumber(int[] coordenates) {
		int number = -1;
		int[] coordenatesStart = new int[2];
		coordenatesStart[0] = -1;
		coordenatesStart[1] = -1;

		String line = engineLines.get(coordenates[1]);

		for (int i = coordenates[0]; coordenatesStart[0] == -1 && i >= 0; i--) {

			char character = line.charAt(i);

			if (Character.isDigit(character)&& i>0) {
				continue;
			}
			
			coordenatesStart[0]=i;

		}

		for (int i = coordenates[0]; coordenatesStart[1]==-1&&i<=width-1; i++) {

			char character = line.charAt(i);

			if (Character.isDigit(character)&& i<width-1) {
				continue;
			}
			
			coordenatesStart[1]=i;
			
		}

		return coordenatesStart;

	}

	private int getWidth() {
		return engineLines.get(0).length();
	}

	private int getHeigth() {
		return engineLines.size();
	}

}
