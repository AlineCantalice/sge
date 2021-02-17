package com.sge.sge.controller;

import com.sge.sge.service.PessoaService;
import com.sge.sge.service.dto.PessoaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/pessoas")
@RestController
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> list() {
        return null; //ResponseEntity.ok(etapaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTO> getById(@PathVariable Integer id){
        return null;
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> save(@RequestBody PessoaDTO pessoaDTO){
        return null;
    }

    @PutMapping
    public ResponseEntity<PessoaDTO> edit(@RequestBody PessoaDTO pessoaDTO){
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PessoaDTO> delete(@PathVariable Integer id){
        return null;
    }

}
