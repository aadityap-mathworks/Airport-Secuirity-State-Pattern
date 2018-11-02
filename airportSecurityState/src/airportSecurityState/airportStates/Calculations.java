package airportSecurityState.airportStates;

import airportSecurityState.util.FileProcessor;
import airportSecurityState.util.MyLogger;
public class Calculations implements AirportContextI {

	public int noOfLine=0;
	public int noOfDays=0;
	public int noOfProhibitedItems=0;
	float averageTrafficPerDay;
    float averageProhibitedItemsPerDay;

	FileProcessor fp =null;
	public Calculations(FileProcessor fpIn) {
		this.fp = fpIn;
	}
	
	public Calculations() {
		// TODO Auto-generated constructor stub
	}

	public int getNoOfLine() {
		return noOfLine;
	}

	public void setNoOfLine(int noOfLine) {
		this.noOfLine = noOfLine;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public int getNoOfProhibitedItems() {
		return noOfProhibitedItems;
	}

	public void setNoOfProhibitedItems(int noOfProhibitedItems) {
		this.noOfProhibitedItems = noOfProhibitedItems;
	}

	@Override
	public void getMetrics(String line) {

		try 
		{
			String currentline =line;			
				
			setNoOfLine((getNoOfLine()+1));
			String part[] = currentline.split("[ :;]+");
			setNoOfDays(Integer.parseInt(part[1]));
			if(part[3].equals("Grains")||part[3].equals("NailCutters")||part[3].equals("Plants")
					||part[3].equals("EndangeredAnimals"))
			{
				setNoOfProhibitedItems((getNoOfProhibitedItems()+1));
				
			}

			this.averageTrafficPerDay = ((float)getNoOfLine() / getNoOfDays());
			this.averageProhibitedItemsPerDay = ((float)getNoOfProhibitedItems() / getNoOfDays());
			
			//System.out.println(averageTrafficPerDay);
			//System.out.println(averageProhibitedItemsPerDay);
			//System.out.println("items"+getNoOfProhibitedItems());
		} 
		
		catch (Exception e) {
			MyLogger.writeMessage("Exception occured while getting airport details \n"+e.toString(), MyLogger.DebugLevel.NONE);
			System.exit(1);
		}
		finally {
			
		}
		
	}

	
}
