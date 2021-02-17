package com.sge.sge.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class EtapaId implements Serializable {

    private Integer pessoa;

    private Integer espaco;

}
