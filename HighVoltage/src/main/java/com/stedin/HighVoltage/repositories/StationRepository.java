package com.stedin.HighVoltage.repositories;

import com.stedin.HighVoltage.model.Station;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StationRepository extends JpaRepository<Station, Long> {
	Station findByStationName(String stationName);
	Station findByStationID(Long stationID);
	Page<Station> findAllByStationStatus(boolean stationStatus, Pageable pageable);

}