package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TrainDto;
import com.example.demo.entity.Train;
import com.example.demo.service.TrainService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;


@Api(value = "TrainController", tags = { "Train Controller" })
@SwaggerDefinition(tags = {
		@Tag(name = "Train Controller", description = "Train Controller contains some end points related to Train operation") })
@RestController
@RequestMapping("/api")
public class TrainController {

	private static final Logger logger = LoggerFactory.getLogger(TrainController.class);

	@Autowired
	TrainService trainService;

	@Value("${server.port}")
	private int portNumber;

	@ApiOperation(value = "server port number")
	@GetMapping("/port")
	public int getPortNumber() {
		return portNumber;
	}

	
	@ApiOperation(value = "Search trains based on the certain conditions")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "404 error") })
	@PostMapping("/searchTrains")
	public List<Train> getAllTrains(@Valid @RequestBody TrainDto train) {
		logger.info("inside getTrainList method ===  {} ");
		return trainService.getAllTrains(train.getSource(), train.getDestination(),
				train.getDateOfJourney());
	}

	
	@ApiOperation(value = "Get TrainDetails based on the train number")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "404 error") })
	@GetMapping("/getTrainByNumber/{trainNumber}")
	public Train getTrainDetails(@PathVariable("trainNumber") Long trainNumber) {
		logger.info("inside getTrainDetails method ===  {} ");
		return trainService.getTrainDetails(trainNumber);
	}

	@PutMapping("/updateTrainSeats")
	public Void UpdateSeats(@RequestBody Train train) {
		logger.info("inside updateTrainSeats method ===  {} " + train);
		trainService.updateSeats(train);
		return null;

	}

}
