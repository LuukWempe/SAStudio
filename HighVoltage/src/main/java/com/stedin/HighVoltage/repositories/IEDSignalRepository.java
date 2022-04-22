package com.stedin.HighVoltage.repositories;


import com.stedin.HighVoltage.model.ied.IED;
import com.stedin.HighVoltage.model.ied.IEDSignal;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IEDSignalRepository extends JpaRepository<IEDSignal, Long> {
	IEDSignal findByName(String name);
	IEDSignal findBySignalId(Long signalId);
	Page<IEDSignal> findByIed(Optional<IED> ied, Pageable pageable);
}