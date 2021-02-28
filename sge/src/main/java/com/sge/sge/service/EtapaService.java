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
        List<PessoaDTO> pessoas = pessoaService.list();
        List<EspacoDTO> espacos = espacoService.list();

        int qtdSala = 0;
        int qtdCafe = 0;

        for(EspacoDTO espacoDTO : espacos){
            if(espacoDTO.getSala()){
                qtdSala++;
            }else{
                qtdCafe++;
            }
        }

        int qtdPessoas = pessoas.size();
        int pessoasSala = qtdPessoas / qtdSala;

        Etapa etapa = new Etapa();

        //Preenchendo etapa 1
        for(int i = 1; i <= etapaDTO.getNumeroEtapa(); i++){
            for (EspacoDTO espaco : espacos) {
                if (espaco.getSala() == true) {
                    int vaga = espaco.getLotacao();
                    //se a qtd de pessoas for muito pequena para dividir por salas
                    if(pessoasSala < 5 && vaga > qtdPessoas) {
                        for (PessoaDTO pessoaDTO : pessoas) {
                            etapa.setPessoa(pessoaMapper.toEntity(pessoaDTO));
                            etapa.setEspaco(espacoMapper.toEntity(espaco));
                            etapa.setNumeroEtapa(i);
                        }
                    }
                    //se a qtd de pessoas for suficiente para dividir por salas
                    else{
                        for(PessoaDTO pessoaDTO : pessoas){
                            while (qtdPessoas > pessoasSala){

                            }
                        }
                    }
                }
            }
        }

        return etapaMapper.toDto(etapaRepository.save(etapaMapper.toEntity(etapaDTO)));
    }

    public EtapaDTO edit(EtapaDTO etapaDTO){
        return etapaMapper.toDto(etapaRepository.save(etapaMapper.toEntity(etapaDTO)));
    }

    public void delete(Integer id){
        etapaRepository.delete(etapaMapper.toEntity(this.getById(id)));
    }

    private Etapa createEtapa(List<PessoaDTO> pessoas, List<EspacoDTO> espacos){

        List<Etapa> etapas = new ArrayList<>();

        int qtdPessoas = pessoas.size();
        int qtdSala = 0;
        int qtdCafe = 0;
        int totalVagas = 0;

        for(EspacoDTO sala : espacos){
            if(sala.getSala()){
                qtdSala++;
                totalVagas+=sala.getLotacao();
            }
            else{
                qtdCafe++;
            }
        }

        int pessoasSala = qtdPessoas / qtdSala;

        //criando etapa 1
        if(qtdPessoas > totalVagas){
            throw new RegrasNegocioException("Capacidade de vagas insuficiente para total de pessoas cadastradas!");
        }else if(qtdPessoas == totalVagas){
            Etapa etapa = new Etapa();
            for(PessoaDTO pessoaDTO : pessoas){
                for(EspacoDTO espacoDTO : espacos){
                    int vaga = espacoDTO.getLotacao();
                    if(espacoDTO.getSala() && vaga > 0){

                    }
                }
            }
            /*for(EspacoDTO espaco : espacos){

                while (espaco.getSala() && !espacos.isEmpty()){
                    for(PessoaDTO pessoa : pessoas){
                        if(vaga > 0) {
                            etapa.setPessoa(pessoaMapper.toEntity(pessoa));
                            etapa.setEspaco(espacoMapper.toEntity(espaco));
                            etapa.setNumeroEtapa(1);
                            etapas.add(etapa);
                            vaga--;
                        }else{
                            vaga = espaco.getLotacao();
                        }
                    }
                }
            }*/
        }

        //Criando etapa 2


        return null;
    }

}
