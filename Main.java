public class Main 
{
	public static void main(String[] args) 
	{
		WeatherTower tower = new WeatherTower();

		//first loop creating
		try {
			for (int i = 0; i < 100; i++)
				AircraftFactory.newAircraft("Helicopter", "H" + i, new Coordinates(i * 5, 50 - (i * 5), i * 5)).registerTower(tower);
		}
		catch (AircraftFactoryException e){
			System.out.println("Error: " + e.s);
			return ;
		}

		//third loop evoluating
	}
}
