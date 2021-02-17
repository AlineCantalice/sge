package com.sge.sge.controller;

import com.sge.sge.service.PessoaService;
import com.sge.sge.service.dto.PessoaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
        return ResponseEntity.ok(pessoaService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTO> getById(@PathVariable Integer id){
        return ResponseEntity.ok(pessoaService.getById(id));
    }

    @GetMapping("/nome")
    public ResponseEntity<PessoaDTO> getByNome(@RequestBody PessoaDTO pessoaDTO){
        return ResponseEntity.ok(pessoaService.getByNome(pessoaDTO));
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> save(@RequestBody PessoaDTO pessoaDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.save(pessoaDTO));
    }

    @PutMapping
    public ResponseEntity<PessoaDTO> edit(@RequestBody PessoaDTO pessoaDTO){
        return ResponseEntity.ok(pessoaService.edit(pessoaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PessoaDTO> delete(@PathVariable Integer id){
        pessoaService.delete(id);
        return ResponseEntity.ok().build();
    }

}
