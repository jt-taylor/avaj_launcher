package launcher.aircraft;

import launcher.aircraft.*;

/* this is the base class that the other inherit from */

class Aircraft {
	protected		long		id;
	protected		String		name;
	protected		Coordinates	coordinate;
	//this is private so that when a new aircraft is made the 'new' aircraft does
	//not update the id of 'this' instance
	private static long		id_counter = 0; // nothing fancy just inc by 1

	protected Aircraft(String name, Coordinates coordinates) {
		this.coordinate = coordinates;
		this.name = name;
		this.id_counter = nextId();
		this.id = id_counter;
	}
	// the uml wants a nextId() function
	public long		nextId() {
		return (id_counter + 1);
	}
}
