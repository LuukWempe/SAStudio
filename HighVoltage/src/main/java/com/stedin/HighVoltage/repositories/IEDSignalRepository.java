package com.stedin.HighVoltage.repositories;


import com.stedin.HighVoltage.model.IEDSignal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IEDSignalRepository extends JpaRepository<IEDSignal, Long> {
	IEDSignal findByName(String name);
	IEDSignal findByIedSignalId(Long iedSignalId);
	Page<IEDSignal> findByIedId(Long iedId, Pageable pageable);
}