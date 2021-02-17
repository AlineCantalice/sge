package com.sge.sge.controller;

import com.sge.sge.service.EspacoService;
import com.sge.sge.service.dto.EspacoDTO;
import lombok.RequiredArgsConstructor;
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
        return null; //ResponseEntity.ok(etapaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EspacoDTO> getById(@PathVariable Integer id){
        return null;
    }

    @PostMapping
    public ResponseEntity<EspacoDTO> save(@RequestBody EspacoDTO espacoDTO){
        return null;
    }

    @PutMapping
    public ResponseEntity<EspacoDTO> edit(@RequestBody EspacoDTO espacoDTO){
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EspacoDTO> delete(@PathVariable Integer id){
        return null;
    }

}
