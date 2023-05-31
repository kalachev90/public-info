package com.bank.publicinfo.controller;

import com.bank.publicinfo.dto.BankDetailsDTO;
import com.bank.publicinfo.entity.BankDetails;
import com.bank.publicinfo.service.BankDetailsService;
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
@RequestMapping("/bank_details")
public class BankDetailsController {
    private final Logger logger = LoggerFactory.getLogger(BankDetailsController.class);
    private final BankDetailsService bankDetailsService;
    private final ModelMapper modelMapper;

    @Autowired
    public BankDetailsController(BankDetailsService bankDetailsService, ModelMapper modelMapper) {
        this.bankDetailsService = bankDetailsService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<BankDetailsDTO> getAllBankDetails() {
        logger.info("Received request to get all bank_details.");
        List<BankDetails> bankDetails = bankDetailsService.getAllBankDetails();
        logger.info("Returning {} bank_details.", bankDetails.size());
        return bankDetails.stream().map(this::convertToBankDetailsDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BankDetailsDTO getCertificateById(@PathVariable("id") Long id) {
        logger.info("Received request to get bank_details with id {}.", id);
        BankDetails bankDetails = bankDetailsService.getBankDetailsById(id);
        logger.info("Returning bank_details with id {}.", id);
        return convertToBankDetailsDTO(bankDetails);
    }

    @PostMapping
    public ResponseEntity<BankDetailsDTO> createBankDetails(@RequestBody BankDetailsDTO bankDetailsDTO) {
        logger.info("Received request to create bank_details with data {}", bankDetailsDTO);
        bankDetailsService.createBankDetails(convertToBankDetails(bankDetailsDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<BankDetailsDTO> updateBankDetails(@RequestBody BankDetailsDTO bankDetailsDTO) {
        logger.info("Received request to update bank_details with id {} and data {}", bankDetailsDTO);
        bankDetailsService.updateBankDetails(convertToBankDetails(bankDetailsDTO));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteBankDetails(@PathVariable("id") Long id) {
        logger.info("Received request to delete bank_details with id {}", id);
        bankDetailsService.deleteBankDetails(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private BankDetails convertToBankDetails(BankDetailsDTO bankDetailsDTO) {
        return modelMapper.map(bankDetailsDTO, BankDetails.class);
    }

    private BankDetailsDTO convertToBankDetailsDTO(BankDetails bankDetails) {
        return modelMapper.map(bankDetails, BankDetailsDTO.class);
    }
}
