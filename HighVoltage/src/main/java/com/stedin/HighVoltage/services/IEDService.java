package com.stedin.HighVoltage.services;

import com.stedin.HighVoltage.repositories.IEDRepository;
import com.stedin.HighVoltage.repositories.IEDSignalRepository;
import com.stedin.HighVoltage.model.ied.Configuration;
import com.stedin.HighVoltage.model.ied.IED;
import com.stedin.HighVoltage.model.ied.IEDSignal;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class IEDService {
	
	@Autowired
	private IEDSignalRepository iedSignalRepository;

	@Autowired
	private IEDRepository iedRepository;

	
	public List<IEDSignal> getSignalsById(int length,Long id){
		Optional<IED> ied = iedRepository.findById(id);
        Page<IEDSignal> iedSignals = iedSignalRepository.findByIed(ied, PageRequest.of(0,length, Sort.by("signalId").ascending()));
        return iedSignals.getContent();
    }
	
	public void addIED(Configuration configuration, String iedName, Long stationID, String voltage) {
		IED ied = new IED(configuration, iedName, stationID, voltage);
		iedRepository.save(ied);
	}
	
	public void addIED(String iedName, Long stationID,String voltage) {
		IED ied = new IED(iedName, stationID, voltage);
		iedRepository.save(ied);
	}
}