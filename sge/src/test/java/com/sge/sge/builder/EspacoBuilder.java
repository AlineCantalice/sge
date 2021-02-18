package com.sge.sge.builder;

import com.sge.sge.domain.Espaco;
import com.sge.sge.repository.EspacoRepository;
import com.sge.sge.service.EspacoService;
import com.sge.sge.service.dto.EspacoDTO;
import com.sge.sge.service.mapper.EspacoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.List;

@Component
public class EspacoBuilder extends ConstrutorDeEntidade<Espaco> {

    @Autowired
    private EspacoService espacoService;

    @Autowired
    private EspacoMapper espacoMapper;

    @Override
    public Espaco construirEntidade() throws ParseException {

        Espaco espaco = new Espaco();

        espaco.setNome("sala teste");
        espaco.setLotacao(10);
        espaco.setSala(true);

        return espaco;
    }

    @Override
    public Espaco persistir(Espaco entidade) {
        espacoService.save(espacoMapper.toDto(entidade));
        return entidade;
    }

    @Override
    public Collection<Espaco> obterTodos() {
        List<EspacoDTO> espacoDTOList = espacoService.list();
        List<Espaco> espacos = espacoMapper.toEntity(espacoDTOList);
        return espacos;
    }

    @Override
    public Espaco obterPorId(Integer id) {
        return espacoMapper.toEntity(espacoService.getById(id));
    }
}
