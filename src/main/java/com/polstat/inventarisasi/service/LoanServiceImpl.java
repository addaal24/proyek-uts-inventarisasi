package com.polstat.inventarisasi.service;

import com.polstat.inventarisasi.entity.Loan;
import com.polstat.inventarisasi.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Override
    public Loan createLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    @Override
    public Optional<Loan> returnLoan(Long id, String returnDate) {
        Optional<Loan> loan = loanRepository.findById(id);
        loan.ifPresent(l -> {
            l.setReturnDate(returnDate);
            loanRepository.save(l);
        });
        return loan;
    }

    @Override
    public void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }
}
