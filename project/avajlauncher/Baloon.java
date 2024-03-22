package project.avajlauncher;

public class Baloon extends Aircraft {

	public Baloon(long p_id, String p_name, Coordinates p_coordinate) {
		super(p_id, p_name, p_coordinate);
		id_str = "Baloon" + '#' + name + "(" + id + ")";
		moves[FOG] = new Coordinates(0, 0, -3);
		moves[RAIN] = new Coordinates(0, 0, -5);
		moves[SNOW] = new Coordinates(0, 0, -15);
		moves[SUN] = new Coordinates(2, 0, 4);
		messages[FOG] = "There's a fog upon L.A.";
		messages[RAIN] = "If the rain comes, they run and hide their heads.";
		messages[SNOW] = "Let it snow, let it snow, let it snow.";
		messages[SUN] = "Here comes the sun king!";
	}
}
