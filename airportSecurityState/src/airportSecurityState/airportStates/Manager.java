package airportSecurityState.airportStates;
/**
 * @author Aaditya Sakharam Patil
 *
 */
import airportSecurityState.util.FileProcessor;
import airportSecurityState.util.MyLogger;
import airportSecurityState.util.Results;

public class Manager {

	private AirportStateI high;
	private AirportStateI moderate;
	private AirportStateI low;
	private AirportStateI currentState;
	private FileProcessor fp;
	private Results res;
	private Calculations cal;
   
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
	public void setCurrentState(AirportStateI currentStateIn) {
		this.currentState = currentStateIn;
	}
	
	/**
	 * Constructor
	 * sets FileProcessor, Results instances
	 * Sets states
	 * Creates instance of Calculations
	 * @param insatnces of FileProcessor, Results calsses
	 */
	public Manager(FileProcessor fpIn, Results resIn) {
		
		MyLogger.writeMessage("Constructor of Manager called ", MyLogger.DebugLevel.CONSTRUCTOR);
		this.fp=fpIn;
		this.res= resIn;
		cal= new Calculations();
		low = new LowRisk(this,res,cal);
		moderate = new ModerateRisk(this,res,cal);
		high = new HighRisk(this,res,cal);
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


	

}
