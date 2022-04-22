package com.stedin.HighVoltage.repositories;

import com.stedin.HighVoltage.model.ied.IED;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IEDRepository extends JpaRepository<IED, Long> {
	IED findByIedId(Long iedId);
	IED findByName(String iedName);
	Page<IED> findAllByStationId(Long stationId, Pageable pageable);
}