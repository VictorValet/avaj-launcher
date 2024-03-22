package project.avajlauncher;

public class JetPlane extends Aircraft {

	public JetPlane(long p_id, String p_name, Coordinates p_coordinate) {
		super(p_id, p_name, p_coordinate);
		id_str = "JetPlane" + '#' + name + "(" + id + ")";
		moves[FOG] = new Coordinates(0, 1, 0);
		moves[RAIN] = new Coordinates(0, 5, 0);
		moves[SNOW] = new Coordinates(0, 0, -7);
		moves[SUN] = new Coordinates(0, 10, 2);
		messages[FOG] = "The Mist";
		messages[RAIN] = "Rainman";
		messages[SNOW] = "The Snowpiercer";
		messages[SUN] = "Sunshine";
	}
}
