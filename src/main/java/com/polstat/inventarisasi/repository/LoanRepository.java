package com.polstat.inventarisasi.repository;

import com.polstat.inventarisasi.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
