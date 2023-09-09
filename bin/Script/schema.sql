CREATE TABLE IF NOT EXISTS LL_TIPO_ARSENAL(
    LlIdTipoArsenal           INTEGER          PRIMARY KEY AUTOINCREMENT,
    LlTipoArsenal             VARCHAR(50)      NOT NULL,
    Estado                    VARCHAR(1)       DEFAULT('A')
);

-- INSERT INTO LL_TIPO_ARSENAL (LlTipoArsenal) VALUES ('Aereo');

-- CREATE TABLE LL_ARSENAL(
--    LlIdArsenal                 INTEGER             PRIMARY KEY AUTOINCREMENT,
--     LlArsenal                   VARCHAR(50)        NOT NULL
-- );

-- INSERT INTO LL_ARSENAL (LlArsenal) VALUES ('Avion');

CREATE TABLE IF NOT EXISTS LL_COORDENADAS (
   LlIdCoordenadas               INTEGER          PRIMARY KEY AUTOINCREMENT,
   LlCoordenadas                 VARCHAR(50)      NOT NULL
);

-- INSERT INTO LL_COORDENADAS (LlCoordenadas) VALUES ('01-Coord_North');


CREATE TABLE IF NOT EXISTS LL_DIAS(
    IdDias                  INTEGER     PRIMARY KEY AUTOINCREMENT,
    Lunes                   VARCHAR(50) NULL,
    Martes                  VARCHAR(50) NULL,
    Miercoles               VARCHAR(50) NULL,
    Jueves				    VARCHAR(50) NULL,
    Viernes                 VARCHAR(50) NULL,
    Estado                  VARCHAR(5)  DEFAULT('A')
);

-- INSERT INTO LL_DIAS (Lunes, Martes, Miercoles, Jueves, Viernes) VALUES ("", "", "", "", "01-02");

CREATE TABLE IF NOT EXISTS LL_USUARIO (
IdUsuario                   INTEGER             PRIMARY KEY AUTOINCREMENT,
Nombre                      VARCHAR(50)         NOT NULL , -- Nombre del usuario
Estado                      VARCHAR(50)         DEFAULT ('A')
);
-- INSERT INTO LL_USUARIO (Nombre) VALUES ("Pepe");




