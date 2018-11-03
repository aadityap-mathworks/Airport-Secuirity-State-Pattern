package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;
import airportSecurityState.util.Results;

public class LowRisk implements AirportStateI  {

	Manager currentState;
	Results res;
	Calculations cal;
	float averageProhibitedItemsPerDay;
	float averageTrafficPerDay;
		
	public LowRisk(Manager currentStateIn, Results resIn, Calculations calIn) {
		MyLogger.writeMessage("Constructor of LowRisk called ", MyLogger.DebugLevel.CONSTRUCTOR);
		this.currentState = currentStateIn;
		this.res= resIn;
		this.cal=calIn;
        
	}
	@Override
	public void increaseOrDecreaseSecurity(String currentline) {
		
		try {
			cal.getMetrics(currentline);	
			averageTrafficPerDay= cal.getAvgTrafficPerDay();
			averageProhibitedItemsPerDay= cal.getAvgProhibitedItemsPerDay();
			
			if((averageTrafficPerDay>=8) || (averageProhibitedItemsPerDay>=4))
			{
				currentState.setCurrentState(currentState.getHigh());
				res.addToFinalResult(opIdHigh);
				MyLogger.writeMessage("State changed to HighRisk ", MyLogger.DebugLevel.STATE_CHANGE);
			}
			else if((averageTrafficPerDay>=4 && averageTrafficPerDay<8)
					||(averageProhibitedItemsPerDay>=2 && averageProhibitedItemsPerDay<4))
			{
				currentState.setCurrentState(currentState.getModerate());
				res.addToFinalResult(opIdMod);
				MyLogger.writeMessage("State changed to ModerateRisk ", MyLogger.DebugLevel.STATE_CHANGE);
				
			}
			else if((averageTrafficPerDay>=0 && averageTrafficPerDay<4)
					||(averageProhibitedItemsPerDay>=0 && averageProhibitedItemsPerDay<2))
			{
				currentState.setCurrentState(currentState.getLow());
				res.addToFinalResult(opIdLow);
			}
		}
		catch(Exception e)
		{
			MyLogger.writeMessage("Exception occured in increaseOrDecreaseSecurity of LowRisk class \n"+e.toString(), MyLogger.DebugLevel.NONE);
			System.exit(1);
		}
		finally {
			
		}
	}

	
}
