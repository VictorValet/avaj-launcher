package java.project.avajlauncher;

import java.util.HashSet;

public class Aircraft extends Flyable{

	private static int			total = 0;
	protected static final int	FOG = 0, RAIN = 1, SNOW = 2, SUN = 3;
	protected long				id;
	protected String			name;
	protected Coordinates		coordinates;
	protected String			id_str = "";
	protected String			messages[] = new String[4];
	protected Coordinates		moves[] = new Coordinates[4];

	protected Aircraft(long p_id, String p_name, Coordinates p_coordinate){
		total++;
		id = p_id;//check if it is already in use
		name = p_name;
		coordinates = p_coordinate;
	}

	public void updateConditions(){
		Coordinates p_coord = moves[weatherToInt()];
		coordinates = new Coordinates(
			coordinates.getLongitude() + p_coord.getLongitude(),
			coordinates.getLatitude() + p_coord.getLatitude(),
			coordinates.getHeight() + p_coord.getHeight());
		if (coordinates.getHeight() > 0)
			System.out.println(id_str 
			+ ": " + messages[weatherToInt()]
			+ " (at: " + coordinates.getLongitude() + ", " + coordinates.getLatitude() + ", " + coordinates.getHeight() + ")");
		else
		{
			System.out.println(id_str + "landing");
			weatherTower.unregister(this);
		}
	}

	private int weatherToInt(){
		switch (weatherTower.getWeather(coordinates)){
			case "FOG":
				return (FOG);
			case "RAIN":
				return (RAIN);
			case "SNOW":
				return (SNOW);
			case "SUN":
				return (SUN);
			default:
				return (0);
		}
	}

	public String toString(){
		return (id_str);
	}

	public static int getTotal(){
		return (total);
	}
}
