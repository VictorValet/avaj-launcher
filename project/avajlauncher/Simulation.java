package project.avajlauncher;

import java.io.IOException;
import java.util.LinkedHashMap;
import project.avajlauncher.exceptions.FileFormattingException;
import project.avajlauncher.exceptions.AircraftException;

public class Simulation {

	Integer								loops = null;
	WeatherTower						tower = new WeatherTower();

	public Simulation (LinkedHashMap<Integer, String[]>	lines) 
		throws FileFormattingException, AircraftException, IOException
	{
		String[]	line = null;
		Integer		number = null;

		try {
			for (Integer key : lines.keySet()) {
				number = key;
				line = lines.get(key);
				if (line.length == 0) {
					continue ;
				}
				else if (loops == null) {
					loops = Integer.parseInt(line[0]);
					if (loops < 1) {
						throw new FileFormattingException(line, key);
					}
				}
				else {
					AircraftFactory.newAircraft(
						line[0], line[1], new Coordinates(
							Integer.parseInt(line[2]), 
							Integer.parseInt(line[3]), 
							Integer.parseInt(line[4]))).registerTower(tower);
				}
			}
			Logger.open("simulation.txt");
			tower.logRegistered();
			while (--loops > -1)
				tower.changeWeather();
			Logger.close();
		}
		catch (NumberFormatException e) {
			throw new FileFormattingException(line, number);
		}
	}
}
