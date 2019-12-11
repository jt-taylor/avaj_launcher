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
		String weather = _wt.getWeather(coordinate);
		switch (weather) {
			//this is a a really bad way to do this because we allocate for a new
			//Coordinate object instead of just changing the actual values inside
			//of the instance
			//would be better to add set() for the values in the coordinate class
			case "SUN" :
				Simulator.writ.println("Baloon#" + name + "[ " + id + " ] says that it's Sunny");
				coordinate = new Coordinates(coordinate.get_longitude() + 2, coordinate.get_latitude(), coordinate.get_height() + 4);
				break;
			case "RAIN":
				coordinate = new Coordinates(coordinate.get_longitude(), coordinate.get_latitude(), coordinate.get_height() - 5);
				Simulator.writ.println("Baloon#" + name + "[ " + id + " ] says that it's Rainy");
				break;
			case "FOG" :
				coordinate = new Coordinates(coordinate.get_longitude(), coordinate.get_latitude(), coordinate.get_height() - 3);
				Simulator.writ.println("Baloon#" + name + "[ " + id + " ] says that it's Foggy");
				break;
			case "SNOW" :
				coordinate = new Coordinates(coordinate.get_longitude(), coordinate.get_latitude(), coordinate.get_height() - 15);
				Simulator.writ.println("Baloon#" + name + "[ " + id + " ] says that it's Snowy");
				break;
		}
		if (coordinate.get_height() == 0)
		{
			//print something about unregister aircraft
			//height of 0 is the ground
			Simulator.writ.println("Baloon#" + name + "[ " + id + " ] has landed , unregistered from the tower\n\tLongitude(" + coordinate.get_longitude() + ")\tLatitude(" + coordinate.get_latitude() + ")");
			_wt.unregister(this);
		}
	}

	@Override
	public void registerTower(WeatherTower wt) {
		// print aircrft registered to tower
		Simulator.writ.println("Baloon#" + name + "[ " + id + " ] registered to weatherTower");
		_wt = wt;
		_wt.register(this);
	}
}
