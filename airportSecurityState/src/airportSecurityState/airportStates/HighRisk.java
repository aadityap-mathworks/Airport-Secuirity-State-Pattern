package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;
import airportSecurityState.util.Results;

public class HighRisk implements AirportStateI {

	Manager currentState;
	Results res;
	Calculations cal;
	float averageProhibitedItemsPerDay;
	float averageTrafficPerDay;
		
	public HighRisk(Manager currentStateIn, Results resIn,Calculations calIn) {
		MyLogger.writeMessage("Constructor of HighRisk called ", MyLogger.DebugLevel.CONSTRUCTOR);
		this.currentState = currentStateIn;
		this.res= resIn;
		this.cal=calIn;
        
	}

	@Override
	public void increaseOrDecreaseSecurity(String currentline) 
	{
		try {
			cal.getMetrics(currentline);	
			averageTrafficPerDay= cal.getAvgTrafficPerDay();
			averageProhibitedItemsPerDay= cal.getAvgProhibitedItemsPerDay();
			
			
			if((averageTrafficPerDay>=8) || (averageProhibitedItemsPerDay>=4))
			{ 
				currentState.setCurrentState(currentState.getHigh());
				res.addToFinalResult(opIdHigh);
			}
			else 
			{
				currentState.setCurrentState(currentState.getModerate());
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
