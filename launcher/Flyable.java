package launcher;

import launcher.aircraft.java;
import launcher.weather.java;

public interface Flyable {
	void		updateConditions();
	void		registerTower(WeatherTower wt);
}
