-- Tabla Usuarios
CREATE TABLE IF NOT EXISTS Usuarios (
    UsuarioID INT AUTO_INCREMENT PRIMARY KEY,
    UserName VARCHAR(50),
    Contraseña VARCHAR(50),
    Nombre VARCHAR(50),
    Apellido VARCHAR(50)
);

-- Insertar usuarios en la tabla Usuarios
INSERT INTO Usuarios (UserName, Contraseña, Nombre, Apellido)
VALUES
('admin', 'admin', 'Admin', 'Admin'),
('juanito', 'juan123', 'Juan', 'Gómez'),
('maria123', 'maria456', 'María', 'Rodríguez'),
('carlitos', 'carlos789', 'Carlos', 'Fernández');


-- Tabla Clientes
CREATE TABLE IF NOT EXISTS Clientes (
    ClienteID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(50),
    Apellido VARCHAR(50),
    FechaNacimiento DATE,
    Genero VARCHAR(10),
    Cuil VARCHAR(20),
    Domicilio VARCHAR(100),
    Localidad VARCHAR(50),
    Provincia VARCHAR(50),
    EstadoCivil VARCHAR(20),
    CantHijos INT,
    Mail VARCHAR(100)
);

-- Insertar clientes en la tabla Clientes
INSERT INTO Clientes (Nombre, Apellido, FechaNacimiento, Genero, Cuil, Domicilio, Localidad, Provincia, EstadoCivil, CantHijos, Mail)
VALUES
('Juan', 'Pérez', '1985-05-10', 'Masculino', '20345678901', 'Calle 123', 'Ciudad A', 'Provincia X', 'Casado', 2, 'juan@example.com'),
('María', 'García', '1990-08-15', 'Femenino', '20456789012', 'Avenida 456', 'Ciudad B', 'Provincia Y', 'Soltera', 0, 'maria@example.com'),
('Pedro', 'López', '1982-02-20', 'Masculino', '20567890123', 'Boulevard 789', 'Ciudad C', 'Provincia Z', 'Viudo', 3, 'pedro@example.com'),
('Ana', 'Martínez', '1978-11-25', 'Femenino', '20678901234', 'Ruta 101', 'Ciudad D', 'Provincia W', 'Casado', 1, 'ana@example.com'),
('Carlos', 'Fernández', '1989-07-05', 'Masculino', '20789012345', 'Calle Principal', 'Ciudad E', 'Provincia V', 'Soltero', 0, 'carlos@example.com');

-- Tabla Servicios
CREATE TABLE IF NOT EXISTS Servicios (
    ServicioID INT AUTO_INCREMENT PRIMARY KEY,
    TipoServicio VARCHAR(50)
);

-- Insertar datos en la tabla Servicios
INSERT INTO Servicios (ServicioID, TipoServicio) VALUES
(1, 'Cambio de Moneda'),
(2, 'Préstamos'),
(3, 'Seguro de Vida'),
(4, 'Seguro de Vehículo'),
(5, 'Seguro de Hogar');

-- Tabla CambioMoneda
CREATE TABLE IF NOT EXISTS CambioMoneda (
    CambioMonedaID INT AUTO_INCREMENT PRIMARY KEY,
    UsuarioID INT,
    ClienteID INT,
    ServicioID INT,
    CantPesos INT,
    TipoMoneda varchar(25),
    ImpPais int,
    ImpGcias int,
    Cambio int,
    -- Otros campos específicos para el servicio de cambio de moneda
    FOREIGN KEY (UsuarioID) REFERENCES Usuarios(UsuarioID),
    FOREIGN KEY (ClienteID) REFERENCES Clientes(ClienteID),
    FOREIGN KEY (ServicioID) REFERENCES Servicios(ServicioID)
);

-- Tabla Prestamos
CREATE TABLE IF NOT EXISTS Prestamos (
    PrestamoID INT AUTO_INCREMENT PRIMARY KEY,
    UsuarioID INT,
    ClienteID INT,
    ServicioID INT,
    Capital int,
    Tiempo int,
    Interes int,
    Cuota int,
    Monto int,
    -- Otros campos específicos para el servicio de préstamos
    FOREIGN KEY (UsuarioID) REFERENCES Usuarios(UsuarioID),
    FOREIGN KEY (ClienteID) REFERENCES Clientes(ClienteID),
    FOREIGN KEY (ServicioID) REFERENCES Servicios(ServicioID)
);

-- Tabla SeguroVida
CREATE TABLE IF NOT EXISTS SeguroVida (
    SeguroVidaID INT AUTO_INCREMENT PRIMARY KEY,
    UsuarioID INT,
    ClienteID INT,
    ServicioID INT,
    -- Otros campos específicos para el seguro de vida
    FOREIGN KEY (UsuarioID) REFERENCES Usuarios(UsuarioID),
    FOREIGN KEY (ClienteID) REFERENCES Clientes(ClienteID),
    FOREIGN KEY (ServicioID) REFERENCES Servicios(ServicioID)
);

-- Tabla SeguroVehiculo
CREATE TABLE IF NOT EXISTS SeguroVehiculo (
    SeguroVehiculoID INT AUTO_INCREMENT PRIMARY KEY,
    UsuarioID INT,
    ClienteID INT,
    ServicioID INT,
    -- Otros campos específicos para el seguro de vehículo
    FOREIGN KEY (UsuarioID) REFERENCES Usuarios(UsuarioID),
    FOREIGN KEY (ClienteID) REFERENCES Clientes(ClienteID),
    FOREIGN KEY (ServicioID) REFERENCES Servicios(ServicioID)
);

-- Tabla SeguroHogar
CREATE TABLE IF NOT EXISTS SeguroHogar (
    SeguroHogarID INT AUTO_INCREMENT PRIMARY KEY,
    UsuarioID INT,
    ClienteID INT,
    ServicioID INT,
    -- Otros campos específicos para el seguro de hogar
    FOREIGN KEY (UsuarioID) REFERENCES Usuarios(UsuarioID),
    FOREIGN KEY (ClienteID) REFERENCES Clientes(ClienteID),
    FOREIGN KEY (ServicioID) REFERENCES Servicios(ServicioID)
);



