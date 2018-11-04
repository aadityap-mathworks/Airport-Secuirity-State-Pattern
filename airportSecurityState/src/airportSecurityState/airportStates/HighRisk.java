package airportSecurityState.airportStates;
/**
 * @author Aaditya Sakharam Patil
 *
 */
import airportSecurityState.util.MyLogger;
import airportSecurityState.util.Results;

public class HighRisk implements AirportStateI {

	private Airport currentState;
	private Results res;
	private float averageProhibitedItemsPerDay;
	private float averageTrafficPerDay;
		
		
	/**
	 * Constructor
	 * sets Airport, Results instances
	 * @param insatnces of Airport, Results classes
	 */
	public HighRisk(Airport currentStateIn, Results resIn) {
		MyLogger.writeMessage("Constructor of HighRisk called ", MyLogger.DebugLevel.CONSTRUCTOR);
		this.res= resIn;
		this.currentState = currentStateIn;
		
	}

	/**
	 * Method to change Security states 
	 * checks the metrics values and increases or decreases security state
	 * @param Line from input file
	 *
	 */
	@Override
	public void increaseOrDecreaseSecurity(String currentline) 
	{
		try {
			currentState.getMetrics(currentline);	
			averageTrafficPerDay= currentState.getAvgTrafficPerDay();
			averageProhibitedItemsPerDay= currentState.getAvgProhibitedItemsPerDay();
			
			if((averageTrafficPerDay>=8) || (averageProhibitedItemsPerDay>=4))
			{ 
				currentState.setState(currentState.getHigh());
				res.addToFinalResult(opIdHigh);
			}
			else 
			{
				currentState.setState(currentState.getModerate());
				res.addToFinalResult(opIdMod);
				MyLogger.writeMessage("State changed to ModerateRisk ", MyLogger.DebugLevel.STATE_CHANGE);
				
			}
			
		}
		catch(Exception e)
		{
			MyLogger.writeMessage("Exception occured in increaseOrDecreaseSecurity of HighRisk class \n"+e.toString(), MyLogger.DebugLevel.NONE);
			System.exit(1);
		}
		finally{
			
		}
		
	}
	

}
