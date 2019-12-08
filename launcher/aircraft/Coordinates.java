package launcher.aircraft;

import launcher.*;

public class Coordinates {
	private		int longitude;
	private		int latitude;
	private		int height;

	Coordinates(int longitude, int latitude, int height) {
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = ((height < 0) ? 0 : (height > 100) ? 100 : height);
	}

	public int get_longitude() {
		return this.longitude;
	}
	public int get_latitude() {
		return this.latitude;
	}
	public int get_height() {
		return this.height;
	}
}
