package com.sge.sge.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class EtapaDTO implements Serializable {

    private Integer pessoa;

    private Integer espaco;

    private String numeroEtapa;

}
