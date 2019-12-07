package launcher.aircraft;

import avaj.aircraft.*;
import java.io.*;

//todo Flyable class and (?) Coordinates
public class AircraftFactory {
	//todo 
	// Flyable
	public satic Flyable newAircraft(String type, String name, int longitude, int latitude, int altitude) {
		Coordinates coordinates = new Coordinates (longiture, latitude, altitude);
		String tmp = type.toLowerCase();
		if (tmp.equals("baloon"))
			return new Baloon(name, coordinates)
	}
}
