package com.stedin.HighVoltage.repositories;


import com.stedin.HighVoltage.model.IEDSignal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IEDSignalRepository extends JpaRepository<IEDSignal, Long> {
	IEDSignal findBySignalName(String signalName);
	IEDSignal findBySignalID(Long signalID);
	Page<IEDSignal> findByIedID(Long iedID, Pageable pageable);
}