package com.sge.sge.controller;

import com.sge.sge.builder.PessoaBuilder;
import com.sge.sge.domain.Pessoa;
import com.sge.sge.repository.PessoaRepository;
import com.sge.sge.service.mapper.PessoaMapper;
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
public class PessoaControllerIT extends IntTestComum {

    @Autowired
    private PessoaBuilder pessoaBuilder;

    @Autowired
    private PessoaMapper pessoaMapper;

    @Autowired
    private PessoaRepository pessoaRepository;

    @BeforeEach
    public void initialize(){
        pessoaRepository.deleteAll();
    }

    @Test
    public void listTest() throws Exception {
        pessoaBuilder.construir();

        getMockMvc().perform(get("/api/pessoas"))
                .andExpect(status().isOk());
    }

    @Test
    public void getByIdTest() throws Exception {
        Pessoa pessoa = pessoaBuilder.construir();

        getMockMvc().perform(get("/api/pessoas/{id}", pessoa.getId()))
                .andExpect(status().isOk());
    }

    @Test
    public void saveTest() throws Exception {
        Pessoa pessoa = pessoaBuilder.construirEntidade();

        getMockMvc().perform(post("/api/pessoas")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(pessoaMapper.toDto(pessoa))))
                .andExpect(status().isCreated());

        Assert.assertEquals(1, pessoaRepository.findAll().size());
    }

    @Test
    public void editTest() throws Exception {
        Pessoa pessoa = pessoaBuilder.construir();
        pessoa.setNome("Alterando pessoa");

        getMockMvc().perform(put( "/api/pessoas")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(pessoaMapper.toDto(pessoa))))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteTest() throws Exception {
        Pessoa pessoa = pessoaBuilder.construir();

        getMockMvc().perform(delete("/api/pessoas/" + pessoa.getId()))
                .andExpect(status().isOk());
    }

}
