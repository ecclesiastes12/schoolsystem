package com.org.schoolsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.schoolsystem.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
