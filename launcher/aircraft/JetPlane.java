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
				Simulator.writ.println("JetPlane#" + name + "[ " + id + " ] says that it's Sunny");
				coordinate = new Coordinates(coordinate.get_longitude(), coordinate.get_latitude() + 10, coordinate.get_height() + 2);
				break;
			case "RAIN":
				Simulator.writ.println("JetPlane#" + name + "[ " + id + " ] says that it's Rainy");
				coordinate = new Coordinates(coordinate.get_longitude(), coordinate.get_latitude() + 5, coordinate.get_height());
				break;
			case "FOG" :
				Simulator.writ.println("JetPlane#" + name + "[ " + id + " ] says that it's Foggy");
				coordinate = new Coordinates(coordinate.get_longitude(), coordinate.get_latitude() - 1, coordinate.get_height() - 7);
				break;
			case "SNOW" :
				Simulator.writ.println("JetPlane#" + name + "[ " + id + " ] says that it's Snowy");
				coordinate = new Coordinates(coordinate.get_longitude(), coordinate.get_latitude(), coordinate.get_height() - 7);
				break;
		}
		if (coordinate.get_height() == 0)
		{
			//print something about unregister aircraft
			//height of 0 is the ground
			Simulator.writ.println("JetPlane#" + name + "[ " + id + " ] has landed , unregistered from the tower\n\tLongitude(" + coordinate.get_longitude() + ")\tLatitude(" + coordinate.get_latitude() + ")");
			_wt.unregister(this);
		}
	}

	@Override
	public void registerTower(WeatherTower wt) {
		Simulator.writ.println("JetPlane#" + name + "[ " + id + " ] registered to weatherTower");
		_wt = wt;
		_wt.register(this);
	}
}
