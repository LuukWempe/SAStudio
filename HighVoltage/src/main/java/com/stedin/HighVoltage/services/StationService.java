package com.stedin.HighVoltage.services;

import com.stedin.HighVoltage.repositories.IEDRepository;
import com.stedin.HighVoltage.repositories.StationRepository;
import com.stedin.HighVoltage.model.IED;
import com.stedin.HighVoltage.model.Station;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class StationService {

	@Autowired
	private StationRepository stationRepository;
	
	@Autowired
	private IEDRepository iedRepository;
	

	public List<Station> getTopStations(int length){
		Page<Station> topStations = stationRepository.findByStationStatus(true, PageRequest.of(0,length, Sort.by("stationName").descending()));
        return topStations.getContent();
	}	
	
	public List<IED> getStationIed(int length, Station station){
        Page<IED> stationIEDs = iedRepository.findAllByStationId(station.getStationID(), PageRequest.of(0,length, Sort.by("iedIP").ascending()));
        return stationIEDs.getContent();
    }
	
	public void addStation(String stationName, Boolean stationStatus, String stationAddress, List<IED> iedList) {
		Station station = new Station(stationName, stationStatus, stationAddress);
		stationRepository.save(station);
	}
	
	public IED getStationIedByIedId(Long iedId) {
		IED ied = iedRepository.findByIedId(iedId);
		return ied;
	}

	public Station getStationByIedId(Long iedId) {
		IED ied = iedRepository.findByIedId(iedId);
		Station station = stationRepository.findByStationId(ied.getStationID());
		return station;
	}
}