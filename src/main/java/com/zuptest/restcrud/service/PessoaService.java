package com.zuptest.restcrud.service;

import com.zuptest.restcrud.dto.mapper.PessoaMapper;
import com.zuptest.restcrud.dto.request.PessoaDTO;
import com.zuptest.restcrud.dto.response.MessageDTO;
import com.zuptest.restcrud.entity.Pessoa;
import com.zuptest.restcrud.exception.PessoaNaoEncontradaException;
import com.zuptest.restcrud.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class PessoaService {
    private final PessoaRepository pessoaRepository;
    private final PessoaMapper pessoaMapper;

    public MessageDTO create(PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaMapper.toModel(pessoaDTO);
        Pessoa pessoaSalva = pessoaRepository.save(pessoa);

        MessageDTO messageDTO = createMessageResponse("Pessoa criada com sucesso");

        return messageDTO;
    }

    public PessoaDTO findById(Long id) throws PessoaNaoEncontradaException {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNaoEncontradaException(id));

        return pessoaMapper.toDTO(pessoa);
    }

    public List<PessoaDTO> findAll() {
        List<Pessoa> pessoas = pessoaRepository.findAll();

        return pessoas.stream()
                .map(pessoaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MessageDTO update(Long id, PessoaDTO pessoaDTO) throws PessoaNaoEncontradaException {
        pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNaoEncontradaException(id));

        Pessoa atualizada = pessoaMapper.toModel(pessoaDTO);
        Pessoa salva = pessoaRepository.save(atualizada);

        MessageDTO messageDTO = createMessageResponse("Pessoa atualizada com sucesso");

        return messageDTO;
    }

    public void delete(Long id) throws PessoaNaoEncontradaException {
        pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNaoEncontradaException(id));

        pessoaRepository.deleteById(id);
    }


    private MessageDTO createMessageResponse(String message) {
        return MessageDTO.builder()
                .message(message)
                .build();
    }
}
