package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;

public class HighRisk implements AirportStateI {

	Manager airportState;
	Calculations cal;
	
	public HighRisk (Manager airportStateIn) 
	{
        MyLogger.writeMessage("High Risk: ", MyLogger.DebugLevel.CONSTRUCTOR);
        airportState = airportStateIn;
        //statePredictor = new StatePredictor();
	}

}
