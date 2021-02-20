package com.sge.sge.service;

import com.sge.sge.domain.Pessoa;
import com.sge.sge.repository.PessoaRepository;
import com.sge.sge.service.dto.PessoaDTO;
import com.sge.sge.service.exception.RegrasNegocioException;
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
        return pessoaMapper.toDto(pessoaRepository.findAll());
    }

    public PessoaDTO getById(Integer id) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new RegrasNegocioException("Id não encontrado"));
        return pessoaMapper.toDto(pessoa);
    }

    public PessoaDTO getByNome(PessoaDTO pessoaDTO){
        Pessoa pessoa = pessoaRepository.getByNome(pessoaDTO.getNome());
        return pessoaMapper.toDto(pessoa);
    }

    public PessoaDTO save(PessoaDTO pessoaDTO){
        this.validateDataNull(pessoaDTO);
        return pessoaMapper.toDto(pessoaRepository.save(pessoaMapper.toEntity(pessoaDTO)));
    }

    public PessoaDTO edit(PessoaDTO pessoaDTO){
        this.validateDataNull(pessoaDTO);
        return pessoaMapper.toDto(pessoaRepository.save(pessoaMapper.toEntity(pessoaDTO)));
    }

    public void delete(Integer id) {
        this.getById(id);
        pessoaRepository.delete(pessoaMapper.toEntity(this.getById(id)));
    }

    private void validateDataNull(PessoaDTO pessoaDTO) {

        if(pessoaDTO.getNome() == null){
            throw new RegrasNegocioException("O nome deve ser informado");
        }
        if(pessoaDTO.getSobrenome() == null){
            throw new RegrasNegocioException("O sobrenome deve ser informado");
        }

    }

}
