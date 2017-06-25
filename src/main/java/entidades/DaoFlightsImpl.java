package entidades;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DaoFlightsImpl implements DaoFlights {

	private static final String PATH_FILE = "src/main/resources/flights.csv";

	private static List<Flight> listFlight;

	public DaoFlightsImpl(){
		String line;
		String[] array;

		if(listFlight==null){
			try (FileReader fIn = new FileReader(PATH_FILE); BufferedReader bIn = new BufferedReader(fIn);) {
				listFlight = new ArrayList<>();
				while ((line = bIn.readLine()) != null) {
					array = line.split(";");
					listFlight.add(new Flight(array[0], array[1], array[2], new BigDecimal(array[3]).setScale(2)));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 		
		}
	}
	public List<Flight> getList(){
		return listFlight;
	}
	
	public List<Flight> getFlights(String origin, String destination) {
		return getList().stream().filter(f -> f.getOrigin().equals(origin) && f.getDestination().equals(destination))
				.collect(Collectors.toList());
	}

}
