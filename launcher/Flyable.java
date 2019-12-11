package launcher;

import launcher.aircraft.*;
import launcher.weather.*;

//the "base class"
//this is the equivalent to a completely abstract class in c++
//classes that inheret/extend from interfaces either have to
//implement all of the member functions || be abstract
//you can only extend from one class but implement multiple interfaces
public interface Flyable {
	void		updateConditions();
	void		registerTower(WeatherTower wt);
}
