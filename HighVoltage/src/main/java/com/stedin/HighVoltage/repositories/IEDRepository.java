package com.stedin.HighVoltage.repositories;

import com.stedin.HighVoltage.model.IED;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IEDRepository extends JpaRepository<IED, Long> {
	IED findByIedID(Long iedID);
	Page<IED> findAllByStationID(Long stationID, Pageable pageable);
}