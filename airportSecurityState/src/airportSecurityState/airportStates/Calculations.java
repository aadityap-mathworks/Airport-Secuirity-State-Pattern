package airportSecurityState.airportStates;
/**
 * @author Aaditya Sakharam Patil
 *
 */

import airportSecurityState.util.MyLogger;
public class Calculations implements AirportContextI {

	public int noOfLine;
	public int noOfDays;
	public int noOfProhibitedItems;
	public float avgTrafficPerDay;
    public float avgProhibitedItemsPerDay;
	
    /**
	 * Constructor
	 * sets noOfLine, noOfDays and noOfProhibitedItems to zero
	 */
	public Calculations() {
		MyLogger.writeMessage("Constructor of Calculations called ", MyLogger.DebugLevel.CONSTRUCTOR);
		this.noOfLine=0;
		this.noOfDays=0;
		this.noOfProhibitedItems=0;
	}
	
	
	/**
	 * to get AvgTrafficPerDay
	 */
	public float getAvgTrafficPerDay() {
		return avgTrafficPerDay;
	}

	/**
	 * to set AvgTrafficPerDay
	 */
	public void setAvgTrafficPerDay(float avgTrafficPerDay) {
		this.avgTrafficPerDay = avgTrafficPerDay;
	}

	/**
	 * to get avgProhibitedItemsPerDay
	 */
	public float getAvgProhibitedItemsPerDay() {
		return avgProhibitedItemsPerDay;
	}

	/**
	 * to set avgProhibitedItemsPerDay
	 */
	public void setAvgProhibitedItemsPerDay(float avgProhibitedItemsPerDay) {
		this.avgProhibitedItemsPerDay = avgProhibitedItemsPerDay;
	}

	/**
	 * to get number of passengers
	 */
	public int getNoOfLine() {
		return noOfLine;
	}

	/**
	 * to set number of passengers using lines form input file
	 */
	public void setNoOfLine(int noOfLine) {
		this.noOfLine = noOfLine;
	}

	/**
	 * to get number of days
	 */
	public int getNoOfDays() {
		return noOfDays;
	}

	/**
	 * to set number of days
	 */
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	/**
	 * to get number of prohibited items
	 */
	public int getNoOfProhibitedItems() {
		return noOfProhibitedItems;
	}

	/**
	 * to set number of prohibited items
	 */
	public void setNoOfProhibitedItems(int noOfProhibitedItems) {
		this.noOfProhibitedItems = noOfProhibitedItems;
	}

	/**
	 * method to get matrics values
	 * calculates averageTrafficPerDay and averageProhibitedItemsPerDay
	 * @param input file line
	 */
	@Override
	public void getMetrics(String line) {

		try 
		{
			String currentline =line;			
			setNoOfLine((getNoOfLine()+1));
			
			//splits line
			String part[] = currentline.split("[ :;]+");
			
			//setting number of days
			setNoOfDays(Integer.parseInt(part[1]));
			
			//check if passenger is traveling without any item
			if(!(part.length<4))
			{
				if(part[3].equals("Grains")||part[3].equals("NailCutters")||part[3].equals("Plants")
						||part[3].equals("EndangeredAnimals"))
				{
					setNoOfProhibitedItems((getNoOfProhibitedItems()+1));
					MyLogger.writeMessage("Prohibited item "+part[3]+" was found with passenger "+getNoOfLine()+"", MyLogger.DebugLevel.PROHIBITED_ITEMS);
					
				}
			}
			
			//calculate averageTrafficPerDay
			float averageTrafficPerDay = ((float)getNoOfLine() / getNoOfDays());
			setAvgTrafficPerDay(averageTrafficPerDay);
			
			//calculate averageProhibitedItemsPerDay
			float averageProhibitedItemsPerDay = ((float)getNoOfProhibitedItems() / getNoOfDays());
			setAvgProhibitedItemsPerDay(averageProhibitedItemsPerDay);
			
		} 
		
		catch (Exception e) {
			MyLogger.writeMessage("Exception occured while getting airport details \n"+e.toString(), MyLogger.DebugLevel.NONE);
			System.exit(1);
		}
		finally {
			
		}
		
	}

	
}
