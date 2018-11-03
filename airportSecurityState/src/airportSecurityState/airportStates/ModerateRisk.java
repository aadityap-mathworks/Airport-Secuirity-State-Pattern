package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;

public class ModerateRisk implements AirportStateI {
	
	Manager currentState;
	
	public ModerateRisk(Manager currentStateIn) {
		MyLogger.writeMessage("High Risk: ", MyLogger.DebugLevel.CONSTRUCTOR);
		currentState = currentStateIn;
        
	}

	@Override
	public void increaseOrDecreaseSecurity(float averageTrafficPerDay,float averageProhibitedItemsPerDay) 
	{
		
		
		if((averageTrafficPerDay>=8) || (averageProhibitedItemsPerDay>=4))
		{
			System.out.println("2 4 6 8 10"); 
			currentState.setCurrentState(currentState.getHigh());
		}
		else if((averageTrafficPerDay>=4 && averageTrafficPerDay<8)
				||(averageProhibitedItemsPerDay>=2 && averageProhibitedItemsPerDay<4))
		{
			System.out.println("2 3 5 8 9");
			currentState.setCurrentState(currentState.getModerate());
			
		}
		else if((averageTrafficPerDay>=0 && averageTrafficPerDay<4)
				||(averageProhibitedItemsPerDay>=0 && averageProhibitedItemsPerDay<2))
		{
			System.out.println("1 3 5 7 9");
			currentState.setCurrentState(currentState.getLow());
		}
	}

}
