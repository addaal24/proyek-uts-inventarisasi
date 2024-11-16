package com.polstat.inventarisasi.repository;

import com.polstat.inventarisasi.entity.Barang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BarangRepository extends JpaRepository<Barang, Long> {
    @Query("SELECT b FROM Barang b WHERE " +
            "(:nama IS NULL OR LOWER(b.nama) LIKE LOWER(CONCAT('%', :nama, '%'))) AND " +
            "(:pj IS NULL OR LOWER(b.pj) LIKE LOWER(CONCAT('%', :pj, '%')))")
    List<Barang> searchBarangs(String nama, String pj);

}
