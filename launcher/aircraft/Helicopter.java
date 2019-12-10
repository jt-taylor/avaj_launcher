package launcher.aircraft;

import launcher.aircraft.*;
import launcher.weather.*;
import launcher.*;

public class Helicopter extends Aircraft implements Flyable {
	private WeatherTower _wt;
	Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	@Override
	public void updateConditions() {
		String weather = _wt.getWeather(coordinate);
		switch (weather) {
			case "SUN" :
				coordinate = new Coordinates(coordinate.get_longitude() + 10, coordinate.get_latitude(), coordinate.get_height() + 2);
			case "RAIN":
				coordinate = new Coordinates(coordinate.get_longitude() + 5, coordinate.get_latitude(), coordinate.get_height());
			case "FOG" :
				coordinate = new Coordinates(coordinate.get_longitude() + 1, coordinate.get_latitude(), coordinate.get_height());
			case "SNOW" :
				coordinate = new Coordinates(coordinate.get_longitude(), coordinate.get_latitude(), coordinate.get_height() - 12);
		}
	}

	@Override
	public void registerTower(WeatherTower wt) {
		_wt = wt;
		_wt.register(this);
	}
}
