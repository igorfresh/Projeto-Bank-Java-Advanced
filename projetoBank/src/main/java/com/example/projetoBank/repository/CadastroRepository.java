package com.example.projetoBank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetoBank.model.Cadastro;

public interface CadastroRepository extends JpaRepository<Cadastro, Long> {

    Optional<Cadastro> findByCpf(String cpf);
    
}
