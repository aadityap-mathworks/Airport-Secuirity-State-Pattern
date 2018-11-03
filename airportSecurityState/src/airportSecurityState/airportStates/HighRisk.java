package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;
import airportSecurityState.util.Results;

public class HighRisk implements AirportStateI {

	Manager currentState;
	Results res;
	public HighRisk(Manager currentStateIn, Results resIn) {
		MyLogger.writeMessage("Constructor of HighRisk called ", MyLogger.DebugLevel.CONSTRUCTOR);
		this.currentState = currentStateIn;
		this.res= resIn;
        
	}

	@Override
	public void increaseOrDecreaseSecurity(float averageTrafficPerDay,float averageProhibitedItemsPerDay) 
	{
		try {
			
			if((averageTrafficPerDay>=8) || (averageProhibitedItemsPerDay>=4))
			{ 
				currentState.setCurrentState(currentState.getHigh());
				res.addToFinalResult(opIdHigh);
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
				MyLogger.writeMessage("State changed to LowRisk ", MyLogger.DebugLevel.STATE_CHANGE);
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
