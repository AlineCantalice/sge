package com.sge.sge.service;

import com.sge.sge.domain.Etapa;
import com.sge.sge.domain.Pessoa;
import com.sge.sge.repository.EtapaRepository;
import com.sge.sge.service.dto.EtapaDTO;
import com.sge.sge.service.dto.PessoaDTO;
import com.sge.sge.service.mapper.EtapaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EtapaService {

    private final EtapaRepository etapaRepository;
    private final EtapaMapper etapaMapper;

    public List<EtapaDTO> list(){
        return etapaMapper.toDto(etapaRepository.findAll());
    }

    public EtapaDTO getById(Integer id){
        Etapa etapa = etapaRepository.findById(id).get();
        return etapaMapper.toDto(etapa);
    }

    public EtapaDTO save(EtapaDTO etapaDTO){
        return etapaMapper.toDto(etapaRepository.save(etapaMapper.toEntity(etapaDTO)));
    }

    public EtapaDTO edit(EtapaDTO etapaDTO){
        return etapaMapper.toDto(etapaRepository.save(etapaMapper.toEntity(etapaDTO)));
    }

    public void delete(Integer id){
        etapaRepository.delete(etapaMapper.toEntity(this.getById(id)));
    }

}
