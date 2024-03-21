package java.project.avajlauncher;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main
{
	public static void main(String[] args) 
	{
		if (args.length != 1 || args[0].lastIndexOf(".txt") != args[0].length() - 4)
		{
			System.out.println("Usage: java Main [scenario.txt]");
			return ;
		}
		int					loops = 0;
		ArrayList<String[]>	lines = new ArrayList<String[]>();
		WeatherTower		tower = new WeatherTower();

		try {
			lines = Parser.parse(args[0]);
			loops = Integer.parseInt(lines.get(0)[0]);
			for (int i = 1; i < lines.size() - 1; i++)
			{
				AircraftFactory.newAircraft(
					lines.get(i)[0], lines.get(i)[1], new Coordinates(
						Integer.parseInt(lines.get(i)[2]), 
						Integer.parseInt(lines.get(i)[3]), 
						Integer.parseInt(lines.get(i)[4]))).registerTower(tower);
			}
		}
		catch (FileNotFoundException e){
			System.out.println("Error: " + args[0] + ": file not found");
			return ;
		}
		catch (IOException | NumberFormatException e){
			System.out.println("Error: " + args[0] + ": file formatting error");
			return ;
		}
		catch (AircraftFactoryException e){
			System.out.println("Error: " + e.s);
			return ;
		}
		while (--loops > -1)
			tower.changeWeather();
	}
}
