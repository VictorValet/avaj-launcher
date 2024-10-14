package project.avajlauncher;

import java.io.IOException;
import java.util.LinkedHashMap;
import project.avajlauncher.exceptions.FileFormattingException;

public class Simulation {

	Integer								loops = null;
	WeatherTower						tower = new WeatherTower();

	public Simulation (LinkedHashMap<Integer, String[]>	lines) 
		throws FileFormattingException, AircraftFactoryException, IOException
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
					Logger.open("simulation.txt");
				}
				else {
					AircraftFactory.newAircraft(
						line[0], line[1], new Coordinates(
							Integer.parseInt(line[2]), 
							Integer.parseInt(line[3]), 
							Integer.parseInt(line[4]))).registerTower(tower);
				}
			}
			while (--loops > -1)
				tower.changeWeather();
		}
		catch (NumberFormatException e) {
			throw new FileFormattingException(line, number);
		}
	}
}
