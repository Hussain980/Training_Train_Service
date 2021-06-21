package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Train;

@Service
public interface TrainService {


	public List<Train> getAllTrains(String source, String destination, LocalDate dateOfJourney);

	public Train getTrainDetails(Long trainNumber);


	public void updateSeats(Train train);
}
