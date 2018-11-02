
package airportSecurityState.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Aaditya Sakharam Patil
 *
 */
public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	
	public static ArrayList<String> finalList = new ArrayList<String>();
	String outputFile;
	
	/**
	 * to get output file name
	 *@param filename
	 */
	public String getOutputFile() {
		return outputFile;
	}

	
	/**
	 * sets output file name
	 *@param filename
	 */
	public void setOutputFile(String outputFile) {
		this.outputFile = outputFile;
	}
 
	/**
	 * Constructor
	 *
	 */
	public Results()
	{
		
	}
	
	/**
	 * Constructor
	 * sets output file name
	 *@param filename
	 */
	public Results(String fileName)
	{
		setOutputFile(fileName);
	}

	/**
	 * method to store results
	 *
	 */
	public void finalResult(String res)
	{
		finalList.add(res);
	}
	
	/**
	 * method to write results to a file
	 *
	 */
	public void writeToFile() 
	{
		File out=null;
		FileWriter fw = null;
		
		try {
			 
			out= new File(outputFile);
			fw = new FileWriter(out);
			fw.write(finalList+"\n");
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				
				fw.close();
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
		}
		
	}
	
	/**
	 * method to display results on StdOut
	 *
	 */
	public void displayStdOut(String s) 
	{
		System.out.println(s+finalList);
	}
	
	/**
	 * method to clear results
	 *
	 */
	public void clearResult()
	{
		finalList.clear();
	}

	
	/**
	 * hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((outputFile == null) ? 0 : outputFile.hashCode());
		return result;
	}
	
	/**
	 * toString() method
	 */
	@Override
	public String toString() {
		return "Results [outputFile=" + outputFile + ", getOutputFile()=" + getOutputFile() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
