package com.sge.sge.service.mapper;

import com.sge.sge.domain.Pessoa;
import com.sge.sge.service.dto.PessoaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface PessoaMapper extends EntityMapper<PessoaDTO, Pessoa> {
}
