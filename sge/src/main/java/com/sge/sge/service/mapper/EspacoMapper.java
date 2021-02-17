package com.sge.sge.service.mapper;

import com.sge.sge.domain.Espaco;
import com.sge.sge.service.dto.EspacoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface EspacoMapper extends EntityMapper<EspacoDTO, Espaco> {
}
