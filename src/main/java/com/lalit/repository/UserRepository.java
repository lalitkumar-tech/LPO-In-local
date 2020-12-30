package com.lalit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lalit.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByIdAndEnabledTrue(Long userId);

	Optional<User> findByIdAndDeletedFalse(Long id);

}
