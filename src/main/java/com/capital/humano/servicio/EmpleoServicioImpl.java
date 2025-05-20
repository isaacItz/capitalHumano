package com.capital.humano.servicio;

import com.capital.humano.modelo.Candidato;
import com.capital.humano.modelo.Empleo;
import com.capital.humano.repositorio.EmpleoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleoServicioImpl implements IEmpleoServicio {
    @Autowired
    private EmpleoRepository repository;

    public Empleo getEmpleoById(int id) {
        return repository.getEmpleoById(id);
    }

    @Override
    public Empleo actualizarEmpleo(int idEmpleo, Empleo empleo) {
        empleo.setId(idEmpleo);
        return repository.actualizarEmpleo(empleo);
    }

    @Override
    public Empleo guardarEmpleo(int idCandidato, Empleo empleo) {
        int id = repository.insertarEmpleo(idCandidato, empleo);
        if (id == -1) {
            return null;
        }
        empleo.setId(id);
        return empleo;
    }

}
