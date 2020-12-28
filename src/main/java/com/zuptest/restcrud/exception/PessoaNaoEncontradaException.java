package com.zuptest.restcrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PessoaNaoEncontradaException extends Exception {
    public PessoaNaoEncontradaException(Long id) {
        super(String.format("Pessoa com id %s não encontrada!", id));
    }
}
