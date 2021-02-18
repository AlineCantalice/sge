package com.sge.sge.builder;

import com.sge.sge.domain.Espaco;
import com.sge.sge.domain.Etapa;
import com.sge.sge.domain.Pessoa;
import com.sge.sge.service.EtapaService;
import com.sge.sge.service.dto.EtapaDTO;
import com.sge.sge.service.mapper.EtapaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.List;

@Component
public class EtapaBuilder extends ConstrutorDeEntidade<Etapa> {

    @Autowired
    private PessoaBuilder pessoaBuilder;

    @Autowired
    private EspacoBuilder espacoBuilder;

    @Autowired
    private EtapaService etapaService;

    @Autowired
    private EtapaMapper etapaMapper;

    @Override
    public Etapa construirEntidade() throws ParseException {
        Pessoa pessoa = pessoaBuilder.construir();
        Espaco espaco = espacoBuilder.construir();

        Etapa etapa = new Etapa();
        etapa.setPessoa(pessoa);
        etapa.setEspaco(espaco);
        etapa.setNumeroEtapa("2");

        return etapa;
    }

    @Override
    public Etapa persistir(Etapa entidade) {
        etapaService.save(etapaMapper.toDto(entidade));
        return entidade;
    }

    @Override
    public Collection<Etapa> obterTodos() {
        List<EtapaDTO> etapaDTOList = etapaService.list();
        List<Etapa> etapas = etapaMapper.toEntity(etapaDTOList);
        return etapas;
    }

    @Override
    public Etapa obterPorId(Integer id) {
        return etapaMapper.toEntity(etapaService.getById(id));
    }
}
