package com.lalit.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lalit.domain.Contact;
import com.lalit.enums.RelationType;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{

	List<Contact> findByUserIdAndRelationInAndDeletedFalse(Long userId, List<RelationType> asList);


	List<Contact> findByUserIdAndDeletedFalse(Long userId);


	Contact findByIdAndUserIdAndRelationInAndDeletedFalse(Long id, Long spouseId, List<RelationType> asList);


	int countByUserIdAndRelationInAndDeletedFalse(Long spouseId, List<RelationType> asList);


	List<Contact> findByUserIdAndEmailAndIsFiduciaryAndIsBeneficiaryAndDeletedFalse(Long userId, String email,
			Boolean isBeneficiary, Boolean isFiduciary);


	long countByUserIdAndIsEmergencyContactTrueAndDeletedFalse(Long spouseId);


	Contact findByIdAndUserIdAndDeletedFalse(Long contactId, Long userId);


	List<Contact> findByUserIdAndFirstNameAndLastNameAndRelationAndDeletedFalse(Long userId, String firstName,
			String lastName, RelationType relation);


	



}
