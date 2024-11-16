package com.polstat.inventarisasi.exception;

public class BarangAlreadyLoanedException extends RuntimeException {
    public BarangAlreadyLoanedException(String message) {
        super(message);
    }
}
