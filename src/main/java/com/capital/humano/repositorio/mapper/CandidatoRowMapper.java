package com.capital.humano.repositorio.mapper;

import com.capital.humano.modelo.Candidato;
import com.capital.humano.modelo.Domicilio;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CandidatoRowMapper implements RowMapper<Candidato> {
    @Override
    public Candidato mapRow(ResultSet rs, int rowNum) throws SQLException {
        Candidato candidato = new Candidato();
        candidato.setId(rs.getInt("ID"));
        candidato.setNombres(rs.getString("NOMBRES"));
        candidato.setApellidos(rs.getString("APELLIDOS"));
        candidato.setEmail(rs.getString("EMAIL"));
        candidato.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO").toLocalDate());
        candidato.setRfc(rs.getString("RFC"));
        candidato.setTelefono(rs.getString("TELEFONO"));
        candidato.setDomicilio(new Domicilio(rs.getInt("DOMICILIO_ID")));
        return candidato;
    }
}
