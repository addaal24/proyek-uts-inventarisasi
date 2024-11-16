package com.polstat.inventarisasi.service;

import com.polstat.inventarisasi.dto.BarangDto;
import com.polstat.inventarisasi.entity.Barang;
import com.polstat.inventarisasi.mapper.BarangMapper;
import com.polstat.inventarisasi.repository.BarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BarangServiceImpl implements BarangService {
    @Autowired
    private BarangRepository barangRepository;

    @Override
    public void createBarang(BarangDto barangDto) {
        barangRepository.save(BarangMapper.mapToBarang(barangDto));
    }

    @Override
    public List<BarangDto> getBarangs() {
        List<Barang> barangs = barangRepository.findAll();
        List<BarangDto> barangDtos = barangs.stream()
                .map((product) -> (BarangMapper.mapToBarangDto(product)))
                .collect(Collectors.toList());
        return barangDtos;
    }

    public List<BarangDto> searchBarangs(String nama, String pj) {
        List<Barang> barangs = barangRepository.searchBarangs(nama, pj);
        return barangs.stream()
                .map(BarangMapper::mapToBarangDto)
                .collect(Collectors.toList());
    }
}
