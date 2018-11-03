package airportSecurityState.airportStates;

import airportSecurityState.util.FileProcessor;

public class Manager {

	AirportStateI high;
    AirportStateI moderate;
    AirportStateI low;
    AirportStateI currentState;
    FileProcessor fp;
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
	

	public Manager(FileProcessor fpIn) {
		
		this.fp=fpIn;
		cal= new Calculations();
		high = new HighRisk(this);
		low = new LowRisk(this);
		moderate = new ModerateRisk(this);
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
			e.printStackTrace();
		}
		finally
		{
			
		}
		
		
	}


	

}
