package com.polstat.inventarisasi.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.polstat.inventarisasi.dto.BarangDto;
import com.polstat.inventarisasi.entity.Barang;
import com.polstat.inventarisasi.rpc.JsonRpcRequest;
import com.polstat.inventarisasi.rpc.JsonRpcResponse;
import com.polstat.inventarisasi.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JsonRpcController {
    @Autowired
    private BarangService barangService;

    @PostMapping("/jsonrpc")
    public ResponseEntity<Object> handleJsonRpcRequest(@RequestBody JsonRpcRequest request) {
        try {
            String method = request.getMethod();
            JsonNode params = request.getParams();
            System.out.println("Method: " +method);
            switch (method) {
                case "createBarang":
                    String nama = params.get("nama").asText();
                    String pj = params.get("pj").asText();
                    String description = params.get("description").asText();
                    BarangDto barang = BarangDto.builder()
                            .nama(nama)
                            .description(description)
                            .pj(pj)
                            .build();

                    barangService.createBarang(barang);
                    return ResponseEntity.ok(new JsonRpcResponse("created", request.getId()));
                case "getBarangs":
                    List<BarangDto> barangs = barangService.getBarangs();
                    return ResponseEntity.ok(new JsonRpcResponse(barangs, request.getId()));
                case "searchBarang":
                    String searchNama = params.get("Nama").asText();
                    String searchPj = params.get("pj").asText();

                    List<BarangDto> searchResults = barangService.searchBarangs(searchNama, searchPj);
                    return ResponseEntity.ok(new JsonRpcResponse(searchResults, request.getId()));
                default:
                    return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
