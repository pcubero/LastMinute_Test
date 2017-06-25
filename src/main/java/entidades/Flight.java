package entidades;


import java.math.BigDecimal;

public class Flight {
	private String origin;
	private String destination;
	private String flightCode;
	private BigDecimal price;
	
	
	public Flight(String origin, String destination, String flightCode, BigDecimal price) {
		this.origin = origin;
		this.destination = destination;
		this.flightCode = flightCode;
		this.price = price;
	}


	public String getOrigin() {
		return origin;
	}


	public String getDestination() {
		return destination;
	}


	public String getFlightCode() {
		return flightCode;
	}


	public BigDecimal getPrice() {
		return price;
	}
	
	public String getAirline() {
		return flightCode.substring(0,2);
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((flightCode == null) ? 0 : flightCode.hashCode());
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (flightCode == null) {
			if (other.flightCode != null)
				return false;
		} else if (!flightCode.equals(other.flightCode))
			return false;
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Flight [origin=" + origin + ", destination=" + destination + ", flightCode=" + flightCode + ", price="
				+ price + "]";
	}


	
	
}
