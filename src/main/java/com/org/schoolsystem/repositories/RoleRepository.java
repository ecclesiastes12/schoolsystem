package com.org.schoolsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.schoolsystem.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
