package com.spring.oracle_to_mysql.primary.repository;

import com.spring.oracle_to_mysql.primary.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface PrimeRepository extends JpaRepository<UserDetails,Long> {

}
