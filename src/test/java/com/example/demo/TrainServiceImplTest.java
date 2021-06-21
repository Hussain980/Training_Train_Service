package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.TrainDto;
import com.example.demo.entity.Train;
import com.example.demo.exception.TrainNotFoundException;
import com.example.demo.repository.TrainRepository;
import com.example.demo.serviceImpl.TrainServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TrainServiceImplTest {

	@Mock
	TrainRepository trainRepo;
	
	@InjectMocks
	TrainServiceImpl trainServiceImpl;
	
	static TrainDto trainDto;

	static Train train1;
	
	static Train train2;

	@BeforeAll
	public static void setup() {
		trainDto = new TrainDto();
		trainDto.setDestination("Kolkata");
		trainDto.setSource("Delhi");
		LocalDate date = LocalDate.of(2021, 7, 12);
		trainDto.setDateOfJourney(date);
		train1 = new Train();
		train2 = new Train();
		train1.setDateOfJourney(date);
		train1.setDestination("Kolkata");
		train1.setSource("Delhi");
		train1.setSeats(100);
		train1.setTrainName("rajdhani");
		train1.setTrainNumber(15120L);
		train2.setDateOfJourney(date);
		train2.setDestination("Kolkata");
		train2.setSource("Delhi");
		train2.setSeats(500);
		train2.setTrainName("shatabdi");
		train2.setTrainNumber(19222L);
	}
	
	@Test
	@DisplayName("Find all Trains : positive scenario")
	public void testGetAllTrains() {
		List<Train> trainlist = new ArrayList<>();
		trainlist.add(train1);
		trainlist.add(train2);
		
		when(trainRepo.findAllTrains("Delhi","Kolkata",LocalDate.of(2021, 7, 12))).thenReturn(trainlist);
		 List<Train> trains =trainServiceImpl.getAllTrains("Delhi","Kolkata",LocalDate.of(2021, 7, 12));
		 assertEquals(trainlist, trains);
	}
	
	@Test
	@DisplayName("Find Train by trainNumber : positive scenario")
	public void testGetTrainDetails() {
		when(trainRepo.findByTrainNumber(19222L)).thenReturn(train2);
		 Train train2db =trainServiceImpl.getTrainDetails(19222L);
		 assertEquals(train2, train2db);
	}
	
	@Test
	@DisplayName("Find Train by trainNumber : negative scenario")
	public void testGetTrainDetails1() {
		when(trainRepo.findByTrainNumber(19222L)).thenReturn(null);
		assertThrows(TrainNotFoundException.class, () -> trainServiceImpl.getTrainDetails(19222L));
	}

}
