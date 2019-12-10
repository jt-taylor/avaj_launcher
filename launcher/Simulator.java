package launcher;

import launcher.weather.*;
import launcher.aircraft.*;
import launcher.*;

import java.io.*;
import java.util.*;

public class Simulator {
			//performs formatted representations of objects to text output stream
			public static PrintWriter writ;
			private static Stack<Flyable> s;
	public static void		main(String[] argv)
	{
		//with java 7 we can either use BufferedReader or Scanner for
		//reading text files
		//buffered reader is buffered for fast reading but
		//Scanner has parsing with regex
		if (argv.length < 1) {
			System.err.println("Please provide a file");
			System.exit(1); }
		try {
			File file = new File(argv[1]);
			Scanner sc = new Scanner(file);

		} catch (Exception e) {// all exceptions in java are derived from the base class so this is like catch (...) in c++
			//
		} finally {
			//;
		}
	}
}
