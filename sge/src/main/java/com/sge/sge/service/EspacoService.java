package com.sge.sge.service;

import com.sge.sge.domain.Espaco;
import com.sge.sge.domain.Pessoa;
import com.sge.sge.repository.EspacoRepository;
import com.sge.sge.service.dto.EspacoDTO;
import com.sge.sge.service.dto.PessoaDTO;
import com.sge.sge.service.mapper.EspacoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EspacoService {

    private final EspacoRepository espacoRepository;
    private final EspacoMapper espacoMapper;

    public List<EspacoDTO> list(){
        return espacoMapper.toDto(espacoRepository.findAll());
    }

    public EspacoDTO getById(Integer id){
        Espaco espaco = espacoRepository.findById(id).get();
        return espacoMapper.toDto(espaco);
    }

    public EspacoDTO getByNome(EspacoDTO espacoDTO){
        Espaco espaco = espacoRepository.getByNome(espacoDTO.getNome());
        return espacoMapper.toDto(espaco);
    }

    public EspacoDTO save(EspacoDTO espacoDTO){
        return espacoMapper.toDto(espacoRepository.save(espacoMapper.toEntity(espacoDTO)));
    }

    public EspacoDTO edit(EspacoDTO espacoDTO){
        return espacoMapper.toDto(espacoRepository.save(espacoMapper.toEntity(espacoDTO)));
    }

    public void delete(Integer id){
        espacoRepository.delete(espacoMapper.toEntity(this.getById(id)));
    }

}
