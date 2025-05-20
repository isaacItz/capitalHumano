package com.capital.humano.repositorio;

import com.capital.humano.modelo.Candidato;
import com.capital.humano.modelo.Domicilio;
import com.capital.humano.modelo.Empleo;
import com.capital.humano.repositorio.mapper.CandidatoRowMapper;
import oracle.jdbc.OracleTypes;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class CandidatoRepository {
    private final JdbcTemplate jdbcTemplate;

    public CandidatoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertDomicilio(Domicilio domicilio) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("INSERTAR_DOMICILIO");

        MapSqlParameterSource inParams = new MapSqlParameterSource()
                .addValue("P_CALLE", domicilio.getCalle())
                .addValue("P_NUMERO", domicilio.getNumero())
                .addValue("P_COLONIA", domicilio.getColonia())
                .addValue("P_CIUDAD", domicilio.getCiudad())
                .addValue("P_ESTADO", domicilio.getEstado())
                .addValue("P_PAIS", domicilio.getPais())
                .addValue("P_CODIGO_POSTAL", domicilio.getCodigoPostal());

        Map<String, Object> result = jdbcCall.execute(inParams);

        Number idGenerado = (Number) result.get("P_ID_GENERADO");
        System.out.println("ID generado del domicilio: " + idGenerado);

        return idGenerado.intValue();
    }

    public int insertCandidato(Candidato candidato) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("INSERTAR_CANDIDATO_CON_DOMICILIO_ID");

        MapSqlParameterSource inParams = new MapSqlParameterSource()
                .addValue("P_NOMBRES", candidato.getNombres())
                .addValue("P_APELLIDOS", candidato.getApellidos())
                .addValue("P_EMAIL", candidato.getEmail())
                .addValue("P_FECHA_NACIMIENTO", Date.valueOf(candidato.getFechaNacimiento()))
                .addValue("P_RFC", candidato.getRfc())
                .addValue("P_TELEFONO", candidato.getTelefono())
                .addValue("P_DOMICILIO_ID", candidato.getDomicilio().getId());

        Map<String, Object> result = jdbcCall.execute(inParams);

        Number idGenerado = (Number) result.get("P_ID_GENERADO");
        System.out.println("ID generado del candidato: " + idGenerado);

        return idGenerado.intValue();
    }

    public Candidato updateCandidato(Candidato candidato) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("ACTUALIZAR_CANDIDATO");

        MapSqlParameterSource inParams = new MapSqlParameterSource()
                .addValue("P_ID", candidato.getId())
                .addValue("P_NOMBRES", candidato.getNombres())
                .addValue("P_APELLIDOS", candidato.getApellidos())
                .addValue("P_EMAIL", candidato.getEmail())
                .addValue("P_FECHA_NACIMIENTO", Date.valueOf(candidato.getFechaNacimiento()))
                .addValue("P_RFC", candidato.getRfc())
                .addValue("P_TELEFONO", candidato.getTelefono());

        jdbcCall.declareParameters(
                new SqlOutParameter("P_MENSAJE", Types.VARCHAR)
        );

        Map<String, Object> result = jdbcCall.execute(inParams);
        String err = (String) result.get("P_MENSAJE");

        System.out.println("Candidato actualizado correctamente con ID: " + candidato.getId());
        return err.equals("0") ? null : candidato;
    }

    public int eliminarCandidato(int idCandidato) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("ELIMINAR_CANDIDATO");

        MapSqlParameterSource inParams = new MapSqlParameterSource()
                .addValue("P_ID_CANDIDATO", idCandidato);

        jdbcCall.declareParameters(
                new SqlOutParameter("P_MENSAJE", Types.VARCHAR)
        );

        Map<String, Object> result = jdbcCall.execute(inParams);
        System.out.println("Candidato eliminado con ID: " + idCandidato);

        return ((Number) result.get("P_FILAS_AFECTADAS")).intValue();
    }


    public List<Candidato> getCandidatoByEmpresa(String empresa) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("LISTAR_CANDIDATOS_POR_EMPRESA")
                .declareParameters(
                        new SqlParameter("P_NOMBRE_EMPRESA", Types.VARCHAR),
                        new SqlOutParameter("P_RESULTADO", OracleTypes.CURSOR, new CandidatoRowMapper())
                );

        MapSqlParameterSource inParams = new MapSqlParameterSource()
                .addValue("P_NOMBRE_EMPRESA", empresa);

        Map<String, Object> result = jdbcCall.execute(inParams);

        List<Candidato> candidatos = (List<Candidato>) result.get("P_RESULTADO");

        return (candidatos == null || candidatos.isEmpty()) ? null : candidatos;
    }


    public List<Candidato> getCandidatoCon2AñosAntiguedad() {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("LISTAR_CANDIDATOS_CON_ANTIGUEDAD2")
                .declareParameters(
                        new SqlOutParameter("P_RESULTADO", OracleTypes.CURSOR, new CandidatoRowMapper())
                );

        Map<String, Object> result = jdbcCall.execute();

        List<Candidato> candidatos = (List<Candidato>) result.get("P_RESULTADO");

        return (candidatos == null || candidatos.isEmpty()) ? null : candidatos;
    }

    public List<Candidato> getCandidatosConIngresoMayorA10000() {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("CANDIDATOS_INGRESO_MAYOR_10000")
                .declareParameters(
                        new SqlOutParameter("P_RESULTADO", OracleTypes.CURSOR, new CandidatoRowMapper())
                );

        Map<String, Object> result = jdbcCall.execute();

        List<Candidato> candidatos = (List<Candidato>) result.get("P_RESULTADO");

        return (candidatos == null || candidatos.isEmpty()) ? null : candidatos;
    }

    public List<Candidato> getCandidatosCon5AniosAntiguedad() {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("LISTAR_CANDIDATOS_MAS_DE_5_ANIOS")
                .declareParameters(
                        new SqlOutParameter("P_RESULTADO", OracleTypes.CURSOR, new CandidatoRowMapper())
                );

        Map<String, Object> result = jdbcCall.execute();

        List<Candidato> candidatos = (List<Candidato>) result.get("P_RESULTADO");

        return (candidatos == null || candidatos.isEmpty()) ? null : candidatos;
    }

    public List<Candidato> getCandidatosLaborando() {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("LISTAR_CANDIDATOS_ACTUALMENTE_LABORANDO")
                .declareParameters(
                        new SqlOutParameter("P_RESULTADO", OracleTypes.CURSOR, new CandidatoRowMapper())
                );

        Map<String, Object> result = jdbcCall.execute();

        List<Candidato> candidatos = (List<Candidato>) result.get("P_RESULTADO");

        return (candidatos == null || candidatos.isEmpty()) ? null : candidatos;
    }

    public List<Candidato> getCandidatosEnTlalpan() {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("LISTAR_CANDIDATOS_TLALPAN")
                .declareParameters(
                        new SqlOutParameter("P_RESULTADO", OracleTypes.CURSOR, new CandidatoRowMapper())
                );

        Map<String, Object> result = jdbcCall.execute();

        List<Candidato> candidatos = (List<Candidato>) result.get("P_RESULTADO");

        return (candidatos == null || candidatos.isEmpty()) ? null : candidatos;
    }

    public Candidato getCandidatoById(int id) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("GET_CANDIDATO_BY_ID")
                .declareParameters(
                        new SqlParameter("P_ID_CANDIDATO", Types.INTEGER),
                        new SqlOutParameter("P_RESULTADO", OracleTypes.CURSOR, new CandidatoRowMapper())
                );

        Map<String, Object> result = jdbcCall.execute(new MapSqlParameterSource("P_ID_CANDIDATO", id));

        List<Candidato> candidatos = (List<Candidato>) result.get("P_RESULTADO");

        return candidatos.isEmpty() ? null : candidatos.get(0);
    }


    public List<Candidato> listarCandidatos() {

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("LISTAR_CANDIDATOS")
                .declareParameters(
                        new SqlOutParameter("P_RESULTADO", OracleTypes.CURSOR, new CandidatoRowMapper())
                );

        Map<String, Object> result = jdbcCall.execute();

        List<Candidato> candidatos = (List<Candidato>) result.get("P_RESULTADO");

        return (candidatos == null || candidatos.isEmpty()) ? null : candidatos;

    }

    public int insertarCandidatoConDomicilio(
            String nombres,
            String apellidos,
            String email,
            LocalDate fechaNacimiento,
            String rfc,
            String telefono,
            String calle,
            int numero,
            String colonia,
            String ciudad,
            String estado,
            String pais,
            String codigoPostal) {

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("INSERTAR_CANDIDATO_CON_DOMICILIO");

        MapSqlParameterSource inParams = new MapSqlParameterSource()
                .addValue("P_NOMBRES", nombres)
                .addValue("P_APELLIDOS", apellidos)
                .addValue("P_EMAIL", email)
                .addValue("P_FECHA_NACIMIENTO", Date.valueOf(fechaNacimiento))
                .addValue("P_RFC", rfc)
                .addValue("P_TELEFONO", telefono)
                .addValue("P_CALLE", calle)
                .addValue("P_NUMERO", numero)
                .addValue("P_COLONIA", colonia)
                .addValue("P_CIUDAD", ciudad)
                .addValue("P_ESTADO", estado)
                .addValue("P_PAIS", pais)
                .addValue("P_CODIGO_POSTAL", codigoPostal);

        Map<String, Object> result = jdbcCall.execute(inParams);

        Number idGenerado = (Number) result.get("P_CANDIDATO_ID");
        System.out.println("ID generado del candidato: " + idGenerado);

        return idGenerado != null ? idGenerado.intValue() : -1;
    }


}
