package com.polstat.inventarisasi.service;

import com.polstat.inventarisasi.entity.Loan;
import java.util.Optional;

public interface LoanService {
    Loan createLoan(Loan loan);
    Optional<Loan> returnLoan(Long id, String returnDate);
    void deleteLoan(Long id);
}
