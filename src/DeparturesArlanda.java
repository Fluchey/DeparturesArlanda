import java.util.List;
import java.util.Objects;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.lang.reflect.Type;

import com.google.gson.*;

public class DeparturesArlanda {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String todaysDate = sdf.format(new Date());
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(todaysDate));
		c.add(Calendar.DATE, 1);
		String tomorrowsDate = sdf.format(c.getTime());
		
		String jsonToday = readUrl("http://www.swedavia.se/services/publicflightsboard/departures/language/sv/iata/ARN/date/"
				+ todaysDate + "/");
		String jsonTomorrow = readUrl("http://www.swedavia.se/services/publicflightsboard/departures/language/sv/iata/ARN/date/"
				+ tomorrowsDate + "/");
		
		Gson gson = new Gson();
		ArrayList jsonObjList = new ArrayList();

		try {
			JsonParser jsonParser = new JsonParser();
			JsonObject jo = (JsonObject) jsonParser.parse(jsonToday);
			JsonArray jsonArr = jo.getAsJsonArray("Flights");
			jsonObjList = gson.fromJson(jsonArr, ArrayList.class);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ArrayList<String> strings = new ArrayList(jsonObjList.size());
		for (Object object : jsonObjList) {
			strings.add(Objects.toString(object, null));
		}

		ArrayList<Flight> upcomingFlights = new ArrayList();

		for (String s : strings) {
			String arrivalDestination = getArrivalDestination(s);
			int terminal = getTerminal(s);
			String probableFlightTime = getProbableFlightTime(s);
			String airline = getAirline(s);
			Flight flight = new Flight(arrivalDestination, terminal, probableFlightTime, airline);
			
			try{
				String actualTime = new SimpleDateFormat("HH:mm").format(new Date());
				SimpleDateFormat stf = new SimpleDateFormat("HH:mm");
				Date thisTime = stf.parse(actualTime);
				Date compareTime = stf.parse(probableFlightTime);
				if(compareTime.after(thisTime)){
					upcomingFlights.add(flight);
				}
			}catch(ParseException e){
				e.printStackTrace();
			}
			
		}
		
		Collections.sort(upcomingFlights);
		
		MainFrame mf = new MainFrame(upcomingFlights);

	}

	private static String readUrl(String urlString) throws Exception {
		BufferedReader reader = null;
		try {
			URL url = new URL(urlString);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1)
				buffer.append(chars, 0, read);
			return buffer.toString();
		} finally {
			if (reader != null)
				reader.close();
		}
	}

	private static String getArrivalDestination(String arrivalDestinationString) {
		String arrivalDestination1 = arrivalDestinationString
				.substring(arrivalDestinationString.indexOf("ArrivalDestination") + 39);
		String arrivalDestination2[] = arrivalDestination1.split("}");
		return arrivalDestination2[0];
	}

	private static int getTerminal(String terminalString) {
		String terminal1 = terminalString.substring(terminalString.indexOf("Terminal") + 9);
		int terminal = (int) terminal1.charAt(0) - '0';
		return terminal;
	}

	private static String getProbableFlightTime(String string) {
		String s1 = string.substring(string.indexOf("ProbableTime") + 24);
		String s2[] = s1.split(",");
		SimpleDateFormat currentFormat = new SimpleDateFormat("H:m:s");
		SimpleDateFormat myFormat = new SimpleDateFormat("HH:mm");
		String reformattedString = new String();
		try{
			reformattedString = myFormat.format(currentFormat.parse(s2[0]));
		}catch (ParseException e){
			e.printStackTrace();
		}
		return reformattedString;
	}

	private static String getAirline(String string) {
		String s1 = string.substring(string.indexOf("Operator"));
		String s2 = s1.substring(s1.indexOf("Name"));
		String s3 = s2.substring(5, s2.indexOf(","));
		return s3;
	}

}
