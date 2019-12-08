package launcher;

import launcher.aircraft.*;
import launcher.weather.*;

public interface Flyable {
	void		updateConditions();
	void		registerTower(WeatherTower wt);
}
