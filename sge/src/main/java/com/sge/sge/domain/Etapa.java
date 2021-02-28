package com.sge.sge.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "etapa")
@Getter
@Setter
public class Etapa implements Serializable {

    @EmbeddedId
    private EtapaId id;

    @MapsId("pessoa")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @MapsId("espaco")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "espaco_id")
    private Espaco espaco;

    @Column(name = "numero_etapa")
    private Integer numeroEtapa;

}
