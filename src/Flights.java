import java.util.ArrayList;
import java.util.List;

public class Flights {
	List <DepartureDestination> DepartureDestination = new ArrayList<>();

	public List<DepartureDestination> getDepartureDestination() {
		return DepartureDestination;
	}

	public void setDepartureDestination(List<DepartureDestination> departureDestination) {
		DepartureDestination = departureDestination;
	}
}
