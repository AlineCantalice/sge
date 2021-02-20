package com.sge.sge.controller;

import com.sge.sge.builder.EtapaBuilder;
import com.sge.sge.domain.Etapa;
import com.sge.sge.repository.EtapaRepository;
import com.sge.sge.service.mapper.EtapaMapper;
import com.sge.sge.util.IntTestComum;
import com.sge.sge.util.TestUtil;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@Transactional
public class EtapaControllerIT extends IntTestComum {

    @Autowired
    private EtapaBuilder etapaBuilder;

    @Autowired
    private EtapaMapper etapaMapper;

    @Autowired
    private EtapaRepository etapaRepository;

    @BeforeEach
    public void initialize(){
        etapaRepository.deleteAll();
    }

    @Test
    public void listTest() throws Exception {
        etapaBuilder.construir();

        getMockMvc().perform(get("/api/etapas"))
                .andExpect(status().isOk());
    }

    @Test
    public void getByIdTest() throws Exception {
        Etapa etapa = etapaBuilder.construir();

        getMockMvc().perform(get("/api/etapas/{id}", etapa.getId()))
                .andExpect(status().isOk());
    }

    @Test
    public void saveTest() throws Exception {
        Etapa etapa = etapaBuilder.construirEntidade();

        getMockMvc().perform(post("/api/etapas")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(etapaMapper.toDto(etapa))))
                .andExpect(status().isCreated());

        Assert.assertEquals(1, etapaRepository.findAll().size());
    }

    @Test
    public void editTest() throws Exception {
        Etapa etapa = etapaBuilder.construir();
        etapa.setNumeroEtapa(1);

        getMockMvc().perform(put( "/api/etapas")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(etapaMapper.toDto(etapa))))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteTest() throws Exception {
        Etapa etapa = etapaBuilder.construir();

        getMockMvc().perform(delete("/api/etapas/{id}", etapa.getId()))
                .andExpect(status().isOk());
    }

}
