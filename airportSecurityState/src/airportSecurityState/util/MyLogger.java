package airportSecurityState.util;

public class MyLogger {

	private MyLogger() {
//		/MyLogger.writeMessage("Constructor of MyLogger is called", MyLogger.DebugLevel.CONSTRUCTOR);
	}
	

    public static enum DebugLevel { NONE ,
    	CONTENT_OF_RESULT, 
    	STATE_CHANGE,
    	PROHIBITED_ITEMS};

    private static DebugLevel debugLevel;
   
    public static void setDebugValue (int levelIn) {
		switch (levelIn) 
		{
//			case 4: 
//				debugLevel = DebugLevel.CONSTRUCTOR; 
//				break;
			case 3: 
				debugLevel = DebugLevel.PROHIBITED_ITEMS; 
				break;
			case 2: 
				debugLevel = DebugLevel.STATE_CHANGE; 
				break;
			case 1: 
				debugLevel = DebugLevel.CONTENT_OF_RESULT; 
				break;
			default: 
				debugLevel = DebugLevel.NONE; 
				break;
		}
    }

    public static void setDebugValue (DebugLevel levelIn) {
	debugLevel = levelIn;
    }

    public static void writeMessage (String     message  ,
                                     DebugLevel levelIn ) {
	if (levelIn == debugLevel)
	    System.out.println(message);
    }

    public String toString() {
	return "The debug level has been set to the following " + debugLevel;
    }

}
