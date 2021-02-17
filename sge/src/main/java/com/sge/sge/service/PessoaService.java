package com.sge.sge.service;

import com.sge.sge.repository.PessoaRepository;
import com.sge.sge.service.dto.PessoaDTO;
import com.sge.sge.service.mapper.PessoaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final PessoaMapper pessoaMapper;

    public List<PessoaDTO> list(){
        return null;
    }

    public PessoaDTO getById(Integer id){
        return null;
    }

    public PessoaDTO save(PessoaDTO pessoaDTO){
        return null;
    }

    public PessoaDTO edit(PessoaDTO pessoaDTO){
        return null;
    }

    public void delete(Integer Id){

    }

}
