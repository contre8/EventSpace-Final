CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE administrador(
    Login varchar(64) NOT NULL,
    Password varchar(64) NOT NULL,
    PRIMARY KEY (Login)
);

CREATE TABLE propietario (
    NombreEspacio varchar(256) NOT NULL,
    Email varchar(256) NOT NULL,
    Password varchar(64) NOT NULL,
    CIF varchar(20) NOT NULL,
    DomicilioSocial varchar(256) NOT NULL,
    Telefono int NOT NULL,
    Autorizado boolean NOT NULL DEFAULT false,
    PRIMARY KEY (Email)
);

CREATE TABLE cliente (
    Nombre varchar(64) NOT NULL,
    Apellidos varchar (128) NOT NULL,
    Email varchar(256) NOT NULL,
    Password varchar(64) NOT NULL,
    DNI varchar(9) NOT NULL,
    FechaNacimiento varchar(10) NOT NULL,
    Telefono int NOT NULL,
    PRIMARY KEY (DNI)
);

CREATE TABLE espacio (
    ID integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    NombreEspacio varchar(128) NOT NULL,
    Ciudad varchar (128) NOT NULL,
    Direccion varchar(256) NOT NULL,
    NumSalones int NOT NULL,
    Precio numeric(10,2) NOT NULL,
    HorarioIni varchar(5) NOT NULL,
    HorarioFin varchar(5) NOT NULL,
    Propietario varchar(256) NOT NULL,
    FOREIGN KEY (Propietario) REFERENCES Propietario(Email)
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE reservar_espacio (
    ID serial,
    Cliente varchar(9) NOT NULL,
    Espacio integer NOT NULL,
    PRIMARY KEY (ID, Cliente, Espacio),
    FOREIGN KEY (Cliente) REFERENCES Cliente(DNI)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (Espacio) REFERENCES espacio(ID)
        ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO propietario (NombreEspacio, Email, Password, CIF, DomicilioSocial, Telefono)
VALUES ('Mi Salón', 'mi@email.com', crypt('mi_contraseña_secreta', gen_salt('md5')), '12345678X', 'Calle Principal 123', 123456789);

SELECT *
FROM propietario
WHERE Email = 'mi@email.com'
  AND Password = crypt('mi_contraseña_secreta', Password);