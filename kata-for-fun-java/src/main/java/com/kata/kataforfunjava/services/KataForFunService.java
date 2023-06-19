package com.kata.kataforfunjava.services;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

@Service
public class KataForFunService {
    public String convertNumber( int inputNumber) {
        String result = String.valueOf(inputNumber);
        if (inputNumber % 3 == 0 || result.contains("3")) {
            result = result.replace("3", "Kata");
        }
        return result;
    }
}
