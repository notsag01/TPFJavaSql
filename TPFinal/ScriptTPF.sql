-- Tabla Usuarios
CREATE TABLE IF NOT EXISTS Usuarios (
    UsuarioID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(50),
    Apellido VARCHAR(50)
);

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

-- Tabla Servicios
CREATE TABLE IF NOT EXISTS Servicios (
    ServicioID INT AUTO_INCREMENT PRIMARY KEY,
    TipoServicio VARCHAR(50)
);

-- Tabla CambioMoneda
CREATE TABLE IF NOT EXISTS CambioMoneda (
    CambioMonedaID INT AUTO_INCREMENT PRIMARY KEY,
    UsuarioID INT,
    ClienteID INT,
    ServicioID INT,
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

-- Insertar datos en la tabla Servicios
INSERT INTO Servicios (ServicioID, TipoServicio) VALUES
(1, 'Cambio de Moneda'),
(2, 'Préstamos'),
(3, 'Seguro de Vida'),
(4, 'Seguro de Vehículo'),
(5, 'Seguro de Hogar');

