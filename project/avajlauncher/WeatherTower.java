package project.avajlauncher;

import java.io.IOException;

public class WeatherTower extends Tower {

	public String getWeather(Coordinates p_coordinates) {
		return (WeatherProvider.getCurrentWeather(p_coordinates));
	}

	public void changeWeather() throws IOException {
		conditionChanged();
	}
}
