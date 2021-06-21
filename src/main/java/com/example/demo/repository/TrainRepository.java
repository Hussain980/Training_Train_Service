package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Train;

@Repository
public interface TrainRepository extends JpaRepository<Train, Integer> {


	@Query("select t from Train t where t.source=:source and t.destination=:destination and t.dateOfJourney=:dateOfJourney")
	public List<Train> findAllTrains(@Param("source") String source, @Param("destination") String destination,
		     @Param("dateOfJourney")	LocalDate dateOfJourney);

	public Train findByTrainNumber(Long trainNumber);
	
}
