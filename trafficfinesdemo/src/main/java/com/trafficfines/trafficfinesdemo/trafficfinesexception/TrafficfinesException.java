package com.trafficfines.trafficfinesdemo.trafficfinesexception;




import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TrafficfinesException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TrafficfinesException(String message) {
		super(message);
	}
}
