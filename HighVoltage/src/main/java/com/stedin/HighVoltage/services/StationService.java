package com.stedin.HighVoltage.services;

import com.stedin.HighVoltage.repositories.IEDRepository;
import com.stedin.HighVoltage.repositories.StationRepository;
import com.stedin.HighVoltage.model.IED;
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
	
	@Autowired
	private IEDRepository iedRepository;
	

	public List<Station> getTopStations(int length){
		Page<Station> topBootcamps = stationRepository.findAllByStationStatus(true, PageRequest.of(0,length, Sort.by("stationName").descending()));
        return topBootcamps.getContent();
	}	
	
	public List<IED> getStationIEDs(int length, Station station){
        Page<IED> stationIEDs = iedRepository.findAllByStationID(station.getStationID(), PageRequest.of(0,length, Sort.by("iedIP").ascending()));
        return stationIEDs.getContent();
    }
	
	public void addStation(String stationName, Boolean stationStatus, String stationAddress, List<IED> iedList) {
		Station station = new Station(stationName, stationStatus, stationAddress);
		stationRepository.save(station);
	}

	public IED getStationIEDByIEDID(Long iedID) {
		IED ied = iedRepository.findByIedID(iedID);
		return ied;
	}

	public Station getStationByIEDID(Long iedID) {
		IED ied = iedRepository.findByIedID(iedID);
		Station station = stationRepository.findByStationID(ied.getStationID());
		return station;
	}
}