
public class Flight implements Comparable<Flight>{
	private String arrivalDestination;
	private int terminal;
	private String probableFlightTime;
	private String airlineName;

	public Flight(String arrivalDestination, int terminal, String probableFlightTime, String airlineName) {
		this.arrivalDestination = arrivalDestination;
		this.terminal = terminal;
		this.probableFlightTime = probableFlightTime;
		this.airlineName = airlineName;
	}

	public String getArrivalDestination() {
		return arrivalDestination;
	}

	public int getTerminal() {
		return terminal;
	}

	public String getProbableFlightTime() {
		return probableFlightTime;
	}

	public String getAirlineName() {
		return airlineName;
	}
	
	@Override
	public int compareTo(Flight f){
		return getProbableFlightTime().compareTo(f.getProbableFlightTime());
	}
}
