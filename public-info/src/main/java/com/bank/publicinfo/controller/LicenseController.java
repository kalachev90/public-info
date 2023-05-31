package com.bank.publicinfo.controller;

import com.bank.publicinfo.dto.LicenseDTO;
import com.bank.publicinfo.entity.License;
import com.bank.publicinfo.service.LicenseService;
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
@RequestMapping("/license")
public class LicenseController {
    private final Logger logger = LoggerFactory.getLogger(LicenseController.class);
    private final LicenseService licenseService;
    private final ModelMapper modelMapper;

    @Autowired
    public LicenseController(LicenseService licenseService, ModelMapper modelMapper) {
        this.licenseService = licenseService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<LicenseDTO> getAllLicenses() {
        logger.info("Received request to get all licenses.");
        List<License> licenses = licenseService.getAllLicense();
        logger.info("Returning {} licenses.", licenses.size());
        return licenses.stream().map(this::convertToLicenseDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public LicenseDTO getLicenseById(@PathVariable("id") Long id) {
        logger.info("Received request to get license with id {}.", id);
        License license = licenseService.getLicenseById(id);
        logger.info("Returning license with id {}.", id);
        return convertToLicenseDTO(license);
    }

    @PostMapping
    public ResponseEntity<LicenseDTO> createLicense(@RequestBody LicenseDTO licenseDTO) {
        logger.info("Received request to create license with data {}", licenseDTO);
        licenseService.createLicense(convertToLicense(licenseDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<LicenseDTO> updateLicense(@RequestBody LicenseDTO licenseDTO) {
        logger.info("Received request to update license with id {} and data {}", licenseDTO);
        licenseService.updateLicense(convertToLicense(licenseDTO));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteLicense(@PathVariable("id") Long id) {
        logger.info("Received request to delete license with id {}", id);
        licenseService.deleteLicense(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private License convertToLicense(LicenseDTO licenseDTO) {
        return modelMapper.map(licenseDTO, License.class);
    }

    private LicenseDTO convertToLicenseDTO(License license) {
        return modelMapper.map(license, LicenseDTO.class);
    }
}
