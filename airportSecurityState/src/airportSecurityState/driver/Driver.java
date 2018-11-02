package airportSecurityState.driver;

import java.io.File;

/**
 * @author Aaditya Sakharam Patil
 *
 */
public class Driver {
	/**
	 * Main method
	 * @param Commandline arguments
	 * @return none
	 */
	public static void main(String[] args) {
		try {
			
			/**
			 * As the build.xml specifies the arguments as argX, in case the
			 * argument value is not given java takes the default value specified in
			 * build.xml. To avoid that, below condition is used
			 */
			if (args.length != 3 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}") || args[3].equals("${arg3}") || args[4].equals("${arg4}" )) 
			{
				System.err.println("Error: Incorrect number of arguments. Program accepts 5 argumnets.");
				System.exit(1);
			}
			
			/**
			 *argument validation
			 *check if file exists
			 *check if input and delete files are empty
			 */
			File file1 = new File(args[0]);
			if (!file1.exists()) 
			{
				System.out.println("Input file does not exist.");
				System.exit(1);
			}
			else if(file1.length() == 0)
			{
				System.out.println("input file is empty.");
				System.exit(1);
			}
			
			
			/**
			 *Storing command line arguments
			 */
			String inputFile=args[0];
			String outputFile = args[1];
			int output1 = Integer.parseInt(args[2]);
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		finally {
			
		}
	
	}

	@Override
	public String toString() {
		return "Driver [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
