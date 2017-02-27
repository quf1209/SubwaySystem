package kr.ac.subway.model;

import org.hibernate.validator.constraints.NotEmpty;

public class Subway {

	private String date;
	@NotEmpty(message="Temperature is not empty")
	private String temperature;
	@NotEmpty(message="Humidity is not empty")
	private String humidity;
	
	
	public Subway() {
	
	}
	
	
	@Override
	public String toString() {
		return "Subway [date=" + date + ", temperature=" + temperature + ", humidity=" + humidity + "]";
	}


	public Subway(String date, String temperature, String humidity) {
		this.date = date;
		this.temperature = temperature;
		this.humidity = humidity;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	
	
	
}
