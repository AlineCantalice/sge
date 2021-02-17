package com.sge.sge.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "espaco")
@Getter
@Setter
public class Espaco implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_espaco")
    @SequenceGenerator(name = "sq_espaco", sequenceName = "sq_espaco", allocationSize = 1)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "lotacao")
    private Integer lotacao;

    @Column(name = "sala")
    private Boolean sala;

}
