package com.polstat.inventarisasi.service;

import com.polstat.inventarisasi.dto.BarangDto;

import java.util.List;

public interface BarangService {

    public void createBarang(BarangDto barangDto);
    public List<BarangDto> getBarangs();
    public List<BarangDto> searchBarangs(String nama, String pj);
}
