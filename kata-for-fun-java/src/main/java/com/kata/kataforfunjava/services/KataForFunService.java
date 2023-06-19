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
        if (inputNumber % 5 == 0) {
            result.append("For");
        }
        for (char c: String.valueOf(inputNumber).toCharArray()) {
            if ('3' == c) {
                result.append("Kata");
            }
            if ('5' == c) {
                result.append("For");
            }
        }
        return result.toString();
    }
}
