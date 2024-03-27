package com.example.projetoBank.model;

import java.sql.Date;
import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import com.example.projetoBank.validation.TipoConta;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.Data;

    @Data
    @Entity
public class Cadastro {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int numConta;
    private int numAgencia;

    @NotBlank(message = "Nome do titular é obrigatório")
    private String nomeTitular;
    
    @CPF
    private String cpf;

    @PastOrPresent(message = "A data de abertura tem que estar no passado ou presente")
    private LocalDate dataAbertura;

    @Positive(message = "O valor do saldo deve ser positivo")
    private double saldoInicial;
    private boolean ativa;
    @TipoConta
    private String tipoConta;


}
