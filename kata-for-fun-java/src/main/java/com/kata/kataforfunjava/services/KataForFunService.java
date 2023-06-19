package com.kata.kataforfunjava.services;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

@Service
public class KataForFunService {
    public String convertNumber( int inputNumber) {
        StringBuilder result = new StringBuilder();
        if (inputNumber % 3 == 0) {
            result.append("Kata");
        }
        for (char c: String.valueOf(inputNumber).toCharArray()) {
            if ('3' == c) {
                result.append("Kata");
            }
        }
        return result.toString();
    }
}
