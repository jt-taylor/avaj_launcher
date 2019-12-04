// because this project is supposed teach me java im going to to use
// this file as a note dump , i don't really take notes on everything so a
// lot of this is going to be specific unique things that i think
// im going to have to google again
// -----------------------------------------------------------------------------

/*
General notes ------------------------------------------------------------------
	everything is classes >?
	java runs on a vm so you compile with the java compiler then the bytecode
		actually runs on the vm , this reduces dependecy issues and (many)others
	you compile with the terminal command javac -- which makes the bytecode files
	then you run it with `java filename_to_execute`

// Try and exceptions ----------------------------------------------------------
	in the try catch block there is finally which always runs wether an exception
		was thrown or not
	you can try with resources ,
		a resource is an object that is closed at the end of the block
		this object must implement the java.lang.AutoClosable
			all objects that implement the java.lang.Closable are valid for this
		example from the oracle java tutorial

		static String readFirstLineFromFile(String path) throws IOException {
			try (BufferedReader br =
							new BufferedReader(new FileReader(path))) {
				return br.readLine();
			}
		}
	exceptions are thrown with the same syntax as c++
		ie		throw new objectConstructor();
	most exceptions thrown are derived from the exception class
 -------------------------------------------------------------------------------
*/
class HelloWorld
{
	//main
	//doesn't like main(void)
	public static void main(String argv[]) {
		//prints with a newline
		System.out.println("Hello World");
	}
}
