package com.sge.sge.controller;

import com.sge.sge.service.EtapaService;
import com.sge.sge.service.dto.EtapaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/etapas")
@RestController
@RequiredArgsConstructor
public class EtapaController {

    private final EtapaService etapaService;

    @GetMapping
    public ResponseEntity<List<EtapaDTO>> list() {
        return null; //ResponseEntity.ok(etapaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtapaDTO> getById(@PathVariable Integer id){
        return null;
    }

    @PostMapping
    public ResponseEntity<EtapaDTO> save(@RequestBody EtapaDTO etapaDTO){
        return null;
    }

    @PutMapping
    public ResponseEntity<EtapaDTO> edit(@RequestBody EtapaDTO etapaDTO){
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EtapaDTO> delete(@PathVariable Integer id){
        return null;
    }

}
