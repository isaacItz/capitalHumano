package com.capital.humano.servicio;

import com.capital.humano.modelo.Candidato;
import com.capital.humano.modelo.Empleo;

public interface IEmpleoServicio {
    public Empleo actualizarEmpleo(int idEmpleo, Empleo empleo);

    public Empleo guardarEmpleo(int idCandidato, Empleo empleo);
}
