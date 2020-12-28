package com.zuptest.restcrud.repository;

import com.zuptest.restcrud.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
