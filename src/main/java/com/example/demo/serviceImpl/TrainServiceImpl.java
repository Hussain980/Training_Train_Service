package com.example.demo.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Train;
import com.example.demo.exception.TrainNotFoundException;
import com.example.demo.repository.TrainRepository;
import com.example.demo.service.TrainService;

@Service
public class TrainServiceImpl implements TrainService{
	
	private static final Logger logger = LoggerFactory.getLogger(TrainServiceImpl.class);
	
	@Autowired
	TrainRepository trainRepo;


	public List<Train> getAllTrains(String source, String destination, LocalDate dateOfJourney) {
		logger.info("inside trainServiceImpl ==  {} "+ source + "  "+destination +"  "+dateOfJourney);
		List<Train> trains = trainRepo.findAllTrains(source, destination, dateOfJourney) ;
		if(trains.isEmpty()) {
			throw new TrainNotFoundException("Train Not Found ");
		}else
			return trains;
	}

	@Override
	public Train getTrainDetails(Long trainNumber) {
		Train train =  trainRepo.findByTrainNumber(trainNumber);
		if(train==null) {
			throw new TrainNotFoundException("Train not found");
		}
		return train;
	}

	@Override
	@Transactional
	public void updateSeats(Train train) {
		
		 Train traindb = trainRepo.findByTrainNumber(train.getTrainNumber());
		 traindb.setSeats(train.getSeats());
		 logger.info("gettin data from train table    ===============   ="+ traindb.getSeats());
		 trainRepo.save(traindb);
	}


	

}
