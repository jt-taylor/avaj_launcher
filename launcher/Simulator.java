package launcher;

import launcher.weather.*;
import launcher.aircraft.*;
import launcher.*;

import java.io.*;
import java.util.*;

public class Simulator {
			//performs formatted representations of objects to text output stream
			public static PrintWriter writ;
			//our weather tower
			//aircraft container
			private static Stack<Flyable> flyables_container;
	public static void		main(String[] argv)
	{
			WeatherTower wt = new WeatherTower();
		if (argv.length < 1) {
			System.err.println("Please provide a file");
			System.exit(1); }
		try {
			//with java 7 we can either use BufferedReader or Scanner for
			//reading text files
			//buffered reader is buffered for fast reading but
			//Scanner has parsing with regex
			File file = new File(argv[1]);
			//not sure why all the examples reconstruct the FileReader obj
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st;
			int		total_simulations;
			if ((st = br.readLine()) != null)
				total_simulations = Integer.parseInt(st);
			else if (total_simulations < 0)
			{
				//these really should be exceptions
				System.out.println("Error reading simulation count");
				System.exit(1);
			}
			else
			{
				System.out.println("Error reading simulation count");
				System.exit(1);
			}
			while ((st = br.readLine()) != null)
			{
				//so there is a legacy stringTokenizer but it's recomended to
				//instead use the split method of string or
				//java.utils.regex package
				String tmp[] = st.split(" ");
				//make and add the aircrafts for each input line
				Flyable fly = AircraftFactory.newAircraft(tmp[0],
						tmp[1], Integer.parseInt(tmp[2]),
						Integer.parseInt(tmp[3]), Integer.parseInt(tmp[4]));
				if (fly == null)
				{
					System.out.println("Error creating aircraft obj");
					System.exit(1);
				}
				flyables_container.add(fly);
			}
			//for each to register to the weather tower
			for (Flyable fly : flyables_container) {
				flyables_container.registerTower(wt);
			}
			for (int i = 0;i < total_simulations;i++) {
				wt.changeWeather();
			}
		} catch (Exception e) {// all exceptions in java are derived from the base class so this is like catch (...) in c++
			//
		} finally {
			//close the file
			if (writ != null)
				writ.close();
		}
	}
}
