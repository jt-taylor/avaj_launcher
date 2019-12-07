package launcher.aircraft;

import launcher.aircraft.*;

/* this is the base class that the other inherit from */

class Aircraft {
	protected		long		id;
	protected		string		name;
	protected		Coordinates	coordinate;
	private static	double		id_counter = 0; // nothing fancy just inc by 1

	protected Aircraft(String name, Coordinates coordinates) {
		this.coordinate = coordinates;
		this.name = name;
		this.id_counter = ++this.id_counter;
	}
	// the uml wants a nextId() function
	public void		nextId() {
		this.id_counter += 1;
	}
}
