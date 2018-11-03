package airportSecurityState.airportStates;

public interface AirportStateI {
	
	String opIdLow = "1 3 5 7 9";
	String opIdMod = "2 3 5 8 9";
	String opIdHigh = "2 4 6 8 10";
	
	public void increaseOrDecreaseSecurity(float avgTrafficPerDay,float avgProhibitedItemsPerDay);
}
