package com.stedin.HighVoltage.services;

import com.stedin.HighVoltage.repositories.IEDRepository;
import com.stedin.HighVoltage.repositories.IEDSignalRepository;
import com.stedin.HighVoltage.model.IED;
import com.stedin.HighVoltage.model.IEDSignal;
import java.util.List;
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

	
	public List<IEDSignal> getSignalsByIedId(int length,Long iedId){
		IED ied = iedRepository.findByIedId(iedId);
        Page<IEDSignal> iedSignals = iedSignalRepository.findByIed(ied, PageRequest.of(0,length, Sort.by("signalId").ascending()));
        return iedSignals.getContent();
    }
	
	public void addIED(String communication, String gateway, String ip, String iedName, Long stationID, String subnet, String voltage) {
		IED ied = new IED(communication, gateway, ip, iedName, stationID, subnet, voltage);
		iedRepository.save(ied);
	}
}