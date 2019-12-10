package launcher.aircraft;

import launcher.aircraft.*;
import launcher.weather.*;
import launcher.*;

//inheret from aircraft with the flyable interface
public class JetPlane extends Aircraft implements Flyable {
	private WeatherTower _wt;
	JetPlane(String name, Coordinates coordinates) {
		//call the Aircraft constructor
		super(name, coordinates);
	}

	// i don't think that you have to place the @override for it
	// to work but it's better pracktice to have it
	// see https://docs.oracle.com/javase/tutorial/java/annotations/predefined.html
	@Override
	public void updateConditions() {
		String weather = _wt.getWeather(coordinate);
		switch (weather) {
				//not sure if i want write to stdout here or fall it somewher in the main class
			case "SUN" :
				coordinate = new Coordinates(coordinate.get_longitude(), coordinate.get_latitude() + 10, coordinate.get_height() + 2);
			case "RAIN":
				coordinate = new Coordinates(coordinate.get_longitude(), coordinate.get_latitude() + 5, coordinate.get_height());
			case "FOG" :
				coordinate = new Coordinates(coordinate.get_longitude(), coordinate.get_latitude() - 1, coordinate.get_height() - 7);
			case "SNOW" :
				coordinate = new Coordinates(coordinate.get_longitude(), coordinate.get_latitude(), coordinate.get_height() - 7);
		}
	}

	@Override
	public void registerTower(WeatherTower wt) {
		_wt = wt;
		_wt.register(this);
	}
}
