package com.sge.sge.controller;

import com.sge.sge.service.EtapaService;
import com.sge.sge.service.dto.EtapaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
        return ResponseEntity.ok(etapaService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtapaDTO> getById(@PathVariable Integer id){
        return ResponseEntity.ok(etapaService.getById(id));
    }

    @PostMapping
    public ResponseEntity<EtapaDTO> save(@RequestBody EtapaDTO etapaDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(etapaService.save(etapaDTO));
    }

    @PutMapping
    public ResponseEntity<EtapaDTO> edit(@RequestBody EtapaDTO etapaDTO){
        return ResponseEntity.ok(etapaService.edit(etapaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EtapaDTO> delete(@PathVariable Integer id){
        etapaService.delete(id);
        return ResponseEntity.ok().build();
    }

}
