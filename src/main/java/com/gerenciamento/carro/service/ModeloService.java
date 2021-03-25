package com.gerenciamento.carro.service;

import com.gerenciamento.carro.repository.ModeloRepository;
import com.gerenciamento.carro.view.Marca;
import com.gerenciamento.carro.view.Modelo;
import com.gerenciamento.carro.view.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModeloService {

    private final ModeloRepository modeloRepository;

    @Autowired
    public ModeloService(ModeloRepository modeloRepository) {
        this.modeloRepository = modeloRepository;
    }

    public Modelo cadastraModelo(Modelo modelo) {
        return modeloRepository.save(modelo);
    }

    public List<Modelo> ListAllModelo() {
        return modeloRepository.findAll();
    }

    public Optional<Modelo> findOne(long id) {
        return modeloRepository.findById(id);
    }

    public Object update(Modelo modelo) {
        return modeloRepository.save(modelo);
    }

    public void delete(long id) {
        Modelo modelo = modeloRepository.getOne(id);
        modeloRepository.delete(modelo);
    }

}
