package com.stedin.HighVoltage.repositories;


import com.stedin.HighVoltage.model.IEDSignal;
import com.stedin.HighVoltage.model.Station;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IEDSignalRepository extends JpaRepository<IEDSignal, Long> {
	IEDSignal findBySignalName(String signalName);
	IEDSignal findBySignalID(Long signalID);
	Page<Station> findAllByIEDID(Long iedID, Pageable pageable);

}