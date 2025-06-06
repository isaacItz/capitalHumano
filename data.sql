SELECT username, account_status FROM dba_users;

DROP TABLE DOMICILIO;
CREATE TABLE DOMICILIO (
    ID NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    CALLE VARCHAR2(150),
    NUMERO NUMBER(5),
    COLONIA VARCHAR2(100),
    CIUDAD VARCHAR2(100),
    ESTADO VARCHAR2(100),
    PAIS VARCHAR2(100),
    CODIGO_POSTAL VARCHAR2(10)
);

DROP TABLE CANDIDATO;
CREATE TABLE CANDIDATO (
    ID NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    NOMBRES VARCHAR2(100) NOT NULL,
    APELLIDOS VARCHAR2(100) NOT NULL,
    EMAIL VARCHAR2(100),
    FECHA_NACIMIENTO DATE,
    RFC VARCHAR2(20),
    TELEFONO VARCHAR2(20),
    DOMICILIO_ID NUMBER,
    CONSTRAINT FK_CANDIDATO_DOMICILIO FOREIGN KEY (DOMICILIO_ID) REFERENCES DOMICILIO(ID)
);

DROP TABLE EMPLEO;
CREATE TABLE EMPLEO (
    ID NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY PRIMARY KEY,
    CANDIDATO_ID NUMBER NOT NULL,
    NOMBRE_EMPRESA VARCHAR2(100) NOT NULL,
    FECHA_INGRESO DATE NOT NULL,
    FECHA_SALIDA DATE,
    INGRESO_MENSUAL NUMBER(10, 2),
    GIRO_EMPRESA VARCHAR2(100),
    CONSTRAINT FK_EMPLEO_CANDIDATO FOREIGN KEY (CANDIDATO_ID) REFERENCES CANDIDATO(ID)
);
INSERT INTO DOMICILIO (CALLE, NUMERO, COLONIA, CIUDAD, ESTADO, PAIS, CODIGO_POSTAL) VALUES
('Av. Insurgentes Sur', 1234, 'Tlalpan Centro', 'Ciudad de México', 'CDMX', 'México', '14000');

INSERT INTO DOMICILIO (CALLE, NUMERO, COLONIA, CIUDAD, ESTADO, PAIS, CODIGO_POSTAL) VALUES
('Calle Reforma', 456, 'Juárez', 'Ciudad de México', 'CDMX', 'México', '06600');

INSERT INTO DOMICILIO (CALLE, NUMERO, COLONIA, CIUDAD, ESTADO, PAIS, CODIGO_POSTAL) VALUES
('Av. Universidad', 789, 'Copilco', 'Ciudad de México', 'CDMX', 'México', '04360');

INSERT INTO DOMICILIO (CALLE, NUMERO, COLONIA, CIUDAD, ESTADO, PAIS, CODIGO_POSTAL) VALUES
('Av. Benito Juárez', 321, 'Centro', 'Toluca', 'Estado de México', 'México', '50000');

INSERT INTO DOMICILIO (CALLE, NUMERO, COLONIA, CIUDAD, ESTADO, PAIS, CODIGO_POSTAL) VALUES
('Av. Hidalgo', 654, 'Zona Centro', 'Guadalajara', 'Jalisco', 'México', '44100');

INSERT INTO DOMICILIO (CALLE, NUMERO, COLONIA, CIUDAD, ESTADO, PAIS, CODIGO_POSTAL) VALUES
('Av. Constitución', 987, 'Centro', 'Monterrey', 'Nuevo León', 'México', '64000');

INSERT INTO DOMICILIO (CALLE, NUMERO, COLONIA, CIUDAD, ESTADO, PAIS, CODIGO_POSTAL) VALUES
('Av. Miguel Alemán', 135, 'Las Torres', 'Ciudad de México', 'CDMX', 'México', '09800');

--------
INSERT INTO CANDIDATO (NOMBRES, APELLIDOS, EMAIL, FECHA_NACIMIENTO, RFC, TELEFONO, DOMICILIO_ID) VALUES
('Juan', 'Pérez Gómez', 'juan.perez@gmail.com', TO_DATE('1990-03-15','YYYY-MM-DD'), 'JUAP900315HDFRZN01', '5512345678', 1);

INSERT INTO CANDIDATO (NOMBRES, APELLIDOS, EMAIL, FECHA_NACIMIENTO, RFC, TELEFONO, DOMICILIO_ID) VALUES
('María', 'López Ramírez', 'maria.lopez@gmail.com', TO_DATE('1985-07-22','YYYY-MM-DD'), 'MALR850722MDFRMR02', '5523456789', 2);

INSERT INTO CANDIDATO (NOMBRES, APELLIDOS, EMAIL, FECHA_NACIMIENTO, RFC, TELEFONO, DOMICILIO_ID) VALUES
('Luis', 'Hernández Torres', 'luis.hernandez@gmail.com', TO_DATE('1992-11-05','YYYY-MM-DD'), 'LUHT921105HDFTRS03', '5534567890', 3);

INSERT INTO CANDIDATO (NOMBRES, APELLIDOS, EMAIL, FECHA_NACIMIENTO, RFC, TELEFONO, DOMICILIO_ID) VALUES
('Ana', 'Martínez Ruiz', 'ana.martinez@gmail.com', TO_DATE('1998-01-12','YYYY-MM-DD'), 'ANMR980112MDFTRZ04', '5545678901', 4);

INSERT INTO CANDIDATO (NOMBRES, APELLIDOS, EMAIL, FECHA_NACIMIENTO, RFC, TELEFONO, DOMICILIO_ID) VALUES
('Carlos', 'García Vega', 'carlos.garcia@gmail.com', TO_DATE('1980-09-30','YYYY-MM-DD'), 'CAGV800930HDFRGR05', '5556789012', 5);

INSERT INTO CANDIDATO (NOMBRES, APELLIDOS, EMAIL, FECHA_NACIMIENTO, RFC, TELEFONO, DOMICILIO_ID) VALUES
('Lucía', 'Sánchez Méndez', 'lucia.sanchez@gmail.com', TO_DATE('1995-05-18','YYYY-MM-DD'), 'LUSM950518MDFMNZ06', '5567890123', 6);

INSERT INTO CANDIDATO (NOMBRES, APELLIDOS, EMAIL, FECHA_NACIMIENTO, RFC, TELEFONO, DOMICILIO_ID) VALUES
('Jorge', 'Morales Díaz', 'jorge.morales@gmail.com', TO_DATE('1987-12-01','YYYY-MM-DD'), 'JOMD871201HDFDZR07', '5578901234', 7);

INSERT INTO CANDIDATO (NOMBRES, APELLIDOS, EMAIL, FECHA_NACIMIENTO, RFC, TELEFONO, DOMICILIO_ID) VALUES
('Juan', 'Pérez Gómez', 'juan.perez@gmail.com', TO_DATE('1990-03-15','YYYY-MM-DD'), 'JUAP900315HDFRZN01', '5512345678', 1);

INSERT INTO CANDIDATO (NOMBRES, APELLIDOS, EMAIL, FECHA_NACIMIENTO, RFC, TELEFONO, DOMICILIO_ID) VALUES
('María', 'López Ramírez', 'maria.lopez@gmail.com', TO_DATE('1985-07-22','YYYY-MM-DD'), 'MALR850722MDFRMR02', '5523456789', 2);

INSERT INTO CANDIDATO (NOMBRES, APELLIDOS, EMAIL, FECHA_NACIMIENTO, RFC, TELEFONO, DOMICILIO_ID) VALUES
('Luis', 'Hernández Torres', 'luis.hernandez@gmail.com', TO_DATE('1992-11-05','YYYY-MM-DD'), 'LUHT921105HDFTRS03', '5534567890', 3);

INSERT INTO CANDIDATO (NOMBRES, APELLIDOS, EMAIL, FECHA_NACIMIENTO, RFC, TELEFONO, DOMICILIO_ID) VALUES
('Ana', 'Martínez Ruiz', 'ana.martinez@gmail.com', TO_DATE('1998-01-12','YYYY-MM-DD'), 'ANMR980112MDFTRZ04', '5545678901', 4);

INSERT INTO CANDIDATO (NOMBRES, APELLIDOS, EMAIL, FECHA_NACIMIENTO, RFC, TELEFONO, DOMICILIO_ID) VALUES
('Carlos', 'García Vega', 'carlos.garcia@gmail.com', TO_DATE('1980-09-30','YYYY-MM-DD'), 'CAGV800930HDFRGR05', '5556789012', 5);

INSERT INTO CANDIDATO (NOMBRES, APELLIDOS, EMAIL, FECHA_NACIMIENTO, RFC, TELEFONO, DOMICILIO_ID) VALUES
('Lucía', 'Sánchez Méndez', 'lucia.sanchez@gmail.com', TO_DATE('1995-05-18','YYYY-MM-DD'), 'LUSM950518MDFMNZ06', '5567890123', 6);

INSERT INTO CANDIDATO (NOMBRES, APELLIDOS, EMAIL, FECHA_NACIMIENTO, RFC, TELEFONO, DOMICILIO_ID) VALUES
('Jorge', 'Morales Díaz', 'jorge.morales@gmail.com', TO_DATE('1987-12-01','YYYY-MM-DD'), 'JOMD871201HDFDZR07', '5578901234', 7);


---------

INSERT INTO EMPLEO (CANDIDATO_ID, NOMBRE_EMPRESA, FECHA_INGRESO, FECHA_SALIDA, INGRESO_MENSUAL, GIRO_EMPRESA) VALUES
(1, 'Coca-Cola', TO_DATE('2020-04-01', 'YYYY-MM-DD'), NULL, 12000.00, 'Bebidas');

INSERT INTO EMPLEO (CANDIDATO_ID, NOMBRE_EMPRESA, FECHA_INGRESO, FECHA_SALIDA, INGRESO_MENSUAL, GIRO_EMPRESA) VALUES
(2, 'Nestlé', TO_DATE('2018-02-15', 'YYYY-MM-DD'), TO_DATE('2021-03-01', 'YYYY-MM-DD'), 9500.00, 'Alimentos');

INSERT INTO EMPLEO (CANDIDATO_ID, NOMBRE_EMPRESA, FECHA_INGRESO, FECHA_SALIDA, INGRESO_MENSUAL, GIRO_EMPRESA) VALUES
(3, 'Bimbo', TO_DATE('2017-06-01', 'YYYY-MM-DD'), TO_DATE('2018-06-01', 'YYYY-MM-DD'), 8700.00, 'Panificación');
INSERT INTO EMPLEO (CANDIDATO_ID, NOMBRE_EMPRESA, FECHA_INGRESO, FECHA_SALIDA, INGRESO_MENSUAL, GIRO_EMPRESA) VALUES
(3, 'Pepsi', TO_DATE('2019-01-01', 'YYYY-MM-DD'), TO_DATE('2021-08-01', 'YYYY-MM-DD'), 10500.00, 'Bebidas');

INSERT INTO EMPLEO (CANDIDATO_ID, NOMBRE_EMPRESA, FECHA_INGRESO, FECHA_SALIDA, INGRESO_MENSUAL, GIRO_EMPRESA) VALUES
(4, 'Unilever', TO_DATE('2022-06-01', 'YYYY-MM-DD'), NULL, 9300.00, 'Alimentos');

INSERT INTO EMPLEO (CANDIDATO_ID, NOMBRE_EMPRESA, FECHA_INGRESO, FECHA_SALIDA, INGRESO_MENSUAL, GIRO_EMPRESA) VALUES
(5, 'IBM', TO_DATE('2013-01-01', 'YYYY-MM-DD'), TO_DATE('2018-01-01', 'YYYY-MM-DD'), 11000.00, 'Tecnología');
INSERT INTO EMPLEO (CANDIDATO_ID, NOMBRE_EMPRESA, FECHA_INGRESO, FECHA_SALIDA, INGRESO_MENSUAL, GIRO_EMPRESA) VALUES
(5, 'Oracle', TO_DATE('2018-02-01', 'YYYY-MM-DD'), NULL, 13000.00, 'Tecnología');

INSERT INTO EMPLEO (CANDIDATO_ID, NOMBRE_EMPRESA, FECHA_INGRESO, FECHA_SALIDA, INGRESO_MENSUAL, GIRO_EMPRESA) VALUES
(6, 'CFE', TO_DATE('2021-01-10', 'YYYY-MM-DD'), NULL, 8900.00, 'Energía');

INSERT INTO EMPLEO (CANDIDATO_ID, NOMBRE_EMPRESA, FECHA_INGRESO, FECHA_SALIDA, INGRESO_MENSUAL, GIRO_EMPRESA) VALUES
(7, 'Telmex', TO_DATE('2015-04-01', 'YYYY-MM-DD'), TO_DATE('2019-06-01', 'YYYY-MM-DD'), 9200.00, 'Telecomunicaciones');
INSERT INTO EMPLEO (CANDIDATO_ID, NOMBRE_EMPRESA, FECHA_INGRESO, FECHA_SALIDA, INGRESO_MENSUAL, GIRO_EMPRESA) VALUES
(7, 'Coca-Cola', TO_DATE('2020-01-01', 'YYYY-MM-DD'), NULL, 10200.00, 'Bebidas');


CREATE OR REPLACE PROCEDURE insertar_candidato_con_domicilio (
    p_nombres           IN VARCHAR2,
    p_apellidos         IN VARCHAR2,
    p_email             IN VARCHAR2,
    p_fecha_nacimiento  IN DATE,
    p_rfc               IN VARCHAR2,
    p_telefono          IN VARCHAR2,
    
    -- Domicilio
    p_calle             IN VARCHAR2,
    p_numero            IN NUMBER,
    p_colonia           IN VARCHAR2,
    p_ciudad            IN VARCHAR2,
    p_estado            IN VARCHAR2,
    p_pais              IN VARCHAR2,
    p_codigo_postal     IN VARCHAR2,

    -- salida
    p_candidato_id      OUT NUMBER
) AS
    v_domicilio_id NUMBER;
BEGIN
    -- Insertar domicilio
    INSERT INTO DOMICILIO (
        CALLE, NUMERO, COLONIA, CIUDAD, ESTADO, PAIS, CODIGO_POSTAL
    ) VALUES (
        p_calle, p_numero, p_colonia, p_ciudad, p_estado, p_pais, p_codigo_postal
    )
    RETURNING ID INTO v_domicilio_id;

    -- Insertar candidato
    INSERT INTO CANDIDATO (
        NOMBRES, APELLIDOS, EMAIL, FECHA_NACIMIENTO, RFC, TELEFONO, DOMICILIO_ID
    ) VALUES (
        p_nombres, p_apellidos, p_email, p_fecha_nacimiento, p_rfc, p_telefono, v_domicilio_id
    )
    RETURNING ID INTO p_candidato_id;
    
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE;
END;
/


CREATE OR REPLACE PROCEDURE LISTAR_CANDIDATOS(P_RESULTADO OUT SYS_REFCURSOR) AS
BEGIN
  OPEN P_RESULTADO FOR
    SELECT ID, NOMBRES, APELLIDOS, EMAIL,FECHA_NACIMIENTO, RFC, TELEFONO FROM CANDIDATO;
END;
/

CREATE OR REPLACE PROCEDURE INSERTAR_CANDIDATO_CON_DOMICILIO_ID (
    P_NOMBRES           IN  VARCHAR2,
    P_APELLIDOS         IN  VARCHAR2,
    P_EMAIL             IN  VARCHAR2,
    P_FECHA_NACIMIENTO  IN  DATE,
    P_RFC               IN  VARCHAR2,
    P_TELEFONO          IN  VARCHAR2,
    P_DOMICILIO_ID      IN  NUMBER,
    P_ID_GENERADO       OUT NUMBER
)
AS
BEGIN
    INSERT INTO CANDIDATO (
        NOMBRES, APELLIDOS, EMAIL, FECHA_NACIMIENTO,
        RFC, TELEFONO, DOMICILIO_ID
    ) VALUES (
        P_NOMBRES, P_APELLIDOS, P_EMAIL, P_FECHA_NACIMIENTO,
        P_RFC, P_TELEFONO, P_DOMICILIO_ID
    )
    RETURNING ID INTO P_ID_GENERADO;
END;
/

CREATE OR REPLACE PROCEDURE ACTUALIZAR_CANDIDATO_CON_DOMICILIO_ID (
    P_ID              IN NUMBER,
    P_NOMBRES         IN VARCHAR2,
    P_APELLIDOS       IN VARCHAR2,
    P_EMAIL           IN VARCHAR2,
    P_FECHA_NACIMIENTO IN DATE,
    P_RFC             IN VARCHAR2,
    P_TELEFONO        IN VARCHAR2,
    P_DOMICILIO_ID    IN NUMBER
) AS
BEGIN
    UPDATE CANDIDATO
    SET NOMBRES = P_NOMBRES,
        APELLIDOS = P_APELLIDOS,
        EMAIL = P_EMAIL,
        FECHA_NACIMIENTO = P_FECHA_NACIMIENTO,
        RFC = P_RFC,
        TELEFONO = P_TELEFONO,
        DOMICILIO_ID = P_DOMICILIO_ID
    WHERE ID = P_ID;
END;
/


CREATE OR REPLACE PROCEDURE ACTUALIZAR_CANDIDATO(
    P_ID              IN NUMBER,
    P_NOMBRES         IN VARCHAR2,
    P_APELLIDOS       IN VARCHAR2,
    P_EMAIL           IN VARCHAR2,
    P_FECHA_NACIMIENTO IN DATE,
    P_RFC             IN VARCHAR2,
    P_TELEFONO        IN VARCHAR2,
    P_MENSAJE OUT VARCHAR2
) AS
BEGIN
    UPDATE CANDIDATO
    SET NOMBRES = P_NOMBRES,
        APELLIDOS = P_APELLIDOS,
        EMAIL = P_EMAIL,
        FECHA_NACIMIENTO = P_FECHA_NACIMIENTO,
        RFC = P_RFC,
        TELEFONO = P_TELEFONO
    WHERE ID = P_ID;
    
    IF SQL%ROWCOUNT = 0 THEN
        P_MENSAJE := '0';
    ELSE
        P_MENSAJE := '1';
    END IF;
END;
/


CREATE OR REPLACE PROCEDURE ELIMINAR_CANDIDATO (
    P_ID_CANDIDATO IN NUMBER,
    P_FILAS_AFECTADAS  OUT NUMBER
) AS
BEGIN
    DELETE FROM EMPLEO WHERE CANDIDATO_ID = P_ID_CANDIDATO;
    DELETE FROM CANDIDATO WHERE ID = P_ID_CANDIDATO;
    
    P_FILAS_AFECTADAS := SQL%ROWCOUNT;
    
    EXCEPTION
    WHEN OTHERS THEN
        P_FILAS_AFECTADAS := -1; 
END;
/

CREATE OR REPLACE PROCEDURE GET_CANDIDATO_BY_ID (
    P_ID_CANDIDATO IN NUMBER,
    P_RESULTADO OUT SYS_REFCURSOR
) AS
BEGIN
    OPEN P_RESULTADO FOR
    SELECT 
        c.ID,
        c.NOMBRES,
        c.APELLIDOS,
        c.EMAIL,
        c.FECHA_NACIMIENTO,
        c.RFC,
        c.TELEFONO,
        c.DOMICILIO_ID
    FROM CANDIDATO c
    WHERE c.ID = P_ID_CANDIDATO;
END;
/

CREATE OR REPLACE PROCEDURE LISTAR_CANDIDATOS_POR_EMPRESA (
    P_NOMBRE_EMPRESA IN VARCHAR2,
    P_RESULTADO OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN P_RESULTADO FOR
        SELECT 
            c.ID,
            c.NOMBRES,
            c.APELLIDOS,
            c.EMAIL,
            c.FECHA_NACIMIENTO,
            c.RFC,
            c.TELEFONO
        FROM 
            CANDIDATO c
        INNER JOIN 
            EMPLEO e ON c.ID = e.CANDIDATO_ID
        WHERE 
            LOWER(e.NOMBRE_EMPRESA) LIKE LOWER('%' || P_NOMBRE_EMPRESA || '%');
END;
/

CREATE OR REPLACE PROCEDURE LISTAR_CANDIDATOS_CON_ANTIGUEDAD2 (
    P_RESULTADO OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN P_RESULTADO FOR
        SELECT C.*
        FROM CANDIDATO C
        WHERE C.ID IN (
            SELECT E.CANDIDATO_ID
            FROM EMPLEO E
            WHERE E.FECHA_SALIDA IS NULL
              AND MONTHS_BETWEEN(SYSDATE, E.FECHA_INGRESO) > 24
        );
END;
/

CREATE OR REPLACE PROCEDURE CANDIDATOS_INGRESO_MAYOR_10000 (
    P_RESULTADO OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN P_RESULTADO FOR
        SELECT DISTINCT C.*
        FROM CANDIDATO C
        JOIN EMPLEO E ON C.ID = E.CANDIDATO_ID
        WHERE E.INGRESO_MENSUAL > 10000;
END;
/

CREATE OR REPLACE PROCEDURE LISTAR_CANDIDATOS_MAS_DE_5_ANIOS (
    P_RESULTADO OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN P_RESULTADO FOR
        SELECT C.*
        FROM CANDIDATO C
        JOIN (
            SELECT CANDIDATO_ID,
                   SUM(
                       MONTHS_BETWEEN(
                           NVL(FECHA_SALIDA, SYSDATE),
                           FECHA_INGRESO
                       )
                   ) / 12 AS ANIOS_EXPERIENCIA
            FROM EMPLEO
            GROUP BY CANDIDATO_ID
            HAVING SUM(MONTHS_BETWEEN(NVL(FECHA_SALIDA, SYSDATE), FECHA_INGRESO)) / 12 > 5
        ) E ON C.ID = E.CANDIDATO_ID;
END;
/

CREATE OR REPLACE PROCEDURE LISTAR_CANDIDATOS_ACTUALMENTE_LABORANDO (
    P_RESULTADO OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN P_RESULTADO FOR
        SELECT DISTINCT C.*
        FROM CANDIDATO C
        JOIN EMPLEO E ON C.ID = E.CANDIDATO_ID
        WHERE E.FECHA_SALIDA IS NULL;
END;
/

CREATE OR REPLACE PROCEDURE LISTAR_CANDIDATOS_TLALPAN (
    P_RESULTADO OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN P_RESULTADO FOR
        SELECT C.*
        FROM CANDIDATO C
        JOIN DOMICILIO D ON C.DOMICILIO_ID = D.ID
        WHERE D.COLONIA = 'Tlalpan'
          AND D.CODIGO_POSTAL = '14000';
END;
/

CREATE OR REPLACE PROCEDURE INSERTAR_DOMICILIO (
    P_CALLE          IN VARCHAR2,
    P_NUMERO         IN VARCHAR2,
    P_COLONIA        IN VARCHAR2,
    P_CIUDAD         IN VARCHAR2,
    P_ESTADO         IN VARCHAR2,
    P_PAIS           IN VARCHAR2,
    P_CODIGO_POSTAL  IN VARCHAR2,
    P_ID_GENERADO    OUT NUMBER
) AS
BEGIN
    INSERT INTO DOMICILIO (
        CALLE, NUMERO, COLONIA, CIUDAD, ESTADO, PAIS, CODIGO_POSTAL
    ) VALUES (
        P_CALLE, P_NUMERO, P_COLONIA, P_CIUDAD, P_ESTADO, P_PAIS, P_CODIGO_POSTAL
    )
    RETURNING ID INTO P_ID_GENERADO;
END;
/

CREATE OR REPLACE PROCEDURE INSERTAR_EMPLEO (
    P_CANDIDATO_ID    IN NUMBER,
    P_NOMBRE_EMPRESA  IN VARCHAR2,
    P_FECHA_INGRESO   IN DATE,
    P_FECHA_SALIDA    IN DATE,
    P_INGRESO_MENSUAL IN NUMBER,
    P_GIRO_EMPRESA    IN VARCHAR2,
    P_ID_GENERADO     OUT NUMBER
) AS
BEGIN
    INSERT INTO EMPLEO (
        CANDIDATO_ID, NOMBRE_EMPRESA, FECHA_INGRESO, FECHA_SALIDA, INGRESO_MENSUAL, GIRO_EMPRESA
    ) VALUES (
        P_CANDIDATO_ID, P_NOMBRE_EMPRESA, P_FECHA_INGRESO, P_FECHA_SALIDA, P_INGRESO_MENSUAL, P_GIRO_EMPRESA
    )
    RETURNING ID INTO P_ID_GENERADO;
END;
/


CREATE OR REPLACE PROCEDURE ACTUALIZAR_EMPLEO (
    p_id              IN NUMBER,
    p_nombre_empresa  IN VARCHAR2,
    p_fecha_ingreso   IN DATE,
    p_fecha_salida    IN DATE,
    p_ingreso_mensual IN NUMBER,
    p_giro_empresa    IN VARCHAR2
)
AS
BEGIN
    UPDATE EMPLEO
    SET
        NOMBRE_EMPRESA = p_nombre_empresa,
        FECHA_INGRESO = p_fecha_ingreso,
        FECHA_SALIDA = p_fecha_salida,
        INGRESO_MENSUAL = p_ingreso_mensual,
        GIRO_EMPRESA = p_giro_empresa
    WHERE ID = p_id;

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        RAISE;
END ACTUALIZAR_EMPLEO;
/

CREATE OR REPLACE PROCEDURE GET_EMPLEO_BY_ID (
    P_ID_EMPLEO IN NUMBER,
    P_RESULTADO OUT SYS_REFCURSOR
) AS
BEGIN
    OPEN P_RESULTADO FOR
    SELECT 
        e.ID,
        e.CANDIDATO_ID,
        e.NOMBRE_EMPRESA,
        e.FECHA_INGRESO,
        e.FECHA_SALIDA,
        e.INGRESO_MENSUAL,
        e.GIRO_EMPRESA
    FROM EMPLEO e
    WHERE e.ID = P_ID_EMPLEO;
END;
/

CREATE OR REPLACE PROCEDURE GET_EMPLEOS_BY_CANDIDATO_ID (
    P_ID_CANDIDATO IN NUMBER,
    P_RESULTADO OUT SYS_REFCURSOR
) AS
BEGIN
    OPEN P_RESULTADO FOR
    SELECT 
        e.ID,
        e.CANDIDATO_ID,
        e.NOMBRE_EMPRESA,
        e.FECHA_INGRESO,
        e.FECHA_SALIDA,
        e.INGRESO_MENSUAL,
        e.GIRO_EMPRESA
    FROM EMPLEO e
    WHERE e.CANDIDATO_ID = P_ID_CANDIDATO;
END;
/