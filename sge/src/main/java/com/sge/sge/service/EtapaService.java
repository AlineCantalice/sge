package com.sge.sge.service;

import com.sge.sge.domain.Espaco;
import com.sge.sge.domain.Etapa;
import com.sge.sge.repository.EtapaRepository;
import com.sge.sge.service.dto.EspacoDTO;
import com.sge.sge.service.dto.EtapaDTO;
import com.sge.sge.service.dto.PessoaDTO;
import com.sge.sge.service.exception.RegrasNegocioException;
import com.sge.sge.service.mapper.EspacoMapper;
import com.sge.sge.service.mapper.EtapaMapper;
import com.sge.sge.service.mapper.PessoaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EtapaService {

    private final EtapaRepository etapaRepository;
    private final EtapaMapper etapaMapper;
    private final PessoaService pessoaService;
    private final PessoaMapper pessoaMapper;
    private final EspacoService espacoService;
    private final EspacoMapper espacoMapper;

    public List<EtapaDTO> list(){
        return etapaMapper.toDto(etapaRepository.findAll());
    }

    public EtapaDTO getById(Integer id){
        Etapa etapa = etapaRepository.findById(id)
                .orElseThrow(() -> new RegrasNegocioException("Id não encontrado"));
        return etapaMapper.toDto(etapa);
    }

    public EtapaDTO save(EtapaDTO etapaDTO){
        List<Etapa> etapas = new ArrayList<>();
        List<PessoaDTO> metade = pessoas.subList(0, pessoas.size()/2-1);
        List<PessoaDTO> outraMetade = pessoas.subList(pessoas.size()/2, pessoas.size()-1);
        for (int i = 1; i <= 2; i++) {
            for (EspacoDTO espaco : espacos){
                if (espaco.getSala() && espaco.getLotacao() > 0 && espaco.getLotacao() <= metade.size()){
                    etapas.addAll(createEtapa(metade, espaco, i));
                }
                if (espaco.getSala() && espaco.getLotacao() > 0 && espaco.getLotacao() <= outraMetade.size()){
                    etapas.addAll(createEtapa(outraMetade, espaco, i));
                }
            }
            for (Etapa etapa : etapas) {
                etapaMapper.toDto(etapaRepository.save(etapa));
            }
        }
        return etapaMapper.toDto(etapas);
    }

    public EtapaDTO edit(EtapaDTO etapaDTO){
        return etapaMapper.toDto(etapaRepository.save(etapaMapper.toEntity(etapaDTO)));
    }

    public void delete(Integer id){
        etapaRepository.delete(etapaMapper.toEntity(this.getById(id)));
    }

    private List<Etapa> createEtapa(List<PessoaDTO> pessoas, EspacoDTO espaco, Integer numEtapa){

        List<Etapa> etapas = new ArrayList<>();
        Etapa etapa = new Etapa();

        while (espaco.getLotacao() > 0){
            for (PessoaDTO pessoa : pessoas){
                etapa.setEspaco(espacoMapper.toEntity(espaco));
                etapa.setPessoa(pessoaMapper.toEntity(pessoa));
                etapa.setNumeroEtapa(numEtapa);
                etapas.add(etapa);
            }
        }
        return etapas;
    }

}
