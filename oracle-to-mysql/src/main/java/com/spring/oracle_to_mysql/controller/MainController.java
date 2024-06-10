package com.spring.oracle_to_mysql.controller;

import com.spring.oracle_to_mysql.Service.MainService;
import com.spring.oracle_to_mysql.primary.entity.UserDetails;
import com.spring.oracle_to_mysql.primary.repository.PrimeRepository;
import com.spring.oracle_to_mysql.secondary.entity.User;
import com.spring.oracle_to_mysql.secondary.repository.SecondaryRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class MainController {

    private final MainService primeService;
    private final MainService secondaryService;

    public MainController(@Qualifier("prime") MainService primeService,
                          @Qualifier("second") MainService secondaryService) {
        this.primeService = primeService;
        this.secondaryService = secondaryService;
    }
    

    @PostMapping("/oracle-post")
    public String postToOracle(@RequestBody UserDetails userDetails,@Qualifier("prime") MainService service){

        return primeService.save(userDetails);

    }

    @PostMapping("/mysql-paste")
    public String copyFromOracleAndPastFromMysql(
            @RequestBody UserDetails userDetails){
        try {
            return secondaryService.save(userDetails);
        }catch (NoSuchElementException e){
            return e.getMessage();
        }

    }
}
