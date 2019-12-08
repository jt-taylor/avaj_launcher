package launcher.weather;

import launcher.*;
import java.io.*;
import java.util.*;


public class Tower {
	//is this how this is supposed to work >?
	//still not confident that i really understand the whole observer thingy
	//think that I am over complicating it
	private Stack<Flyable> observers = new Stack<>();

	//add a unique entrie to the stack
	public void		register(Flyable fly) {
		if (!observers.contains(fly))
			observers.add(fly);
	}
	//remove from the stac
	public void unregister(Flyable fly) {
		observers.remove(fly);
	}

	//when updated update all the entries in the stack
	protected void conditionsChanged() {
		for (int i = 0;i < observers.size();i++)
			observers.get(i).updateConditions();
	}
}
