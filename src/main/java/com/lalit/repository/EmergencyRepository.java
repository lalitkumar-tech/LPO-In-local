package com.lalit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lalit.domain.Emergency;
import com.lalit.domain.EmergencyContact;

@Repository
public interface EmergencyRepository extends JpaRepository<Emergency, Long>{

}
