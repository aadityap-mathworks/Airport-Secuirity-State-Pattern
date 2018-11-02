package airportSecurityState.airportStates;

import airportSecurityState.util.FileProcessor;

public class Manager {

	AirportStateI high;
    AirportStateI moderate;
    AirportStateI low;
    AirportStateI currentState;
    FileProcessor fp;
    Calculations cal;

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



	public Manager(FileProcessor fpIn) {
		
		this.fp=fpIn;
		cal =new Calculations(fp);
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
				System.out.println(currentline);
				
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
