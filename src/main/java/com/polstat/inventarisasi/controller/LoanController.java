package com.polstat.inventarisasi.controller;

import com.polstat.inventarisasi.entity.Loan;
import com.polstat.inventarisasi.service.LoanService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan) {
        Loan createdLoan = loanService.createLoan(loan);
        return ResponseEntity.ok(createdLoan);
    }

    @PutMapping("/{id}/return")
    public ResponseEntity<Optional<Loan>> returnLoan(
        @PathVariable Long id,
        @RequestBody Map<String, String> requestBody) {
        String returnDate = requestBody.get("returnDate");
        Optional<Loan> loan = loanService.returnLoan(id, returnDate);
        return ResponseEntity.ok(loan);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLoan(@PathVariable Long id) {
        loanService.deleteLoan(id);
        return ResponseEntity.ok("Loan deleted successfully");
    }
}
