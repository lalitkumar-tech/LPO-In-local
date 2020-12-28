package com.lalit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lalit.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findByRoleAndDeletedFalse(String clientRole);

}
