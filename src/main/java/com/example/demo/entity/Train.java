package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "The train entity, to store the train's information")
public class Train {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	
	@ApiModelProperty(notes = "The source of the train")
	@NotEmpty(message = "source is required")
	private String source;

	@ApiModelProperty(notes = "The destination of the train")
	@NotEmpty(message = "destination is required")
	private String destination;

	@ApiModelProperty(notes = "The date of journey of the train")
	@NotNull(message = "dateOfJourney is required")
	@FutureOrPresent
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfJourney;

	@ApiModelProperty(notes = "The trainNumber of the train")
	@NotNull(message = "trainNumber is required")
	private Long trainNumber;

	
	@ApiModelProperty(notes = "The trainName of the train")
	@NotEmpty(message = "trainName is required")
	private String trainName;

	@ApiModelProperty(notes = "The seats in the train")
	@Column(length = 1000)
	@NotNull(message = "seats is required")
	private Integer seats;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Long getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(Long trainNumber) {
		this.trainNumber = trainNumber;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "Train [id=" + id + ", source=" + source + ", destination=" + destination + ", dateOfJourney="
				+ dateOfJourney + ", trainNumber=" + trainNumber + ", trainName=" + trainName + ", seats=" + seats
				+ "]";
	}

}
