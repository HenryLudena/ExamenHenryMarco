CREATE TABLE IF NOT EXISTS LECTURA_ARCHIVO(
ID_ARCHIVO          INTEGER             PRIMARY KEY AUTOINCREMENT,
Nro                 VARCHAR(3)          NOT NULL,
Codigo              VARCHAR(50)         NOT NULL,
Materia             VARCHAR(100)        NOT NULL,
Paral               VARCHAR(50)         NOT NULL,
Aula                VARCHAR(50)         NOT NULL,
Creditos            VARCHAR(50)         NOT NULL,
Lunes               VARCHAR(50)         NULL,
Martes              VARCHAR(50)         NULL,
Miercoles           VARCHAR(50)         NULL,
Jueves              VARCHAR(50)         NULL,
Viernes             VARCHAR(50)         NULL,
Sabado              VARCHAR(50)         NULL,
Carrera             VARCHAR(100)        NOT NULL,
Obs                 VARCHAR(100)        NULL,
FECHA_INGRESO       VARCHAR(20)         DEFAULT(datetime('now'))
);

-- INSERT INTO LECTURA_ARCHIVO (Nro, Codigo, Materia, Paral, Aula, Creditos, Lunes, Martes, 
--                            Miercoles, Jueves, Viernes, Sabado, Carrera, Obs) VALUES 
--                            ("1", "203o", "Software", "GR2", "E001", "3", "" , "", "", "HOL", "", "", "Programacion", ""); 
DROP TABLE LECTURA_ARCHIVO
