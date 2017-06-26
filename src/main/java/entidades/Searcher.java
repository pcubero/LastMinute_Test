package entidades;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Searcher {
	
	private DaoFlights repository;
	private enum type_passenger {ADULT,CHILD};
	
	public Searcher(DaoFlights repo){
		repository=repo;
	}
	
	public List<Result> findFlights(String airpOrig,String airpDest,int ndays,int nadult,int nchild, int ninfant){
		
		List<Result> lstRes=new ArrayList<>();
		BigDecimal priceTotal;
		
		for(Flight flight:repository.getFlights(airpOrig, airpDest)){
			
			priceTotal=BigDecimal.ZERO;
			
			if(nadult>0)  priceTotal=priceTotal.add(getPrice(type_passenger.ADULT, ndays, flight.getPrice()).multiply(new BigDecimal(nadult)));
			if(nchild>0)  priceTotal=priceTotal.add(getPrice(type_passenger.CHILD, ndays, flight.getPrice()).multiply(new BigDecimal(nchild)));
			if(ninfant>0) priceTotal=priceTotal.add(getPriceEnfant(flight.getAirline()).multiply(new BigDecimal(ninfant)));
			
			lstRes.add(new Result(flight.getFlightCode(), priceTotal));		
		}
		
		return lstRes;
		
	}
	
	private  BigDecimal getPrice(type_passenger pass,int ndays,BigDecimal price ){
		
		BigDecimal resPrice=BigDecimal.ZERO;
		
		switch(pass){
		
			case ADULT:
				resPrice= getPriceDeparture(ndays,price);
				break;
			case CHILD:
				resPrice = getPriceDeparture(ndays,price);
				resPrice = getPercentPrice(resPrice,67);
				break;
			default:
				
		}
		
		return resPrice;		
	}
	
	private BigDecimal getPriceDeparture(int ndays,BigDecimal basePrice){

		if(ndays>30){
			return getPercentPrice(basePrice,80);
		}else if(ndays<=30 && ndays>=16){
			return basePrice;
		}else if(ndays<=15 && ndays>=3){
			return getPercentPrice(basePrice,120);
		}else{
			return getPercentPrice(basePrice,150);
		}
			
	}
	
	private BigDecimal getPercentPrice(BigDecimal price,int percent){
		return price.multiply(new BigDecimal(percent)).divide(BigDecimal.TEN.pow(2),2,RoundingMode.HALF_UP);
		
	}
	
	private BigDecimal getPriceEnfant(String airline){

		switch(airline){
			case "IB": return BigDecimal.TEN.setScale(2);
			case "BA": return new BigDecimal("15.00");
			case "LH": return new BigDecimal("7.00");
			case "FR": return new BigDecimal("20.00");
			case "VY": return BigDecimal.TEN.setScale(2);
			case "TK": return new BigDecimal("5");
			case "U2": return new BigDecimal("19.90");
			default  : return null;
		}
		
	}

}
