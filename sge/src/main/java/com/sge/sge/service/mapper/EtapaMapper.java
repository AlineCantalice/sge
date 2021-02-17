package com.sge.sge.service.mapper;

import com.sge.sge.domain.Etapa;
import com.sge.sge.service.dto.EtapaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {PessoaMapper.class, EspacoMapper.class})
public interface EtapaMapper extends EntityMapper<EtapaDTO, Etapa> {

    @Override
    @Mapping(source = "pessoa", target = "pessoa.id")
    @Mapping(source = "espaco", target = "espaco.id")

    @Mapping(source = "pessoa", target = "id.pessoa")
    @Mapping(source = "espaco", target = "id.espaco")
    Etapa toEntity(EtapaDTO etapaDTO);

    @Override
    @Mapping(source = "pessoa.id", target = "pessoa")
    @Mapping(source = "espaco.id", target = "espaco")
    EtapaDTO toDto(Etapa etapa);

}
