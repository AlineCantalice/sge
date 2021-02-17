package com.sge.sge.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PessoaDTO implements Serializable {

    private Integer id;

    private String nome;

    private String sobrenome;

}
