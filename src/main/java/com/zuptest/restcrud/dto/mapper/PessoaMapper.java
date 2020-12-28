package com.zuptest.restcrud.dto.mapper;

import com.zuptest.restcrud.dto.request.PessoaDTO;
import com.zuptest.restcrud.entity.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PessoaMapper {
    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Pessoa toModel(PessoaDTO personDTO);
    PessoaDTO toDTO(Pessoa pessoa);
}
