package com.gerenciamento.carro.controller;

import com.gerenciamento.carro.service.VeiculoService;
import com.gerenciamento.carro.view.Marca;
import com.gerenciamento.carro.view.Modelo;
import com.gerenciamento.carro.view.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    @Autowired
    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @PostMapping
    public ResponseEntity<?> cadastraVeiculo(@RequestBody Veiculo veiculo) throws Exception {
        try {
            Veiculo hospedeSaved = veiculoService.cadastraVeiculo(veiculo);
            return new ResponseEntity<>(hospedeSaved, null, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @GetMapping
    public ResponseEntity<?> listAll() {

        List<Veiculo> veiculoList = veiculoService.ListAllVeiculo();

        if (!veiculoList.isEmpty()) {
            return new ResponseEntity<>(veiculoList, null, HttpStatus.OK);
        }
        return new ResponseEntity<>(veiculoList, null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Veiculo>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(veiculoService.findOne(id));
    }

    @GetMapping("veiculos/{modelo}")
    public ResponseEntity<?> listaPorModelo(@PathVariable Modelo modelo) {

        List<Veiculo> list = veiculoService.getByModelo(modelo);

        if (!list.isEmpty()) {
            return new ResponseEntity<>(list, null, HttpStatus.OK);
        }
        return new ResponseEntity<>(list, null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("veiculos/{marca}")
    public ResponseEntity<?> listaPorMarca(@PathVariable Marca marca) {

        List<Veiculo> list = veiculoService.getByMarca(marca);

        if (!list.isEmpty()) {
            return new ResponseEntity<>(list, null, HttpStatus.OK);
        }
        return new ResponseEntity<>(list, null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("veiculos/{placa}")
    public ResponseEntity<?> listaPorPlaca(@PathVariable String placa) {

        List<Veiculo> list = veiculoService.getByPlaca(placa);

        if (!list.isEmpty()) {
            return new ResponseEntity<>(list, null, HttpStatus.OK);
        }
        return new ResponseEntity<>(list, null, HttpStatus.NO_CONTENT);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Veiculo veiculo) {
        return ResponseEntity.ok(veiculoService.update(veiculo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@RequestBody Veiculo veiculo) {
        return ResponseEntity.ok(null);
    }

}
