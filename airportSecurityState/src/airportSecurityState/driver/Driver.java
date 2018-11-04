package airportSecurityState.driver;

import java.io.File;

import airportSecurityState.airportStates.Airport;
import airportSecurityState.util.FileProcessor;
import airportSecurityState.util.MyLogger;
import airportSecurityState.util.Results;

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
			if (args.length != 3 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")) 
			{
				System.err.println("Error: Incorrect number of arguments. Program accepts 3 argumnets.");
				System.exit(1);
			}
			
			/**
			 *argument validation
			 *check if input file exists
			 *check if input is empty
			 */
			File file1 = new File(args[0]);
			if (!file1.exists()) 
			{
				System.err.println("Input file does not exist.");
				System.exit(1);
			}
			else if(file1.length() == 0)
			{
				System.err.println("input file is empty.");
				System.exit(1);
			}
			
			/**
			 *argument validation
			 *check if output file exists
			 *check if file is empty
			 */
			File file2 = new File(args[1]);
			if (file2.exists()) 
			{
				if(file2.length() != 0)
				{
					System.err.println("output file is not empty.");
					System.exit(1);
				}
			}		
			
			
			/**
			 *Storing command line arguments
			 */
			String inputFile=args[0];
			String outputFile = args[1];
			int debugLevel = Integer.parseInt(args[2]);
			
			/**
			 * Setting debug value
			 */
			MyLogger.setDebugValue(debugLevel);
			
			/**
			 * Creating instances of FileProcessor, Results
			 */
			FileProcessor fp= new FileProcessor(inputFile);
			Results res = new Results(outputFile);
			
			/**
			 * Creating instances of Airport
			 * @param instances of FileProcessor, Results
			 */
			Airport ap= new Airport(fp,res);
			
			/**
			 * Calling start method of Airport
			 */
			ap.start();
			
			/**
			 * Calling methods of Results class to write output
			 */
			res.displayStdOut("Output");
			res.writeToFile();
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

