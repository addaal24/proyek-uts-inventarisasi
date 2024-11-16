package com.polstat.inventarisasi.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long barangId;

    @Column(nullable = false)
    private String borrowerName;

    @Column(nullable = false)
    private String loanDate;

    @Column(nullable = true)
    private String returnDate;
}
