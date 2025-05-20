package com.capital.humano.repositorio.mapper;

import com.capital.humano.modelo.Candidato;
import com.capital.humano.modelo.Domicilio;
import com.capital.humano.modelo.Empleo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleoRowMapper implements RowMapper<Empleo> {
    @Override
    public Empleo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Empleo empleo = new Empleo();
        empleo.setId(rs.getInt("ID"));
        //empleo.setcandidatoid(rs.getInt("CANDIDATO_ID"));
        empleo.setNombreEmpresa(rs.getString("NOMBRE_EMPRESA"));
        empleo.setFechaIngreso(rs.getDate("FECHA_INGRESO").toLocalDate());
        Date fechaSalida = rs.getDate("FECHA_SALIDA");
        empleo.setFechaSalida(fechaSalida != null ? fechaSalida.toLocalDate() : null);
        empleo.setIngresoMensual(rs.getDouble("INGRESO_MENSUAL"));
        empleo.setGiroEmpresa(rs.getString("GIRO_EMPRESA"));
        return empleo;
    }
}
