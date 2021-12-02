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

	public List<IEDSignal> getSignalsByIedId(int length,Long id){
        Page<IEDSignal> iedSignals = iedSignalRepository.findByIedId(id, PageRequest.of(0,length, Sort.by("signalID").ascending()));
        return iedSignals.getContent();
    }
}