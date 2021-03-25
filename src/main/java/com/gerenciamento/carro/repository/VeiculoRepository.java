package com.gerenciamento.carro.repository;

import com.gerenciamento.carro.view.Marca;
import com.gerenciamento.carro.view.Modelo;
import com.gerenciamento.carro.view.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    List<Veiculo> findByModelo(Modelo modelo);
    List<Veiculo> findByMarca(Marca marca);

}
