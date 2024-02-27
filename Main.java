public class Main 
{
	public static void main(String[] args) 
	{
		Helicopter helico = new Helicopter(0, "H1", new Coordinates(15, 15, 1));
		Balloon balloon = new Balloon(1, "H2", new Coordinates(20, 20, 15));
		JetPlane jetplane = new JetPlane(2, "H3", new Coordinates(10, 10, 20));
		WeatherTower tower = new WeatherTower();
		helico.registerTower(tower);
		balloon.registerTower(tower);
		jetplane.registerTower(tower);
		tower.changeWeather();
	}
}
