package com.lalit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lalit.domain.EmergencyContact;
import com.lalit.enums.EmergencyContactFor;

@Repository
public interface EmergencyContactRepository extends JpaRepository<EmergencyContact, Long>{

	

	Optional<EmergencyContact> findByUserIdAndEmergencyContactIdAndEmergencyContactForAndDeletedFalse(Long userId,
			Long emergencyContactId, EmergencyContactFor emergencyContactFor);
}
