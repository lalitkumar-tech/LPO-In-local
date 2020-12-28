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


	



}
