package adventofcode_2023_2;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		Utils utils = new Utils();

		ArrayList<String> rows = utils.readFile();

		ArrayList<Game> games = new ArrayList<Game>();

		int totalOfIds= 0;
		int totalMinPower = 0;
		for (Iterator<String> iterator = rows.iterator(); iterator.hasNext();) {
			String string = iterator.next();

			Game game = new Game(string);

			games.add(game);
			Boolean posible = game.verifyGame(12, 13, 14);
			
			
			totalMinPower+= game.minPower();
			if(posible) {
				totalOfIds+=game.id;
				System.out.println("POSIBLE!!! TOTAL IN: "+totalOfIds);
				continue;
			}
			
			System.out.println("NOT POSIBLE");
			

		}

//		printGamesInfo(games);
		System.out.println("*****************");
		System.out.println("SUM OF THE POSIBLE IDS GAME IDS: "+totalOfIds);
		System.out.println("TOTAL MIN POWER OF GAMES: "+totalMinPower);

	}
//
//	public static void printGamesInfo(ArrayList<Game> games) {
//
//		int totalBlue = 0;
//		int totalRed = 0;
//		int totalGreen = 0;
//
//		for (Iterator<Game> iterator = games.iterator(); iterator.hasNext();) {
//			Game game = (Game) iterator.next();
//			totalBlue += game.blue;
//			totalRed += game.red;
//			totalGreen += game.green;
//		}
//
////		System.out.println(games.size());
//
//	}

}
