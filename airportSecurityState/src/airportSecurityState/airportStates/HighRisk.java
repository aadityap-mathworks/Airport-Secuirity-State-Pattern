package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;
import airportSecurityState.util.Results;

public class HighRisk implements AirportStateI {

	Manager currentState;
	Results res;
	public HighRisk(Manager currentStateIn, Results resIn) {
		MyLogger.writeMessage("High Risk: ", MyLogger.DebugLevel.CONSTRUCTOR);
		this.currentState = currentStateIn;
		this.res= resIn;
        
	}

	@Override
	public void increaseOrDecreaseSecurity(float averageTrafficPerDay,float averageProhibitedItemsPerDay) 
	{
		
		if((averageTrafficPerDay>=8) || (averageProhibitedItemsPerDay>=4))
		{ 
			currentState.setCurrentState(currentState.getHigh());
			res.addToFinalResult("2 4 6 8 10");
		}
		else if((averageTrafficPerDay>=4 && averageTrafficPerDay<8)
				||(averageProhibitedItemsPerDay>=2 && averageProhibitedItemsPerDay<4))
		{
			currentState.setCurrentState(currentState.getModerate());
			res.addToFinalResult("2 3 5 8 9");
			
		}
		else if((averageTrafficPerDay>=0 && averageTrafficPerDay<4)
				||(averageProhibitedItemsPerDay>=0 && averageProhibitedItemsPerDay<2))
		{
			currentState.setCurrentState(currentState.getLow());
			res.addToFinalResult("1 3 5 7 9");
		}
		
	}
	

}
