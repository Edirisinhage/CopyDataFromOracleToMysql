package com.spring.oracle_to_mysql.secondary.Service;

import com.spring.oracle_to_mysql.Service.MainService;
import com.spring.oracle_to_mysql.primary.entity.UserDetails;
import com.spring.oracle_to_mysql.primary.repository.PrimeRepository;
import com.spring.oracle_to_mysql.secondary.entity.User;
import com.spring.oracle_to_mysql.secondary.repository.SecondaryRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service("second")
public class SecondaryService implements MainService {

    private SecondaryRepository secondaryRepository;

    private PrimeRepository primeRepository;

    public SecondaryService(SecondaryRepository secondaryRepository, PrimeRepository primeRepository) {
        this.secondaryRepository = secondaryRepository;
        this.primeRepository = primeRepository;
    }


    @Override
    public String save(UserDetails userDetails){
        if(primeRepository.findById(userDetails.getId()).isPresent()){
            UserDetails oracleUser=primeRepository.findById(userDetails.getId()).get();
            User mysqlUser=new User();
            mysqlUser.setName(oracleUser.getName());
            secondaryRepository.save(mysqlUser);

            return "Successfully copied from oracle to mysql";
        }
        throw new NoSuchElementException("No such a User in Oracle");
    }
}
