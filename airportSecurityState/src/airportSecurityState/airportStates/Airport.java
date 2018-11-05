package airportSecurityState.airportStates;
/**
 * @author Aaditya Sakharam Patil
 *
 */
import airportSecurityState.util.FileProcessor;
import airportSecurityState.util.MyLogger;
import airportSecurityState.util.Results;

public class Airport implements AirportContextI{

	private AirportStateI high;
	private AirportStateI moderate;
	private AirportStateI low;
	private AirportStateI currentState;
	private FileProcessor fp;
	private Results res;
	private int noOfLine;
	private int noOfDays;
	private int noOfProhibitedItems;
	private float avgTrafficPerDay;
	private float avgProhibitedItemsPerDay;
	
   
	/**
	 * to get HighRisk state
	 */
	public AirportStateI getHigh() {
		return high;
	}

	/**
	 * sets AirportStateI high
	 * @param AirportStateI highIn
	 */
	public void setHigh(AirportStateI highIn) {
		this.high = highIn;
	}

	/**
	 * to get ModerateRisk state
	 */
	public AirportStateI getModerate() {
		return moderate;
	}

	/**
	 * sets AirportStateI moderate
	 * @param AirportStateI moderateIn
	 */
	public void setModerate(AirportStateI moderateIn) {
		this.moderate = moderateIn;
	}

	/**
	 * to get LowRisk state
	 */
	public AirportStateI getLow() {
		return low;
	}

	/**
	 * sets AirportStateI low
	 * @param AirportStateI lowIn
	 */
	public void setLow(AirportStateI lowIn) {
		this.low = lowIn;
	}

	/**
	 * to get current state
	 */
	public AirportStateI getCurrentState() {
		return currentState;
	}

	/**
	 * sets current state
	 * @param AirportStateI currentStateIn
	 */
	public void setState(AirportStateI currentStateIn) {
		this.currentState = currentStateIn;
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
	 * Constructor
	 * sets FileProcessor, Results instances
	 * Sets states
	 * sets number of Days, Passengers and Prohibited items to zero
	 * Creates instance of Calculations
	 * @param insatnces of FileProcessor, Results classes
	 */
	public Airport(FileProcessor fpIn, Results resIn) {
		
		MyLogger.writeMessage("Constructor of Airport called ", MyLogger.DebugLevel.CONSTRUCTOR);
		this.fp=fpIn;
		this.res= resIn;
		this.noOfLine=0;
		this.noOfDays=0;
		this.noOfProhibitedItems=0;
		low = new LowRisk(this,res);
		moderate = new ModerateRisk(this,res);
		high = new HighRisk(this,res);
		currentState=low;
		
		
	}
	
	/**
	 * call the method to increase or decrease security state
	 * reads line form input file
	 */
	public void start()
	{
		try {
			
			String currentline;
			while ((currentline = fp.readInputLine()) != null) 
			{
				
				currentState.increaseOrDecreaseSecurity(currentline);
			}
		}
		catch(Exception e) {
			MyLogger.writeMessage("Exception occured in start method of Manager class \n"+e.toString(), MyLogger.DebugLevel.NONE);
			System.exit(1);
		}
		finally
		{
			try {
				
				fp.close();
			}
			catch(Exception e)
			{
				MyLogger.writeMessage("Exception occured while closing FileProcessor object in Manager class \n"+e.toString(), MyLogger.DebugLevel.NONE);
				System.exit(1);
			}
		}
		
		
	}	

	/**
	 * method to get metrics values
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
			if(part.length<4)
			{
				MyLogger.writeMessage("invalid input File", MyLogger.DebugLevel.NONE);
				System.exit(1);
			}
			if(part[3].equals("Grains")||part[3].equals("NailCutters")||part[3].equals("Plants")
					||part[3].equals("EndangeredAnimals"))
			{
				setNoOfProhibitedItems((getNoOfProhibitedItems()+1));
				MyLogger.writeMessage("Prohibited item "+part[3]+" was found with passenger "+getNoOfLine()+"", MyLogger.DebugLevel.PROHIBITED_ITEMS);
				
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
