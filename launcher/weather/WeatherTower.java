package launcher.weather;

import launcher.*;
import launcher.aircraft.*;
import launcher.weather.*;
import java.util.*;

public class WeatherTower extends Tower {
	public String		getWeather(Coordinates coord) {
		//get the weather at the givin xyz cord
		return WeatherProvider.getProvider().getCurrentWeather(coord);
	}
	public void changeWeather() {
		//calls this from the tower class
		conditionsChanged();
	}
}
