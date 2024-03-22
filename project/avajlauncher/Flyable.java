package project.avajlauncher;

import java.io.IOException;

abstract class Flyable {

	protected WeatherTower weatherTower;

	public abstract void updateConditions() throws IOException;

	public void registerTower(WeatherTower p_tower) throws IOException {
		weatherTower = p_tower;
		weatherTower.register(this);
	}
}
