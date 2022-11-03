package com.agencias.agencias.repository;

import com.agencias.agencias.model.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgenciaRepository extends JpaRepository <Agencia, Integer> {

    List<Agencia> findByEndereco (String endereco);

    Agencia findByCodigo (Integer codigo);

}
