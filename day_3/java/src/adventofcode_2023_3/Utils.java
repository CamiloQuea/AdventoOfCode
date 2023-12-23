package adventofcode_2023_3;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {
	public ArrayList<String> readFile() {

		ArrayList<String> list = new ArrayList<String>();

		try {
			Scanner reader = null;
			URL url = getClass().getResource("input2.txt");
			File file = new File(url.getPath());
			reader = new Scanner(file);
			while (reader.hasNext()) {
				String game = reader.nextLine();
				list.add(game);
			}
			reader.close();

		} catch (Exception e) {
			System.out.println("An error has occured.");
			e.printStackTrace();
		}

		return list;
	}

}
