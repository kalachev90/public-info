package com.bank.publicinfo.controller;

import com.bank.publicinfo.dto.BranchDTO;
import com.bank.publicinfo.entity.Branch;
import com.bank.publicinfo.service.BranchService;
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
@RequestMapping("/branch")
public class BranchController {
    private final Logger logger = LoggerFactory.getLogger(BranchController.class);
    private final BranchService branchService;
    private final ModelMapper modelMapper;

    @Autowired
    public BranchController(BranchService branchService, ModelMapper modelMapper) {
        this.branchService = branchService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<BranchDTO> getAllBranchs() {
        logger.info("Received request to get all branchs.");
        List<Branch> branches = branchService.getAllBranch();
        logger.info("Returning {} branchs.", branches.size());
        return branches.stream().map(this::convertToBranchDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BranchDTO getBranchById(@PathVariable("id") Long id) {
        logger.info("Received request to get branch with id {}.", id);
        Branch branch = branchService.getBranchById(id);
        logger.info("Returning branch with id {}.", id);
        return convertToBranchDTO(branch);
    }

    @PostMapping
    public ResponseEntity<BranchDTO> createBranch(@RequestBody BranchDTO branchDTO) {
        logger.info("Received request to create branch with data {}", branchDTO);
        branchService.createBranch(convertToBranch(branchDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<BranchDTO> updateBranch(@RequestBody BranchDTO branchDTO) {
        logger.info("Received request to update branch with id {} and data {}", branchDTO);
        branchService.updateBranch(convertToBranch(branchDTO));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteBranch(@PathVariable("id") Long id) {
        logger.info("Received request to delete branch with id {}", id);
        branchService.deleteBranch(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    private Branch convertToBranch(BranchDTO branchDTO) {
        return modelMapper.map(branchDTO, Branch.class);
    }

    private BranchDTO convertToBranchDTO(Branch branch) {
        return modelMapper.map(branch, BranchDTO.class);
    }
}
