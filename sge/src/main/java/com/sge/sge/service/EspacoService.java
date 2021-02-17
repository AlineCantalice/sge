package com.sge.sge.service;

import com.sge.sge.repository.EspacoRepository;
import com.sge.sge.service.dto.EspacoDTO;
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
        return null;
    }

    public EspacoDTO getById(Integer id){
        return null;
    }

    public EspacoDTO save(EspacoDTO espacoDTO){
        return null;
    }

    public EspacoDTO edit(EspacoDTO espacoDTO){
        return null;
    }

    public void delete(Integer Id){

    }

}
