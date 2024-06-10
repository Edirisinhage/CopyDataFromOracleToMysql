package com.spring.oracle_to_mysql.secondary.repository;

import com.spring.oracle_to_mysql.secondary.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecondaryRepository extends JpaRepository<User,Long> {

}