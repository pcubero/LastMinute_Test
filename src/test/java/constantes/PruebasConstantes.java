package constantes;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import entidades.Flight;

public abstract class PruebasConstantes {
	
	public static final List<Flight> prueba1=Arrays.asList(new Flight("AMS","FRA","TK2372",new BigDecimal(197).setScale(2)),
            new Flight("AMS","FRA","TK2659",new BigDecimal(248).setScale(2)),
            new Flight("AMS","FRA","LH5909",new BigDecimal(113).setScale(2)));

	public static final List<Flight> prueba2=Arrays.asList(new Flight("LHR","IST","TK8891",new BigDecimal(250).setScale(2)),
            new Flight("LHR","IST","LH1085",new BigDecimal(148).setScale(2)));

	public static final List<Flight> prueba3=Arrays.asList(new Flight("BCN","MAD","IB2171",new BigDecimal(259).setScale(2)),
            new Flight("BCN","MAD","LH5496",new BigDecimal(293).setScale(2)));

}
