package com.stedin.HighVoltage.services;

import com.stedin.HighVoltage.repositories.IEDSignalRepository;
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

	public List<IEDSignal> getSignalsByIEDID(int length,Long iedID){
        Page<IEDSignal> iedSignals = iedSignalRepository.findByIedID(iedID, PageRequest.of(0,length, Sort.by("signalID").ascending()));
        return iedSignals.getContent();
    }
}