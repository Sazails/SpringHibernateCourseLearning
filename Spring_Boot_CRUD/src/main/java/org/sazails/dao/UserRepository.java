package org.sazails.dao;

import org.sazails.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository gives all the CRUD methods
public interface UserRepository extends JpaRepository<User, Integer> { }
