package com.sge.sge.controller;

import com.sge.sge.service.EspacoService;
import com.sge.sge.service.dto.EspacoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/espacos")
@RestController
@RequiredArgsConstructor
public class EspacoController {

    private final EspacoService espacoService;

    @GetMapping
    public ResponseEntity<List<EspacoDTO>> list() {
        return ResponseEntity.ok(espacoService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EspacoDTO> getById(@PathVariable Integer id){
        return ResponseEntity.ok(espacoService.getById(id));
    }

    @GetMapping("/nome")
    public ResponseEntity<EspacoDTO> getByNome(@RequestBody EspacoDTO espacoDTO){
        return ResponseEntity.ok(espacoService.getByNome(espacoDTO));
    }

    @PostMapping
    public ResponseEntity<EspacoDTO> save(@RequestBody EspacoDTO espacoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(espacoService.save(espacoDTO));
    }

    @PutMapping
    public ResponseEntity<EspacoDTO> edit(@RequestBody EspacoDTO espacoDTO){
        return ResponseEntity.ok(espacoService.edit(espacoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EspacoDTO> delete(@PathVariable Integer id){
        espacoService.delete(id);
        return ResponseEntity.ok().build();
    }

}
