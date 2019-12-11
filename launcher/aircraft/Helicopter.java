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
				Simulator.writ.println("Helicopter#" + name + "[ " + id + " ] says that it's Sunny");
				coordinate = new Coordinates(coordinate.get_longitude() + 10, coordinate.get_latitude(), coordinate.get_height() + 2);
				break;
			case "RAIN":
				Simulator.writ.println("Helicopter#" + name + "[ " + id + " ] says that it's Rainy");
				coordinate = new Coordinates(coordinate.get_longitude() + 5, coordinate.get_latitude(), coordinate.get_height());
				break;
			case "FOG" :
				Simulator.writ.println("Helicopter#" + name + "[ " + id + " ] says that it's Foggy");
				coordinate = new Coordinates(coordinate.get_longitude() + 1, coordinate.get_latitude(), coordinate.get_height());
				break;
			case "SNOW" :
				Simulator.writ.println("Helicopter#" + name + "[ " + id + " ] says that it's Snowy");
				coordinate = new Coordinates(coordinate.get_longitude(), coordinate.get_latitude(), coordinate.get_height() - 12);
				break;
		}
		if (coordinate.get_height() == 0)
		{
			Simulator.writ.println("Helicopter#" + name + "[ " + id + " ] has landed , unregistered from the tower\n\tLongitude(" + coordinate.get_longitude() + ")\tLatitude(" + coordinate.get_latitude() + ")");
			_wt.unregister(this);
		}
	}

	@Override
	public void registerTower(WeatherTower wt) {
		// print aircrft registered to tower
		Simulator.writ.println("Helicopter#" + name + "[ " + id + " ] registered to weatherTower");
		_wt = wt;
		_wt.register(this);
	}
}
