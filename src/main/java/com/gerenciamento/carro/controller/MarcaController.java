package com.gerenciamento.carro.controller;

import com.gerenciamento.carro.service.MarcaService;
import com.gerenciamento.carro.view.Marca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class MarcaController {
    private final MarcaService marcaService;

    @Autowired
    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }


    @PostMapping
    public ResponseEntity<?> cadastraHospede(@RequestBody Marca marca) throws Exception {
        try {
            Marca marcaSaved = marcaService.cadastraMarca(marca);
            return new ResponseEntity<>(marcaSaved, null, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @GetMapping
    public ResponseEntity<?> listAll() {

        List<Marca> marcaList = marcaService.ListAllMarca();

        if (!marcaList.isEmpty()) {
            return new ResponseEntity<>(marcaList, null, HttpStatus.OK);
        }
        return new ResponseEntity<>(marcaList, null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Marca>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(marcaService.findOne(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Marca marca) {
        return ResponseEntity.ok(marcaService.update(marca));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@RequestBody Marca marca) {
        return ResponseEntity.ok(null);
    }
}
