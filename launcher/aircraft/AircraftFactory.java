package launcher.aircraft;

import launcher.aircraft.*;
import launcher.*;
import java.io.*;

//todo Flyable class and (?) Coordinates
public class AircraftFactory {
	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int altitude) {
		Coordinates coordinates = new Coordinates (longitude, latitude, altitude);
		String tmp = type.toLowerCase();
		//probably a better way to do this
		if (tmp.equals("baloon"))
			return new Baloon(name, coordinates);
		else if (tmp.equals("Helicopter"))
			return new Helicopter(name, coordinates);
		else if (tmp.equals("JetPlane"))
			return new JetPlane(name, coordinates);
		else
			// maybe not the right exception to throw here ?
			// not really sure , people seem to be really picky with the runtime exceptions
			// or maybe just return null i guess
			throw new IllegalArgumentException("AirCraft Type not Found");
		return null;
	}
}
