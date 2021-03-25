package com.gerenciamento.carro.service;


import com.gerenciamento.carro.repository.MarcaRepository;
import com.gerenciamento.carro.view.Marca;
import com.gerenciamento.carro.view.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MarcaService {

    private final MarcaRepository marcaRepository;

    @Autowired
    public MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    public Marca cadastraMarca(Marca marca) {
        return marcaRepository.save(marca);
    }

    public List<Marca> ListAllMarca() {
        return marcaRepository.findAll();
    }

    public Optional<Marca> findOne(long id) {
        return marcaRepository.findById(id);
    }

    public Object update(Marca marca) {
    return marcaRepository.save(marca);
    }

    public void delete(long id) {
        Marca marca = marcaRepository.getOne(id);
        marcaRepository.delete(marca);
    }
}
