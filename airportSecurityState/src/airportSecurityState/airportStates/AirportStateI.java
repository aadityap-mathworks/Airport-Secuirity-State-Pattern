package airportSecurityState.airportStates;

/**
 * @author Aaditya Sakharam Patil
 *
 */
public interface AirportStateI {
	
	String opIdLow = "1 3 5 7 9";
	String opIdMod = "2 3 5 8 9";
	String opIdHigh = "2 4 6 8 10";
	

	/**
	 * changes Security states 
	 *
	 */
	public void increaseOrDecreaseSecurity(String line);
}
