package entidades;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class Result {
	private String airline;
	private BigDecimal price;
	
	public Result(String airline, BigDecimal price) {
		this.airline = airline;
		this.price = price.setScale(2,RoundingMode.UP);
	}

	public String getAirline() {
		return airline;
	}

	//lo cambio
	public BigDecimal getPrice() {
		return price;
	}
	
	//pruebas
		public BigDecimal getPrice2() {
			return price;
		}

	@Override
	public String toString() {
		return "Result [airline=" + airline + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airline == null) ? 0 : airline.hashCode());
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
		Result other = (Result) obj;
		if (airline == null) {
			if (other.airline != null)
				return false;
		} else if (!airline.equals(other.airline))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}
	
	
	
}
