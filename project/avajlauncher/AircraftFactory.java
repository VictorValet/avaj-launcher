package project.avajlauncher;

import project.avajlauncher.exceptions.AircraftException;

public final class AircraftFactory {
	
	private static final AircraftFactory instance = new AircraftFactory();

	private AircraftFactory() {}
	
	public static Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) throws AircraftException
	{
		if (Aircraft.getTotal() == 100)
			throw new AircraftException("Too many aircrafts");
		switch (p_type.toUpperCase()) {
			case "BALOON":
				return (new Baloon(Aircraft.getTotal(), p_name, p_coordinates));
			case "HELICOPTER":
				return (new Helicopter(Aircraft.getTotal(), p_name, p_coordinates));
			case "JETPLANE":
				return (new JetPlane(Aircraft.getTotal(), p_name, p_coordinates));
			default:
				throw new AircraftException("Unknown aircraft type: " + p_type);
		}
	}
}
