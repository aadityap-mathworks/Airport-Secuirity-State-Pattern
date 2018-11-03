package airportSecurityState.airportStates;

public interface AirportStateI {
	public void increaseOrDecreaseSecurity(float avgTrafficPerDay,float avgProhibitedItemsPerDay);
}
