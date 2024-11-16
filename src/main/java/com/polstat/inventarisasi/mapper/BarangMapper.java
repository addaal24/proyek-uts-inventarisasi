package com.polstat.inventarisasi.mapper;

import com.polstat.inventarisasi.dto.BarangDto;
import com.polstat.inventarisasi.entity.Barang;

public class BarangMapper {
    public static Barang mapToBarang(BarangDto barangDto) {
        return Barang.builder()
                .id(barangDto.getId())
                .nama(barangDto.getNama())
                .description(barangDto.getDescription())
                .pj(barangDto.getPj())
                .build();
    }

    public static BarangDto mapToBarangDto(Barang barang) {
        return BarangDto.builder()
                .id(barang.getId())
                .nama(barang.getNama())
                .description(barang.getDescription())
                .pj(barang.getPj())
                .build();
    }
}
