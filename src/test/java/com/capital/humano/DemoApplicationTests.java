package com.capital.humano;

import com.capital.humano.modelo.Candidato;
import com.capital.humano.modelo.Domicilio;
import com.capital.humano.repositorio.CandidatoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private CandidatoRepository repository;

	@Test
	void contextLoads() {
	}

    @Test
    public void testprobarInsertarCandidatoConDomicilio() {
        //candidato test
        Candidato candidato = new Candidato();
        candidato.setNombres("Juan");
        candidato.setApellidos("Pérez");
        candidato.setEmail("juan.perez@example.com");
        candidato.setFechaNacimiento(LocalDate.of(1990, 5, 15));
        candidato.setRfc("JUAP900515HDF");
        candidato.setTelefono("5551234567");

        // domicilio existente en bd
        Domicilio domicilio = new Domicilio();
        domicilio.setId(7);
        candidato.setDomicilio(domicilio);

        int id = repository.insertCandidato(candidato);
        // id generado para insertar empleos
        System.out.println(" candidato id: " + id);
    }


    @Test
    void testCreateCandidato() {
        String nombres = "Bob";
        String apellidos = "Perez";
        String email = "bob.perez@gmaile.com";
        LocalDate fechaNacimiento = LocalDate.of(1990, 5, 15);
        String rfc = "vali97515XXX";
        String telefono = "5512345678";
        String calle = "Av Insurgentes Sur";
        int numero = 1234;
        String colonia = "tlalpan";
        String ciudad = "Ciudad de mexico";
        String estado = "cdmx";
        String pais = "mexico";
        String codigoPostal = "14000";
        int expectedIdCandidato = 123;

        int actualIdCandidato = repository.insertarCandidatoConDomicilio(
                nombres, apellidos, email, fechaNacimiento, rfc, telefono, calle, numero,
                colonia, ciudad, estado, pais, codigoPostal
        );

        System.out.println("se inserto con id" + actualIdCandidato);
    }

}
