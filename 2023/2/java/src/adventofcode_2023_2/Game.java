package adventofcode_2023_2;

import java.util.ArrayList;
import java.util.Iterator;

public class Game {
	String stringGame;
	int id;
	int red = 0;
	int blue = 0;
	int green = 0;

	public Game(String game) {

		this.stringGame = game;
		this.id = this.getId();

	}

	public int getId() {

		int startIndex = -1;
		int endIndex = -1;

		for (int i = 0; i < stringGame.length(); i++) {

			String character = String.valueOf(stringGame.charAt(i));

			if (character.equals(" ") && startIndex == -1) {
				startIndex = i + 1;
			} else if (character.equals(":") && endIndex == -1) {
				endIndex = i;
			} else if (startIndex == -1 || endIndex == -1) {
				continue;
			} else {
				break;
			}

		}

		String idString = stringGame.substring(startIndex, endIndex);
		
		return Integer.valueOf(idString);
	}

	public int getMinCountColor(String color) {

		ArrayList<Integer> endIndexes = this.getIndexesOf(color);

		int min = 0;

		for (Iterator<Integer> iterator = endIndexes.iterator(); iterator.hasNext();) {
			Integer idx = (Integer) iterator.next();
//			
			int startIndex = -1;
			for (int i = idx; i >= 0; i--) {

				String character = String.valueOf(stringGame.charAt(i));
				if (startIndex == -1 && (character.equals(",") || character.equals(";") || character.equals(":"))) {
					startIndex = i;
					break;
				}
			}

			String numberAsString = stringGame.substring(startIndex + 1, idx).strip();
			int amount = Integer.valueOf(numberAsString);
			
			if (min==0) {
				min=amount;
			}
			
			if(min<amount) {
				min=amount;
			}

		}

		return min;

	}
	
	public Boolean verifyCountColor(String color,int limit) {

		ArrayList<Integer> endIndexes = this.getIndexesOf(color);

		for (Iterator<Integer> iterator = endIndexes.iterator(); iterator.hasNext();) {
			Integer idx = (Integer) iterator.next();
			int startIndex = -1;
			for (int i = idx; i >= 0; i--) {

				String character = String.valueOf(stringGame.charAt(i));
				if (startIndex == -1 && (character.equals(",") || character.equals(";") || character.equals(":"))) {
					startIndex = i;
					break;
				}
			}

			String numberAsString = stringGame.substring(startIndex + 1, idx).strip();
			int amount = Integer.valueOf(numberAsString);
			
			if(amount>limit) {
				return false;
			}

		}

		return true;

	}
	
	public int minPower() {
		
		int green = getMinCountColor("green");
		
		int red  = getMinCountColor("red");
		
		int blue = getMinCountColor("blue");
		System.out.println("GREEN: "+green+"RED: "+red+" BLUE: "+blue);
		return green*red*blue;
	}

	public ArrayList<Integer> getIndexesOf(String color) {

		ArrayList<Integer> indexes = new ArrayList<Integer>();

		int startAt = 0;

		Boolean done = false;

		while (!done) {

			int index = stringGame.indexOf(color, startAt);

			if (index == -1) {
				done = true;
				break;
			}

			indexes.add(index);

			startAt = index + color.length();

		}

		return indexes;

	}

	public Boolean verifyGame(int red, int green, int blue) {

		if (verifyCountColor("red",red) && verifyCountColor("blue",blue) && verifyCountColor("green",green)) {
			
			return true;

		}

		return false;
	}

}
