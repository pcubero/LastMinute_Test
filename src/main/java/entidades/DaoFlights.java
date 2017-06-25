package entidades;
import java.util.List;

public interface DaoFlights {
	List<Flight> getFlights(String origin,String destination);
}
