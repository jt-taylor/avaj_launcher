package launcher.weather;

import launcher.*;
import java.util.*;

public class WeatherTower extends Tower {
	public String		getWeather(Coordinates coord) {
		//get the weather at the givin xyz cord
		return WeatherProvider.getProvider().getCurrentWeather(coord);
	}
	void changeWeather() {
		//calls this from the tower class
		conditionsChanged();
	}
}