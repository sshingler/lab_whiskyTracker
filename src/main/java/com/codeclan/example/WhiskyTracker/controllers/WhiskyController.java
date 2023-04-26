package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskies/year")
    public ResponseEntity<List<Whisky>> getWhiskyByYear(@RequestParam(name = "year") int year){
        return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/{distillery_id}")
    public ResponseEntity<List<Whisky>> getWhiskyByDistilleryAndAge(
            @PathVariable(name = "distillery_id") Long distillery_id,
            @RequestParam(name = "age") int age){
        return new ResponseEntity<>(whiskyRepository.findByDistilleryIdAndAge(distillery_id, age), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/region")
    public ResponseEntity<List<Whisky>> getWhiskyByRegion(@RequestParam(name = "region") String region){
        return new ResponseEntity<>(whiskyRepository.findByDistilleryRegionIgnoreCase(region), HttpStatus.OK);
    }

}
