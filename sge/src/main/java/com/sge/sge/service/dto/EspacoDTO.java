package com.sge.sge.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class EspacoDTO implements Serializable {

    private Integer id;

    private String nome;

    private Integer lotacao;

    private Boolean sala;

}
