package com.example.projetoBank.controller;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.projetoBank.model.Cadastro;
import com.example.projetoBank.repository.CadastroRepository;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("conta")
@Slf4j
public class CadastroController {
    
   Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    CadastroRepository repository;
    
    @GetMapping()
    public List<Cadastro> index() {
        return repository.findAll();

    }
    

    @PostMapping
    @ResponseStatus(CREATED)
    public Cadastro create(@Valid @RequestBody Cadastro cadastro) {
        log.info("cadastando a conta {} ", cadastro);
        return repository.save(cadastro);
    }

    @GetMapping("{id}")
    public ResponseEntity<Cadastro> show(@PathVariable Long id) {
        log.info("buscando categoria por id {}", id);

        return repository
                .findById(id)
                .map(ResponseEntity::ok) // reference method
                .orElse(ResponseEntity.notFound().build());

    }

    @GetMapping("cpf/{cpf}")
    public ResponseEntity<Cadastro> show(@PathVariable String cpf) {
        log.info("buscando cadastro por cpf {}", cpf);

        return repository
                .findByCpf(cpf)
                .map(ResponseEntity::ok) // reference method
                .orElse(ResponseEntity.notFound().build());

    }


    @PutMapping("{id}")
    public Cadastro update(@PathVariable Long id, @RequestBody Cadastro cadastro) {
        log.info("atualizando categoria com id {} para {}", id, cadastro);

        verificarSeExisteCadastro(id);
        cadastro.setAtiva(false);
        return repository.save(cadastro);
    }

    

    private void verificarSeExisteCadastro(Long id) {
        repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Não existe conta com o id informado. Consulte lista em /conta"));
    }



}


    
 
    
 
