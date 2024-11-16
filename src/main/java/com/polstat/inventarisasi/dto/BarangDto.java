package com.polstat.inventarisasi.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BarangDto {
    private Long id;

    @NotEmpty(message = "judul buku wajib diisi")
    private String nama;

    @NotNull(message = "Penulis buku wajib diisi")
    private String pj;

    private String description;
}