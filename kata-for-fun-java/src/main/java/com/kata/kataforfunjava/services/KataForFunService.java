package com.kata.kataforfunjava.services;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static com.kata.kataforfunjava.models.KataForFunModel.DivisiblePrimitive;
import static com.kata.kataforfunjava.models.KataForFunModel.MatchablePrimitive;
import static com.kata.kataforfunjava.models.KataForFunModel.Primitive3;
import static com.kata.kataforfunjava.models.KataForFunModel.Primitive5;
import static com.kata.kataforfunjava.models.KataForFunModel.Primitive7;

@Service
public class KataForFunService {

    private final List<DivisiblePrimitive> divisiblePrimitives;
    private final List<MatchablePrimitive> matchPrimitives;

    public KataForFunService() {
        divisiblePrimitives = Arrays.asList(
                new Primitive3(),
                new Primitive5()
        );
        matchPrimitives = Arrays.asList(
                new Primitive3(),
                new Primitive5(),
                new Primitive7()
        );
    }

    public String convertNumber(int inputNumber) {
        StringBuilder result = new StringBuilder();

        result.append(getDivisibleResults(inputNumber));
        result.append(getMatchResults(inputNumber));

        return result.isEmpty() ? String.valueOf(inputNumber) : result.toString();
    }

    private String getDivisibleResults(int inputNumber) {
        StringBuilder result = new StringBuilder();
        for (DivisiblePrimitive primitive : divisiblePrimitives) {
            result.append(primitive.getDivisibleResult(inputNumber));
        }
        return result.toString();
    }

    private String getMatchResults(int inputNumber) {
        StringBuilder result = new StringBuilder();
        String inputAsString = String.valueOf(inputNumber);
        for (char c : inputAsString.toCharArray()) {
            String matchResult = matchPrimitives.stream()
                    .filter(p -> p.match(c))
                    .map(MatchablePrimitive::getTypeName)
                    .findFirst()
                    .orElse("");
            result.append(matchResult);
        }
        return result.toString();
    }
}
