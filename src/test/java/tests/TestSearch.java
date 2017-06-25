package tests;
import static constantes.PruebasConstantes.prueba1;
import static constantes.PruebasConstantes.prueba2;
import static constantes.PruebasConstantes.prueba3;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import entidades.DaoFlights;
import entidades.Result;
import entidades.Searcher;

public class TestSearch {
	
  private DaoFlights repofl= mock(DaoFlights.class);

  @BeforeTest
  public void inicializar(){
	  //Stubbing
	  when(repofl.getFlights("AMS", "FRA")).thenReturn(prueba1);
	  when(repofl.getFlights("LHR", "IST")).thenReturn(prueba2);
	  when(repofl.getFlights("BCN", "MAD")).thenReturn(prueba3);
	  when(repofl.getFlights("BCN", null)).thenReturn(Collections.emptyList());
	  when(repofl.getFlights(null, "MAD")).thenReturn(Collections.emptyList());
	  when(repofl.getFlights(null, null)).thenReturn(Collections.emptyList());
  }
  
  @Test(dataProvider="dpValores")
  public void testFindFlights(String orig,String dest,int ndays,int nadult,int nchild,int ninfant,List<Result> resultados){
	  Searcher search= new Searcher(repofl);
	   assertThat(search.findFlights(orig, dest, ndays, nadult, nchild, ninfant),is(resultados));
  }
  
  @DataProvider(name = "dpValores")
  public Object[][] valores() {
	  
	  List<Result> res1=Arrays.asList(new Result("TK2372",new BigDecimal("157.60")),
			                          new Result("TK2659",new BigDecimal("198.40")),
			                          new Result("LH5909",new BigDecimal("90.40")));

	  List<Result> res2=Arrays.asList(new Result("TK8891",new BigDecimal(806).setScale(2)),
              new Result("LH1085",new BigDecimal("481.19")));
	  
	  List<Result> res3=Arrays.asList(new Result("IB2171",new BigDecimal("909.10")),
              new Result("LH5496",new BigDecimal("1028.44")));

    return new Object[][] {
       {"AMS","FRA",31,1,0,0,res1},
       {"LHR","IST",15,2,1,1,res2},
       {"BCN","MAD",2,1,2,0,res3},
       {"CDG","FRA",31,1,0,0,Collections.emptyList()},
       {"BCN",null,31,1,2,0,Collections.emptyList()},
       {null,"MAD",31,1,2,0,Collections.emptyList()},
       {null,null,31,1,2,0,Collections.emptyList()}
    };
  }

}
