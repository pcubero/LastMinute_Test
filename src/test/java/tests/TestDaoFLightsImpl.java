package tests;
import static constantes.PruebasConstantes.prueba1;
import static constantes.PruebasConstantes.prueba2;
import static constantes.PruebasConstantes.prueba3;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import entidades.Flight;
import entidades.DaoFlightsImpl;

public class TestDaoFLightsImpl {
	
    @Test
	public void testDaoFlightsImpl() {
	   DaoFlightsImpl	repimpl	= new DaoFlightsImpl();
	   assertThat(repimpl.getList(), is(not(nullValue())));
	
     }
    @Test(dependsOnMethods={"testDaoFlightsImpl"})
	public void testGetList() {
    	testDaoFlightsImpl();
	}
    
    @Test(dependsOnMethods={"testGetList"},dataProvider="dp")
	public void testGetFlights(String orig ,String dest, List<Flight> listVuelosEsperados) {
		   DaoFlightsImpl	reimpl	= new DaoFlightsImpl();
		   assertThat(reimpl.getFlights(orig, dest),is(listVuelosEsperados));
	}
    
    @DataProvider(name = "dp")
    public Object[][] valores(){    	

    	return new Object[][]{
    			{"AMS","FRA",prueba1},
    			{"LHR","IST",prueba2},
    			{"BCN","MAD",prueba3},
    			{"CDG", "FRA",Collections.emptyList()},
    			{"BCN",null,Collections.emptyList()},
    			{null,"MAD",Collections.emptyList()},
    			{null,null,Collections.emptyList()}
    	};
    }

}
