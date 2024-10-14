package project.avajlauncher;

import java.util.Random;
import java.util.Scanner;

public final class WeatherProvider {
	
	private static final WeatherProvider	instance = new WeatherProvider();
	private static final String[]			weather = {"FOG", "RAIN", "SNOW", "SUN"};
	private static final int[] 				seed = createSeed();
	private static final byte[] 			list = createList();

	private WeatherProvider() {}
	
	private static byte[] createList() {
		Random	random = new Random();
		byte[]	n_list = new byte[101];
		for (int i = 0; i < 101; i++)
			n_list[i] = (byte)random.nextInt(4);
		return (n_list);
	}

	private static int[] createSeed() {
		Random	random = new Random();
		int[]	n_seed = new int[3];
		for (int i = 0; i < 3; i++)
			n_seed[i] = random.nextInt(1000);
		return (n_seed);
	}

	public static String getCurrentWeather(Coordinates p_coordinates) {
		int random =
			((p_coordinates.getLongitude() * seed[0]) 
			+ (p_coordinates.getLatitude() * seed[1]) 
			+ (p_coordinates.getHeight() * seed[2]));
		if (random < 0)
			random = -(random + 1);
		random %= 101;
		return (weather[list[random]]);
	}
}
