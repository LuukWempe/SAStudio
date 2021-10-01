package com.stedin.HighVoltage.repositories;

import com.stedin.HighVoltage.model.users.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	AppUser findByUsername(String username);
	List<AppUser> findByRole(String role);
	AppUser findByFirstName(String firstName);
}