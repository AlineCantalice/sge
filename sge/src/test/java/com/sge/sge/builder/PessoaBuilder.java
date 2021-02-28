package com.sge.sge.builder;

import com.sge.sge.domain.Pessoa;
import com.sge.sge.service.PessoaService;
import com.sge.sge.service.dto.PessoaDTO;
import com.sge.sge.service.mapper.PessoaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.List;

@Component
public class PessoaBuilder extends ConstrutorDeEntidade<Pessoa> {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PessoaMapper pessoaMapper;

    @Override
    public Pessoa construirEntidade() throws ParseException {

        Pessoa pessoa = new Pessoa();

        pessoa.setNome("pessoa teste");
        pessoa.setSobrenome("sobrenome teste");

        return pessoa;
    }

    @Override
    public Pessoa persistir(Pessoa entidade) {
        pessoaService.save(pessoaMapper.toDto(entidade));
        return entidade;
    }

    @Override
    public Collection<Pessoa> obterTodos() {
        List<PessoaDTO> pessoaDTOList = pessoaService.list();
        List<Pessoa> pessoas = pessoaMapper.toEntity(pessoaDTOList);
        return pessoas;
    }

    @Override
    public Pessoa obterPorId(Integer id) {
        return pessoaMapper.toEntity(pessoaService.getById(id));
    }
}
