package com.capital.humano.repositorio;

import com.capital.humano.modelo.Candidato;
import com.capital.humano.modelo.Empleo;
import com.capital.humano.repositorio.mapper.EmpleoRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Types;
import java.util.List;
import java.util.Map;

@Repository
public class EmpleoRepository {

    private final JdbcTemplate jdbcTemplate;

    public EmpleoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Empleo getEmpleoById(int id) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("GET_EMPLEO_BY_ID")
                .declareParameters(
                        new SqlParameter("P_ID_EMPLEO", Types.INTEGER),
                        new SqlOutParameter("P_RESULTADO", Types.REF_CURSOR, new EmpleoRowMapper())
                );

        Map<String, Object> result = jdbcCall.execute(new MapSqlParameterSource("P_ID_EMPLEO", id));

        List<Empleo> empleos = (List<Empleo>) result.get("P_RESULTADO");

        return empleos.isEmpty() ? null : empleos.get(0);
    }


    public List<Empleo> getEmpleosByCandidatoId(int id) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("GET_EMPLEOS_BY_CANDIDATO_ID")
                .declareParameters(
                        new SqlParameter("P_ID_CANDIDATO", Types.INTEGER),
                        new SqlOutParameter("P_RESULTADO", Types.REF_CURSOR, new EmpleoRowMapper())
                );

        Map<String, Object> result = jdbcCall.execute(new MapSqlParameterSource("P_ID_CANDIDATO", id));

        List<Empleo> empleos = (List<Empleo>) result.get("P_RESULTADO");

        return empleos.isEmpty() ? null : empleos;
    }

    public Empleo actualizarEmpleo(Empleo empleo) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("ACTUALIZAR_EMPLEO");

        MapSqlParameterSource inParams = new MapSqlParameterSource()
                .addValue("p_id", empleo.getId())
                .addValue("p_nombre_empresa", empleo.getNombreEmpresa())
                .addValue("p_fecha_ingreso", Date.valueOf(empleo.getFechaIngreso()))
                .addValue("p_fecha_salida", empleo.getFechaSalida() != null ? Date.valueOf(empleo.getFechaSalida()) : null)
                .addValue("p_ingreso_mensual", empleo.getIngresoMensual())
                .addValue("p_giro_empresa", empleo.getGiroEmpresa());

        jdbcCall.execute(inParams);

        return empleo;
    }


    public int insertarEmpleo(int idCandidato, Empleo empleo) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("INSERTAR_EMPLEO");

        MapSqlParameterSource inParams = new MapSqlParameterSource()
                .addValue("P_CANDIDATO_ID", idCandidato)
                .addValue("P_NOMBRE_EMPRESA", empleo.getNombreEmpresa())
                .addValue("P_FECHA_INGRESO", Date.valueOf(empleo.getFechaIngreso()))
                .addValue("P_FECHA_SALIDA", empleo.getFechaSalida() != null ? Date.valueOf(empleo.getFechaSalida()) : null)
                .addValue("P_INGRESO_MENSUAL", empleo.getIngresoMensual())
                .addValue("P_GIRO_EMPRESA", empleo.getGiroEmpresa());

        Map<String, Object> result = jdbcCall.execute(inParams);

        Number idGenerado = (Number) result.get("P_ID_GENERADO");
        System.out.println("ID generado del empleo: " + idGenerado);

        return idGenerado != null ? idGenerado.intValue() : -1;
    }

    public void insertarEmpleos(Candidato candidato) {
        for (Empleo e : candidato.getEmpleos()) {
            insertarEmpleo(candidato.getId(), e);
        }
    }
}
