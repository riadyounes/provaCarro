package com.gerenciamento.carro.service;

import com.gerenciamento.carro.repository.VeiculoRepository;
import com.gerenciamento.carro.view.Marca;
import com.gerenciamento.carro.view.Modelo;
import com.gerenciamento.carro.view.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {
    private final VeiculoRepository veiculoRepository;

    @Autowired
    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public Veiculo cadastraVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public Optional<Veiculo> findOne(long id) {
        return veiculoRepository.findById(id);
    }

    public List<Veiculo> ListAllVeiculo() {
        return veiculoRepository.findAll();
    }

    public Veiculo update(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);

    }

    public void delete(long id) {
        Veiculo veiculo = veiculoRepository.getOne(id);
        veiculoRepository.delete(veiculo);
    }

    public List<Veiculo> getByModelo(Modelo modelo) {
        return veiculoRepository.findByModelo(modelo);
    }

    public List<Veiculo> getByMarca(Marca marca) {
        return veiculoRepository.findByMarca(marca);
    }
}
