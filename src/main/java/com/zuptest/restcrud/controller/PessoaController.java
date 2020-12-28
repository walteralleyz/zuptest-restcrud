package com.zuptest.restcrud.controller;


import com.zuptest.restcrud.dto.request.PessoaDTO;
import com.zuptest.restcrud.dto.response.MessageDTO;
import com.zuptest.restcrud.exception.PessoaNaoEncontradaException;
import com.zuptest.restcrud.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("pessoa")
@AllArgsConstructor
public class PessoaController {
    private final PessoaService pessoaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageDTO create(@RequestBody @Valid PessoaDTO pessoaDTO) {
        return pessoaService.create(pessoaDTO);
    }

    @GetMapping("/{id}")
    public PessoaDTO findById(@PathVariable Long id) throws PessoaNaoEncontradaException {
        return pessoaService.findById(id);
    }

    @GetMapping
    public List<PessoaDTO> findAll() {
        return pessoaService.findAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageDTO udpate(@PathVariable Long id, @RequestBody @Valid PessoaDTO pessoaDTO) throws PessoaNaoEncontradaException {
        return pessoaService.update(id, pessoaDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws PessoaNaoEncontradaException {
        pessoaService.delete(id);
    }
}
