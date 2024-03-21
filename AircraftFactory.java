package java.project.avajlauncher;

public final class AircraftFactory{
	
	private static final AircraftFactory instance = new AircraftFactory();

	private AircraftFactory(){}
	
	public static Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) throws AircraftFactoryException
	{
		if (Aircraft.getTotal() == 100)
			throw new AircraftFactoryException("Too many aircrafts");
		switch (p_type.toUpperCase()){
			case "BALOON":
				return (new Baloon(Aircraft.getTotal(), p_name, p_coordinates));
			case "HELICOPTER":
				return (new Helicopter(Aircraft.getTotal(), p_name, p_coordinates));
			case "JETPLANE":
				return (new JetPlane(Aircraft.getTotal(), p_name, p_coordinates));
			default:
				throw new AircraftFactoryException("Unknown aircraft");
		}
	}
}
