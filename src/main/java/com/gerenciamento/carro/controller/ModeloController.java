package com.gerenciamento.carro.controller;

import com.gerenciamento.carro.service.ModeloService;
import com.gerenciamento.carro.view.Modelo;
import com.gerenciamento.carro.view.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/modelos")
public class ModeloController {
    private final ModeloService modeloService;

    @Autowired
    public ModeloController(ModeloService modeloService) {
        this.modeloService = modeloService;
    }

    @PostMapping
    public ResponseEntity<?> cadastraModelo(@RequestBody Modelo modelo) throws Exception {
        try {
            Modelo cadastraModelo = modeloService.cadastraModelo(modelo);
            return new ResponseEntity<>(cadastraModelo, null, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @GetMapping
    public ResponseEntity<?> listAll() {

        List<Modelo> modeloList = modeloService.ListAllModelo();

        if (!modeloList.isEmpty()) {
            return new ResponseEntity<>(modeloList, null, HttpStatus.OK);
        }
        return new ResponseEntity<>(modeloList, null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Modelo>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(modeloService.findOne(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Modelo modelo) {
        return ResponseEntity.ok(modeloService.update(modelo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@RequestBody Modelo modelo) {
        return ResponseEntity.ok(null);
    }
}
