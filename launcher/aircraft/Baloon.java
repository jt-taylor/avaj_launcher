package launcher.aircraft;

import launcher.aircraft.*;
import launcher.weather.*;
import launcher.*;

//inheret from aircraft with the flyable interface
public class Baloon extends Aircraft implements Flyable {
	private WeatherTower _wt;
	Baloon(String name, Coordinates coordinates) {
		//call the Aircraft constructor
		super(name, coordinates);
	}

	// i don't think that you have to place the @override for it
	// to work but it's better pracktice to have it
	// see https://docs.oracle.com/javase/tutorial/java/annotations/predefined.html
	@Override
	public void updateConditions() {
		String weather = _wt.getWeather(coordinates);
		switch (weather) {
				//not sure if i want write to stdout here or fall it somewher in the main class
			case "SUN" :
				coordinate = new Coordinates(coordinate.get_longitude() + 2, coordinate.get_latitude(), coordinate.get_height() + 4);
			case "RAIN":
				coordinate = new Coordinates(coordinate.get_longitude(), coordinate.get_latitude(), coordinate.get_height() - 5);
			case "FOG" :
				coordinate = new Coordinates(coordinate.get_longitude(), coordinate.get_latitude(), coordinate.get_height() - 3);
			case "SNOW" :
				coordinate = new Coordinates(coordinate.get_longitude(), coordinate.get_latitude(), coordinate.get_height() - 15);
		}
	}

	@Override
	public void registerTower(WeatherTower wt) {
		_wt = wt;
		_wt.register(this);
	}
}
