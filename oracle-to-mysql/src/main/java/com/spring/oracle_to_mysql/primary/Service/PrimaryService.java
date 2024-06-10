package com.spring.oracle_to_mysql.primary.Service;

import com.spring.oracle_to_mysql.Service.MainService;
import com.spring.oracle_to_mysql.primary.entity.UserDetails;
import com.spring.oracle_to_mysql.primary.repository.PrimeRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service("prime")
public class PrimaryService implements MainService {

    private PrimeRepository primeRepository;

    public PrimaryService(PrimeRepository primeRepository) {
        this.primeRepository = primeRepository;
    }
    @Override
    public String save(UserDetails userDetails){
        primeRepository.save(userDetails);
        return "Successfully Saved";
    }
}
