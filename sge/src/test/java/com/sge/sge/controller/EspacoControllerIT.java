package com.sge.sge.controller;

import com.sge.sge.builder.EspacoBuilder;
import com.sge.sge.domain.Espaco;
import com.sge.sge.repository.EspacoRepository;
import com.sge.sge.service.mapper.EspacoMapper;
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
public class EspacoControllerIT extends IntTestComum {

    @Autowired
    private EspacoBuilder espacoBuilder;

    @Autowired
    private EspacoMapper espacoMapper;

    @Autowired
    private EspacoRepository espacoRepository;

    @BeforeEach
    public void initialize(){
        espacoRepository.deleteAll();
    }

    @Test
    public void listTest() throws Exception {
        espacoBuilder.construir();

        getMockMvc().perform(get("/api/espacos"))
                .andExpect(status().isOk());
    }

    @Test
    public void getByIdTest() throws Exception {
        Espaco espaco = espacoBuilder.construir();

        getMockMvc().perform(get("/api/espacos/{id}", espaco.getId()))
                .andExpect(status().isOk());
    }

    @Test
    public void saveTest() throws Exception {
        Espaco espaco = espacoBuilder.construirEntidade();

        getMockMvc().perform(post("/api/espacos")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(espacoMapper.toDto(espaco))))
                .andExpect(status().isCreated());

        Assert.assertEquals(1, espacoRepository.findAll().size());
    }

    @Test
    public void editTest() throws Exception {
        Espaco espaco = espacoBuilder.construir();
        espaco.setNome("Alterando espaco");

        getMockMvc().perform(put( "/api/espacos")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(espacoMapper.toDto(espaco))))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteTest() throws Exception {
        Espaco espaco = espacoBuilder.construir();

        getMockMvc().perform(delete("/api/espacos/" + espaco.getId()))
                .andExpect(status().isOk());
    }

}
