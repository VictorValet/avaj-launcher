package project.avajlauncher.exceptions;

public class AircraftException extends Exception {
	
	String s;
	
	public AircraftException(String p_s) {
		s = p_s;
	}

	public String toString() {
		return s;
	}
}
