package org.sazails.dao;

import org.sazails.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// JpaRepository gives all the CRUD methods
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAllByOrderByLastNameAsc();
}
