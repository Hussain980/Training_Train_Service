package com.example.demo.dto;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TrainDto {

	@NotEmpty(message = "source is required")
	private String source;
	
	@NotEmpty(message = "destination is required")
	private String destination;

	@NotNull(message = "dateOfJourney is required")
	@FutureOrPresent
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfJourney;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDate getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(LocalDate dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

}
