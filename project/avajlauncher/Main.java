package project.avajlauncher;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import project.avajlauncher.exceptions.FileFormattingException;
import project.avajlauncher.exceptions.AircraftException;

public class Main {

	public static void main(String[] args) {
		if (args.length != 1 || args[0].lastIndexOf(".txt") != args[0].length() - 4)
		{
			System.out.println("Usage: java Main [scenario.txt]");
			return ;
		}
		try {
			LinkedHashMap<Integer, String[]> lines = Parser.parse(args[0]);
			Simulation sim = new Simulation(lines);
		}
		catch (FileNotFoundException e) {
			System.out.println(
				"FileNotFoundException" + ": '" +
				args[0] + "': file not found"
			);
		}
		catch (FileFormattingException e) {
			System.out.println(
				"FileFormattingException" + ": '" +
				args[0] + "' " + e.lineToString()
			);
		}
		catch (AircraftException e) {
			System.out.println("AircraftException" + ": " + e.toString());
		}
		catch (IOException e) {
			System.out.println(
				"IOException" + ": " +
				"'simulation.txt' " + ": logger error"
			);
		}
	}

}
