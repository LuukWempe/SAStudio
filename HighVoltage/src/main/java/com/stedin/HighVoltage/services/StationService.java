package com.stedin.HighVoltage.services;

import com.stedin.HighVoltage.repositories.StationRepository;
import com.stedin.HighVoltage.model.Station;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class StationService {

	@Autowired
	private StationRepository stationRepository;
	

	public List<Station> getTopStations(int length){
		Page<Station> topBootcamps = stationRepository.findAllByStationStatus(true, PageRequest.of(0,length, Sort.by("endDate").descending()));
        return topBootcamps.getContent();
	}	
}