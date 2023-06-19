package com.kata.kataforfunjava.controllers;

import com.kata.kataforfunjava.services.KataForFunService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kata-for-fun")
public class KataForFunController {
    private final KataForFunService kataForFunService;
    public KataForFunController(KataForFunService kataForFunService) {
        this.kataForFunService = kataForFunService;
    }
    @GetMapping("/{inputNumber}")
    @CrossOrigin({"http://localhost:8080", "http://localhost:4200"})
    ResultDto convertNumber(@PathVariable(name = "inputNumber") int inputNumber) {
        return new ResultDto(kataForFunService.convertNumber(inputNumber));
    }

    record  ResultDto(String result){}
}
