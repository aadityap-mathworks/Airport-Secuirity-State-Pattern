package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;

public class ModerateRisk implements AirportStateI {
	
	Manager airportState;
	Calculations cal;
	
	public ModerateRisk(Manager airportStateIn) {
		MyLogger.writeMessage("High Risk: ", MyLogger.DebugLevel.CONSTRUCTOR);
        airportState = airportStateIn;
	}

}
