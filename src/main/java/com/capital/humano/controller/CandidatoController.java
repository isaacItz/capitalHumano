package com.capital.humano.controller;

import com.capital.humano.modelo.Candidato;
import com.capital.humano.servicio.CandidatoServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"candidato"})
public class CandidatoController {

    @Autowired
    private CandidatoServicioImpl service;

    @PostMapping
    public Candidato postCandidato(@RequestBody Candidato candidato) {
        candidato = service.guardarCandidato(candidato);

        return candidato;
    }

    @GetMapping("{id}")
    public ResponseEntity<Candidato> getCandidatoById(@PathVariable int id) {
        Candidato c = service.getCandidatoById(id);
        if (c == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(c);
    }

    @GetMapping
    public ResponseEntity<List<Candidato>> getCandidatos() {
        return ResponseEntity.ok(service.listarCandidatos());
    }

    @PutMapping("{id}")
    public ResponseEntity<Candidato> putCandidato(@PathVariable int id, @RequestBody Candidato candidato) {
        candidato.setId(id);
        candidato = service.actualizarCandidato(candidato);
        if (candidato == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(candidato);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCandidato(@PathVariable int id) {

        if (!service.eliminarCandidato(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("candidatosPorEmpresa")
    public ResponseEntity<List<Candidato>> getCandidatosEmpleo(@RequestParam String empresa) {
        List<Candidato> candidatos = service.getCandidatoPorEmpresa(empresa);
        return ResponseEntity.ok(candidatos);
    }

    @GetMapping("candidatosCon2Antiguedad")
    public ResponseEntity<List<Candidato>> getCandidatos2Antiguedad(){
        List<Candidato> candidatos = service.getCandidatoCon2AñosAntiguedad();
        return ResponseEntity.ok(candidatos);
    }

    @GetMapping("getCandidatosConIngresoMayorA10000")
    public ResponseEntity<List<Candidato>> getCandidatosConIngresoMayorA10000(){
        List<Candidato> candidatos = service.getCandidatosConIngresoMayorA10000();
        return ResponseEntity.ok(candidatos);
    }

    @GetMapping("getCandidatosCon5AniosAntiguedad")
    public ResponseEntity<List<Candidato>> getCandidatosCon5AniosAntiguedad(){
        List<Candidato> candidatos = service.getCandidatosCon5AniosAntiguedad();
        return ResponseEntity.ok(candidatos);
    }

    @GetMapping("getCandidatosLaborando")
    public ResponseEntity<List<Candidato>> getCandidatosLaborando(){
        List<Candidato> candidatos = service.getCandidatosLaborando();
        return ResponseEntity.ok(candidatos);
    }

    @GetMapping("getCandidatosEnTlalpan")
    public ResponseEntity<List<Candidato>> getCandidatosEnTlalpan(){
        List<Candidato> candidatos = service.getCandidatosEnTlalpan();
        return ResponseEntity.ok(candidatos);
    }
}
