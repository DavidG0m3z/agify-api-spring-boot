package com.davidgomez.agifyapi.controller;

import com.davidgomez.agifyapi.model.AgifyResponse;
import com.davidgomez.agifyapi.service.AgifyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/age")
@AllArgsConstructor
public class agifyController {

    private final AgifyService AgifyService;

    @GetMapping
    public AgifyResponse getAgifyPrediction(@RequestParam String name){
        return AgifyService.predictAge(name);
    }
}
