package com.bank.publicinfo.controller;

import com.bank.publicinfo.dto.AtmDTO;
import com.bank.publicinfo.entity.Atm;
import com.bank.publicinfo.service.AtmService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/atm")
public class AtmController {
    private final Logger logger = LoggerFactory.getLogger(AtmController.class);
    private final AtmService atmService;
    private final ModelMapper modelMapper;

    @Autowired
    public AtmController(AtmService atmService, ModelMapper modelMapper) {
        this.atmService = atmService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<AtmDTO> getAllAtms() {
        logger.info("Received request to get all atms.");
        List<Atm> atms = atmService.getAllAtms();
        logger.info("Returning {} atms.", atms.size());
        return atms.stream().map(this::convertToAtmDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AtmDTO getAtmById(@PathVariable("id") Long id) {
        logger.info("Received request to get atm with id {}.", id);
        Atm atm = atmService.getAtmById(id);
        logger.info("Returning atm with id {}.", id);
        return convertToAtmDTO(atm);
    }

    @PostMapping
    public ResponseEntity<AtmDTO> createAtm(@RequestBody AtmDTO atmDTO) {
        logger.info("Received request to create atm with data {}", atmDTO);
        atmService.createAtm(convertToAtm(atmDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<AtmDTO> updateAtm(@RequestBody AtmDTO atmDTO) {
        logger.info("Received request to update atm with id {} and data {}", atmDTO);
        atmService.updateAtm(convertToAtm(atmDTO));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAtm(@PathVariable("id") Long id) {
        logger.info("Received request to delete atm with id {}", id);
        atmService.deleteAtm(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private Atm convertToAtm(AtmDTO atmDTO) {
        return modelMapper.map(atmDTO, Atm.class);
    }

    private AtmDTO convertToAtmDTO(Atm atm) {
        return modelMapper.map(atm, AtmDTO.class);
    }
}
