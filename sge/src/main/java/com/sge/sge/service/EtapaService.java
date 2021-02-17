package com.sge.sge.service;

import com.sge.sge.repository.EtapaRepository;
import com.sge.sge.service.dto.EtapaDTO;
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
        return null;
    }

    public EtapaDTO getById(Integer id){
        return null;
    }

    public EtapaDTO save(EtapaDTO etapaDTO){
        return null;
    }

    public EtapaDTO edit(EtapaDTO etapaDTO){
        return null;
    }

    public void delete(Integer Id){

    }

}
