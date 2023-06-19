package com.kata.kataforfunjava.services;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class KataForFunService {

    public static final String KATA = "Kata";
    public static final String FOR = "For";
    public static final String FUN = "Fun";

    public String convertNumber(int inputNumber) {
        StringBuilder result = new StringBuilder();

        result.append(convertDivisibleInput(inputNumber, 3, KATA));
        result.append(convertDivisibleInput(inputNumber, 5, FOR));

        String intputAsString = String.valueOf(inputNumber);
        for (char c: intputAsString.toCharArray()) {
            result.append(convertFoundNumber(c));
        }
        return result.isEmpty() ? intputAsString : result.toString();
    }

    private String convertFoundNumber(char number) {
        return switch (number) {
            case '3' -> KATA;
            case '5' -> FOR;
            case '7' -> FUN;
            default -> "";
        };
    }

    private String convertDivisibleInput(int inputNumber, int divider, String pushedString) {
        if(inputNumber % divider == 0) {
            return pushedString;
        }
        return Strings.EMPTY;
    }
}
