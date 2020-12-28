package com.zuptest.restcrud.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {
    private Long id;

    @NotEmpty
    @Size(min = 4, max = 30)
    private String name;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @CPF
    private String cpf;

    @NotNull
    private String birthDate;
}
