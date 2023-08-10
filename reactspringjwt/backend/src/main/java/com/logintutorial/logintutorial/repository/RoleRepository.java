package com.logintutorial.logintutorial.repository;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.logintutorial.logintutorial.models.Role;
import com.logintutorial.logintutorial.models.ERole;


public interface RoleRepository extends MongoRepository<Role, String> {
  Optional<Role> findByName(ERole name);
}