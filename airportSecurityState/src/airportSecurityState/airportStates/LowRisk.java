package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;

public class LowRisk implements AirportStateI  {

	Manager airportState;
	Calculations cal;
	float averageProhibitedItemsPerDay;
	float averageTrafficPerDay;
	
	public LowRisk(Manager airportStateIn) {
		MyLogger.writeMessage("High Risk: ", MyLogger.DebugLevel.CONSTRUCTOR);
        airportState = airportStateIn;
        cal = new Calculations();
	}

	
}
