package airportSecurityState.util;
/**
 * @author Aaditya Sakharam Patil
 *
 */

public class MyLogger {

	/**
	 * Constructor
	 */
	private MyLogger() {
		MyLogger.writeMessage("Constructor of MyLogger called ", MyLogger.DebugLevel.CONSTRUCTOR);
	}
	
	/**
	 * Enum for debugLevel
	 */
    public static enum DebugLevel { NONE ,
    	ENTRY_IN_RESULT, 
    	STATE_CHANGE,
    	PROHIBITED_ITEMS,
    	CONSTRUCTOR};

    private static DebugLevel debugLevel;
   
    /**
     * method to set debug value
     * @param level integer
     */
    public static void setDebugValue (int levelIn) {
		switch (levelIn) 
		{
			case 4: 
				debugLevel = DebugLevel.CONSTRUCTOR; 
				break;
			case 3: 
				debugLevel = DebugLevel.PROHIBITED_ITEMS; 
				break;
			case 2: 
				debugLevel = DebugLevel.STATE_CHANGE; 
				break;
			case 1: 
				debugLevel = DebugLevel.ENTRY_IN_RESULT; 
				break;
			default: 
				debugLevel = DebugLevel.NONE; 
				break;
		}
    }

    /**
     * method to set debug value
     * @param level integer
     */
    public static void setDebugValue (DebugLevel levelIn) {
	debugLevel = levelIn;
    }

    /**
     * method to write message
     * @param message and debug level
     */
    public static void writeMessage (String     message  ,
                                     DebugLevel levelIn ) {
	if (levelIn == debugLevel)
	    System.out.println(message);
    }

    /**
     * toString method
     */
    public String toString() {
	return "The debug level has been set to the following " + debugLevel;
    }

}
