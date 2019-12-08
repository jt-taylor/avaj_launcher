package launcher.weather;

import launcher.*;

public class WeatherProvider {
	private static WeatherProvider weatherProvider = new WeatherProvider();
	//final means that the variable will only be assigned once
	private static final String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

	//not sure what the uml wants here
	private WeatherProvider() {
	}

	public static WeatherProvider getProvider() {
		return weatherProvider;
	}

	// the weather is just the xyz values added together and mod aginst the weather array
	// this means that the weather is always going to be set for the given space
	// but its fast
	public String	getCurrentWeather(Coordinates coordinates) {
		return weather[(coordinates.get_height() + coordinates.get_latitude() + coordinates.get_longitude()) % 4];
	}
}
