package com.capital.humano.controller;

import com.capital.humano.modelo.Candidato;
import com.capital.humano.modelo.Empleo;
import com.capital.humano.servicio.EmpleoServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"empleo"})
public class EmpleoController {

    @Autowired
    private EmpleoServicioImpl service;

    @GetMapping("{id}")
    public ResponseEntity<Empleo> getEmpleo(@PathVariable int id) {
        Empleo e = service.getEmpleoById(id);
        if (e == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(e);
    }
    @PutMapping("{id}")
    public ResponseEntity<Empleo> putEmpleo(@PathVariable int id, @RequestBody Empleo empleo) {
        empleo = service.actualizarEmpleo(id, empleo);
        return ResponseEntity.ok(empleo);
    }

    @PostMapping("{idCandidato}")
    public ResponseEntity<Empleo> postEmpleo(@PathVariable int idCandidato, @RequestBody Empleo empleo) {
        empleo = service.guardarEmpleo(idCandidato, empleo);
        return new ResponseEntity<>(empleo, HttpStatus.CREATED);
    }

}
