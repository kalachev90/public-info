package com.bank.publicinfo.controller;

import com.bank.publicinfo.dto.CertificateDTO;
import com.bank.publicinfo.entity.Certificate;
import com.bank.publicinfo.service.CertificateService;
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
@RequestMapping("/certificate")
public class CertificateController {
    private final Logger logger = LoggerFactory.getLogger(CertificateController.class);
    private final CertificateService certificateService;
    private final ModelMapper modelMapper;

    @Autowired
    public CertificateController(CertificateService certificateService, ModelMapper modelMapper) {
        this.certificateService = certificateService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<CertificateDTO> getAllCertificates() {
        logger.info("Received request to get all certificates.");
        List<Certificate> certificates = certificateService.getAllCertificate();
        logger.info("Returning {} certificates.", certificates.size());
        return certificates.stream().map(this::convertToCertificateDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CertificateDTO getCertificateById(@PathVariable("id") Long id) {
        logger.info("Received request to get certificate with id {}.", id);
        Certificate certificate = certificateService.getCertificateById(id);
        logger.info("Returning certificate with id {}.", id);
        return convertToCertificateDTO(certificate);
    }

    @PostMapping
    public ResponseEntity<CertificateDTO> createCertificate(@RequestBody CertificateDTO certificateDTO) {
        logger.info("Received request to create certificate with data {}", certificateDTO);
        certificateService.createCertificate(convertToCertificate(certificateDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CertificateDTO> updateCertificate(@RequestBody CertificateDTO certificateDTO) {
        logger.info("Received request to update certificate with id {} and data {}", certificateDTO);
        certificateService.updateCertificate(convertToCertificate(certificateDTO));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCertificate(@PathVariable("id") Long id) {
        logger.info("Received request to delete certificate with id {}", id);
        certificateService.deleteCertificate(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private Certificate convertToCertificate(CertificateDTO certificateDTO) {
        return modelMapper.map(certificateDTO, Certificate.class);
    }

    private CertificateDTO convertToCertificateDTO(Certificate certificate) {
        return modelMapper.map(certificate, CertificateDTO.class);
    }
}
