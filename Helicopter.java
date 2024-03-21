package java.project.avajlauncher;

public class Helicopter extends Aircraft{

	public Helicopter(long p_id, String p_name, Coordinates p_coordinate){
		super(p_id, p_name, p_coordinate);
		id_str = "Helicopter" + '#' + name + "(" + id + ")";
		moves[FOG] = new Coordinates(1, 0, 0);
		moves[RAIN] = new Coordinates(5, 0, 0);
		moves[SNOW] = new Coordinates(0, 0, -12);
		moves[SUN] = new Coordinates(10, 0, 2);
		messages[FOG] = "The fog is thick as peanut butter.";
		messages[RAIN] = "Destroy all intruders with rain! Acid rain!";
		messages[SNOW] = "Nothing like fresh powder.";
		messages[SUN] = "Good day, sunshine!";
	}
}
