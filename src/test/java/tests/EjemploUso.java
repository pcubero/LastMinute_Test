package tests;
import entidades.DaoFlights;
import entidades.DaoFlightsImpl;
import entidades.Searcher;

public class EjemploUso {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		
		DaoFlights repo=new DaoFlightsImpl();
		System.out.println(repo.getFlights("AMS", "FRA"));
		System.out.println(repo.getFlights("LHR", "IST"));
		System.out.println(repo.getFlights("BCN", "MAD"));
		System.out.println(repo.getFlights("CDG", "FRA"));
		System.out.println(repo.getFlights(null, "FRA"));

		Searcher searcher=new Searcher(repo);
		System.out.println(searcher.findFlights("AMS", "FRA", 31, 1, 0, 0));
		System.out.println(searcher.findFlights("LHR", "IST", 15, 2, 1, 1));
		System.out.println(searcher.findFlights("BCN", "MAD", 2, 1, 2, 0));
		System.out.println(searcher.findFlights("CDG", "FRA", 31, 1, 0, 0));
		System.out.println(searcher.findFlights("CDG", null, 31, 1, 0, 0));

	}

}
