package com.sge.sge.service;

import com.sge.sge.domain.Pessoa;
import com.sge.sge.repository.PessoaRepository;
import com.sge.sge.service.dto.PessoaDTO;
import com.sge.sge.service.mapper.PessoaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final PessoaMapper pessoaMapper;

    public List<PessoaDTO> list(){
        return pessoaMapper.toDto(pessoaRepository.findAll());
    }

    public PessoaDTO getById(Integer id){
        Pessoa pessoa = pessoaRepository.findById(id).get();
        return pessoaMapper.toDto(pessoa);
    }

    public PessoaDTO getByNome(PessoaDTO pessoaDTO){
        Pessoa pessoa = pessoaRepository.getByNome(pessoaDTO.getNome());
        return pessoaMapper.toDto(pessoa);
    }

    public PessoaDTO save(PessoaDTO pessoaDTO){
        return pessoaMapper.toDto(pessoaRepository.save(pessoaMapper.toEntity(pessoaDTO)));
    }

    public PessoaDTO edit(PessoaDTO pessoaDTO){
        return pessoaMapper.toDto(pessoaRepository.save(pessoaMapper.toEntity(pessoaDTO)));
    }

    public void delete(Integer id){
        pessoaRepository.delete(pessoaMapper.toEntity(this.getById(id)));
    }

}
