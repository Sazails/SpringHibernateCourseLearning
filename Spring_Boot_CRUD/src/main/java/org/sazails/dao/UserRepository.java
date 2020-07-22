package org.sazails.dao;

import org.sazails.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// JpaRepository gives all the CRUD methods
//@RepositoryRestResource(path = "members") this replaces the default "/users" to "/members"
public interface UserRepository extends JpaRepository<User, Integer> { }
