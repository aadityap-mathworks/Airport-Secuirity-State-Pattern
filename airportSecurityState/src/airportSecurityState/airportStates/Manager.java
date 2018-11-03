package airportSecurityState.airportStates;

import java.io.IOException;

import airportSecurityState.util.FileProcessor;
import airportSecurityState.util.MyLogger;
import airportSecurityState.util.Results;

public class Manager {

	AirportStateI high;
    AirportStateI moderate;
    AirportStateI low;
    AirportStateI currentState;
    FileProcessor fp;
    Results res;
    Calculations cal;
    float averageProhibitedItemsPerDay;
	float averageTrafficPerDay;
	
    
	public AirportStateI getHigh() {
		return high;
	}



	public void setHigh(AirportStateI high) {
		this.high = high;
	}



	public AirportStateI getModerate() {
		return moderate;
	}



	public void setModerate(AirportStateI moderate) {
		this.moderate = moderate;
	}



	public AirportStateI getLow() {
		return low;
	}



	public void setLow(AirportStateI low) {
		this.low = low;
	}

 

	public AirportStateI getCurrentState() {
		return currentState;
	}



	public void setCurrentState(AirportStateI currentState) {
		this.currentState = currentState;
	}
	

	public Manager(FileProcessor fpIn, Results resIn) {
		
		MyLogger.writeMessage("Constructor of Manager called ", MyLogger.DebugLevel.CONSTRUCTOR);
		this.fp=fpIn;
		this.res= resIn;
		cal= new Calculations();
		low = new LowRisk(this,res);
		moderate = new ModerateRisk(this,res);
		high = new HighRisk(this,res);
		currentState=low;
		
		
	}
	
	public void start()
	{
		try {
			
			String currentline;
			while ((currentline = fp.readInputLine()) != null) 
			{
				cal.getMetrics(currentline);	
				averageTrafficPerDay= cal.getAvgTrafficPerDay();
				averageProhibitedItemsPerDay= cal.getAvgProhibitedItemsPerDay();
				currentState.increaseOrDecreaseSecurity(averageTrafficPerDay,averageProhibitedItemsPerDay);
			}
		}
		catch(Exception e) {
			MyLogger.writeMessage("Exception occured in start method of Manager class \n"+e.toString(), MyLogger.DebugLevel.NONE);
			System.exit(1);
		}
		finally
		{
			try {
				
				fp.close();
			}
			catch(Exception e)
			{
				MyLogger.writeMessage("Exception occured while closing FileProcessor object in Manager class \n"+e.toString(), MyLogger.DebugLevel.NONE);
				System.exit(1);
			}
		}
		
		
	}


	

}
