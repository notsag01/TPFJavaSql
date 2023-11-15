-- Tabla Usuarios
CREATE TABLE Usuarios (
    UsuarioID INT PRIMARY KEY,
    Nombre VARCHAR(50),
    Apellido VARCHAR(50)
);

-- Tabla Clientes
CREATE TABLE Clientes (
    ClienteID INT PRIMARY KEY,
    Nombre VARCHAR(50),
    Apellido VARCHAR(50)
);

-- Tabla Servicios
CREATE TABLE Servicios (
    ServicioID INT PRIMARY KEY,
    TipoServicio VARCHAR(50)
);

-- Tabla CambioMoneda
CREATE TABLE CambioMoneda (
    CambioMonedaID INT PRIMARY KEY,
    UsuarioID INT,
    ClienteID INT,
    ServicioID INT,
    -- Otros campos específicos para el servicio de cambio de moneda
    FOREIGN KEY (UsuarioID) REFERENCES Usuarios(UsuarioID),
    FOREIGN KEY (ClienteID) REFERENCES Clientes(ClienteID),
    FOREIGN KEY (ServicioID) REFERENCES Servicios(ServicioID)
);

-- Tabla Prestamos
CREATE TABLE Prestamos (
    PrestamoID INT PRIMARY KEY,
    UsuarioID INT,
    ClienteID INT,
    ServicioID INT,
    -- Otros campos específicos para el servicio de préstamos
    FOREIGN KEY (UsuarioID) REFERENCES Usuarios(UsuarioID),
    FOREIGN KEY (ClienteID) REFERENCES Clientes(ClienteID),
    FOREIGN KEY (ServicioID) REFERENCES Servicios(ServicioID)
);

-- Tabla SeguroVida
CREATE TABLE SeguroVida (
    SeguroVidaID INT PRIMARY KEY,
    UsuarioID INT,
    ClienteID INT,
    ServicioID INT,
    -- Otros campos específicos para el seguro de vida
    FOREIGN KEY (UsuarioID) REFERENCES Usuarios(UsuarioID),
    FOREIGN KEY (ClienteID) REFERENCES Clientes(ClienteID),
    FOREIGN KEY (ServicioID) REFERENCES Servicios(ServicioID)
);

-- Tabla SeguroVehiculo
CREATE TABLE SeguroVehiculo (
    SeguroVehiculoID INT PRIMARY KEY,
    UsuarioID INT,
    ClienteID INT,
    ServicioID INT,
    -- Otros campos específicos para el seguro de vehículo
    FOREIGN KEY (UsuarioID) REFERENCES Usuarios(UsuarioID),
    FOREIGN KEY (ClienteID) REFERENCES Clientes(ClienteID),
    FOREIGN KEY (ServicioID) REFERENCES Servicios(ServicioID)
);

-- Tabla SeguroHogar
CREATE TABLE SeguroHogar (
    SeguroHogarID INT PRIMARY KEY,
    UsuarioID INT,
    ClienteID INT,
    ServicioID INT,
    -- Otros campos específicos para el seguro de hogar
    FOREIGN KEY (UsuarioID) REFERENCES Usuarios(UsuarioID),
    FOREIGN KEY (ClienteID) REFERENCES Clientes(ClienteID),
    FOREIGN KEY (ServicioID) REFERENCES Servicios(ServicioID)
);
