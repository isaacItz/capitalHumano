package com.capital.humano.servicio;

import com.capital.humano.modelo.Candidato;
import com.capital.humano.repositorio.CandidatoRepository;
import com.capital.humano.repositorio.EmpleoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatoServicioImpl implements ICandidatoServicio {
    @Autowired
    private CandidatoRepository repository;
    @Autowired
    private EmpleoRepository empleoRepository;

    @Override
    public List<Candidato> listarCandidatos() {
        return repository.listarCandidatos();
    }

    @Override
    public Candidato getCandidatoById(int id) {

        Candidato c = repository.getCandidatoById(id);
        c.setEmpleos(empleoRepository.getEmpleosByCandidatoId(id));
        return c;
    }

    @Override
    public Candidato guardarCandidato(Candidato candidato) {
        int idDomicilio = repository.insertDomicilio(candidato.getDomicilio());
        candidato.getDomicilio().setId(idDomicilio);
        int idCandidato = repository.insertCandidato(candidato);
        candidato.setId(idCandidato);
        empleoRepository.insertarEmpleos(candidato);

        return candidato;
    }

    @Override
    public Candidato actualizarCandidato(Candidato candidato) {
        return repository.updateCandidato(candidato);
    }

    @Override
    public boolean eliminarCandidato(int id) {
        int filasAfectadas =repository.eliminarCandidato(id);
        return filasAfectadas>0;
    }


    public List<Candidato> getCandidatoPorEmpresa(String empresa) {
        return repository.getCandidatoByEmpresa(empresa);
    }

    public List<Candidato> getCandidatoCon2AñosAntiguedad() {
        return repository.getCandidatoCon2AñosAntiguedad();
    }

    public List<Candidato> getCandidatosConIngresoMayorA10000() {
        return repository.getCandidatosConIngresoMayorA10000();
    }

    public List<Candidato> getCandidatosCon5AniosAntiguedad() {
        return repository.getCandidatosCon5AniosAntiguedad();
    }

    public List<Candidato> getCandidatosEnTlalpan() {
        return repository.getCandidatosEnTlalpan();
    }
    public List<Candidato> getCandidatosLaborando() {
        return repository.getCandidatosLaborando();
    }
}
