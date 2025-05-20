package com.capital.humano.servicio;

import com.capital.humano.modelo.Candidato;

import java.util.List;

public interface ICandidatoServicio {
    public List<Candidato> listarCandidatos();
    public Candidato getCandidatoById(int id);
    public Candidato guardarCandidato(Candidato candidato);
    public boolean eliminarCandidato(int id);
    public Candidato actualizarCandidato(Candidato candidato);
}
