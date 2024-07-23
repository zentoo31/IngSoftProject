create database Florinvent
go

use master
go

use Florinvent
go

drop database Florinvent
go

CREATE TABLE Usuario (
    id_usuario INT PRIMARY KEY identity,
    nombre NVARCHAR(100) NOT NULL,
    correo NVARCHAR(100) UNIQUE NOT NULL,
    rol NVARCHAR(50) CHECK (rol IN ('jefe', 'personal')) NOT NULL,
	username NVARCHAR(100) not null,
	contraseña NVARCHAR(255) NOT NULL
);

alter table Usuario
add username NVARCHAR(100) NOT NULL
go

delete from Usuario
where id_usuario = 8
go

EXEC sp_rename 'Usuario.idUsuario', 'id_usuario', 'COLUMN';

-- Insertar dos usuarios en la tabla Usuario
INSERT INTO Usuario (nombre, correo, rol, username, contraseña)
VALUES
( 'Juan Pérez', 'juan@example.com', 'jefe', 'juan123', 'password123'),
( 'María López', 'maria@example.com', 'personal','maria123', 'securepassword');

select * from Usuario
go

DECLARE @id_usuario INT = 1; -- Reemplaza con el valor de :idUsuario
DECLARE @password NVARCHAR(255) = 'password123'; -- Reemplaza con el valor de :password

SELECT CASE WHEN COUNT(u.id_usuario) > 0 THEN 1 ELSE 0 END AS UserExists
FROM Usuario u
WHERE u.id_usuario = @id_usuario
AND u.contraseña = @password;



CREATE TABLE Almacen (
    idAlmacen INT PRIMARY KEY,
    nombre NVARCHAR(100) UNIQUE NOT NULL,
    ubicacion NVARCHAR(100) NOT NULL
);

INSERT INTO Almacen (idAlmacen, nombre, ubicacion)
VALUES (1, 'Almacen 1', 'Piso 1');
 
INSERT INTO Almacen (idAlmacen, nombre, ubicacion)
VALUES (2, 'Almacen 2', 'Piso 1');

INSERT INTO Almacen (idAlmacen, nombre, ubicacion)
VALUES (3, 'Almacen 3', 'Piso 1');

INSERT INTO Almacen (idAlmacen, nombre, ubicacion)
VALUES (4, 'Almacen 4', 'Piso 1');

INSERT INTO Almacen (idAlmacen, nombre, ubicacion)
VALUES (5, 'Almacen 5', 'Piso 1');

INSERT INTO Almacen (idAlmacen, nombre, ubicacion)
VALUES (6, 'Almacen 6', 'Piso 1');


CREATE TABLE Producto (
    idProducto INT PRIMARY KEY,
    nombre NVARCHAR(100) NOT NULL,
	precio numeric(10,2) not null,
    descripcion NVARCHAR(255) NOT NULL,
    cantidad INT CHECK (cantidad >= 0),
    idAlmacen INT,
    CONSTRAINT FK_Producto_Almacen FOREIGN KEY (idAlmacen) REFERENCES Almacen(idAlmacen)
);

INSERT INTO Producto (idProducto, nombre, precio, descripcion, cantidad, idAlmacen)
VALUES (1, 'Producto 1', 10.50, 'Descripción del Producto 1', 100, 1);

INSERT INTO Producto (idProducto, nombre, precio, descripcion, cantidad, idAlmacen)
VALUES (2, 'Producto 2', 15.75, 'Descripción del Producto 2', 200, 2);

INSERT INTO Producto (idProducto, nombre, precio, descripcion, cantidad, idAlmacen)
VALUES (3, 'Producto 3', 20.00, 'Descripción del Producto 3', 150, 3);

INSERT INTO Producto (idProducto, nombre, precio, descripcion, cantidad, idAlmacen)
VALUES (4, 'Producto 4', 25.00, 'Descripción del Producto 4', 250, 1);

INSERT INTO Producto (idProducto, nombre, precio, descripcion, cantidad, idAlmacen)
VALUES (5, 'Producto 5', 30.00, 'Descripción del Producto 5', 300, 2);

INSERT INTO Producto (idProducto, nombre, precio, descripcion, cantidad, idAlmacen)
VALUES (6, 'Producto 6', 35.00, 'Descripción del Producto 6', 350, 3);

INSERT INTO Producto (idProducto, nombre, precio, descripcion, cantidad, idAlmacen)
VALUES (7, 'Producto 7', 40.00, 'Descripción del Producto 7', 400, 1);

INSERT INTO Producto (idProducto, nombre, precio, descripcion, cantidad, idAlmacen)
VALUES (8, 'Producto 8', 45.00, 'Descripción del Producto 8', 450, 2);

INSERT INTO Producto (idProducto, nombre, precio, descripcion, cantidad, idAlmacen)
VALUES (9, 'Producto 9', 50.00, 'Descripción del Producto 9', 500, 3);

INSERT INTO Producto (idProducto, nombre, precio, descripcion, cantidad, idAlmacen)
VALUES (10, 'Producto 10', 55.00, 'Descripción del Producto 10', 550, 1);

INSERT INTO Producto (idProducto, nombre, precio, descripcion, cantidad, idAlmacen)
VALUES (11, 'Producto 11', 60.00, 'Descripción del Producto 11', 600, 2);

INSERT INTO Producto (idProducto, nombre, precio, descripcion, cantidad, idAlmacen)
VALUES (12, 'Producto 12', 65.00, 'Descripción del Producto 12', 650, 3);

INSERT INTO Producto (idProducto, nombre, precio, descripcion, cantidad, idAlmacen)
VALUES (13, 'Producto 13', 70.00, 'Descripción del Producto 13', 700, 1);

INSERT INTO Producto (idProducto, nombre, precio, descripcion, cantidad, idAlmacen)
VALUES (14, 'Producto 14', 60.00, 'Descripción del Producto 14', 600, 4);

INSERT INTO Producto (idProducto, nombre, precio, descripcion, cantidad, idAlmacen)
VALUES (15, 'Producto 15', 65.00, 'Descripción del Producto 15', 650, 5);

INSERT INTO Producto (idProducto, nombre, precio, descripcion, cantidad, idAlmacen)
VALUES (16, 'Producto 16', 70.00, 'Descripción del Producto 16', 700, 6);

select * from Producto
go

CREATE PROCEDURE sp_ProductosBajosEnStock
    @umbral INT
AS
BEGIN
    SELECT 
        idProducto,
        nombre,
        cantidad
    FROM 
        Producto
    WHERE 
        cantidad < @umbral;
END;
GO

EXEC sp_ProductosBajosEnStock 150;

CREATE TABLE HistorialUbicaciones (
    idProducto INT,
    idAlmacen INT,
    fechaRegistro DATETIME,
    FOREIGN KEY (idProducto) REFERENCES Producto(idProducto),
    FOREIGN KEY (idAlmacen) REFERENCES Almacen(idAlmacen)
);
GO

CREATE TRIGGER trg_RegistroCambioAlmacen
ON Producto
AFTER UPDATE
AS
BEGIN
    IF UPDATE(idAlmacen)
    BEGIN
        INSERT INTO HistorialUbicaciones (idProducto, idAlmacen, fechaRegistro)
        SELECT 
            i.idProducto,
            i.idAlmacen,
            GETDATE()
        FROM 
            inserted i;
    END
END;
GO

UPDATE Producto
SET idAlmacen = 2
WHERE idProducto = 1;
GO

CREATE PROCEDURE sp_ConsultarHistorialUbicaciones
AS
BEGIN
    SELECT 
        p.nombre AS nombreProducto,
        a.nombre AS nombreAlmacen,
        h.fechaRegistro
    FROM 
        HistorialUbicaciones h
    JOIN 
        Producto p ON h.idProducto = p.idProducto
    JOIN 
        Almacen a ON h.idAlmacen = a.idAlmacen;
END;
GO

EXEC sp_ConsultarHistorialUbicaciones;
GO

CREATE VIEW vw_ConsultarHistorialUbicaciones AS
SELECT 
    p.nombre AS nombreProducto,
    a.nombre AS nombreAlmacen,
    h.fechaRegistro
FROM 
    HistorialUbicaciones h
JOIN 
    Producto p ON h.idProducto = p.idProducto
JOIN 
    Almacen a ON h.idAlmacen = a.idAlmacen;
GO

SELECT * FROM vw_ConsultarHistorialUbicaciones;
GO

CREATE PROCEDURE sp_ActualizarUbicacionProducto
    @nombreProducto NVARCHAR(100),
    @nombreAlmacen NVARCHAR(100)
AS
BEGIN
    DECLARE @idProducto INT;
    DECLARE @idAlmacen INT;

    -- Obtener el idProducto
    SELECT @idProducto = idProducto
    FROM Producto
    WHERE nombre = @nombreProducto;

    -- Obtener el idAlmacen
    SELECT @idAlmacen = idAlmacen
    FROM Almacen
    WHERE nombre = @nombreAlmacen;

    -- Verificar si se encontraron los IDs
    IF @idProducto IS NULL
    BEGIN
        RAISERROR ('Producto no encontrado.', 16, 1);
        RETURN;
    END

    IF @idAlmacen IS NULL
    BEGIN
        RAISERROR ('Almacen no encontrado.', 16, 1);
        RETURN;
    END

    -- Actualizar la ubicación del producto
    UPDATE Producto
    SET idAlmacen = @idAlmacen
    WHERE idProducto = @idProducto;
END;
GO

EXEC sp_ActualizarUbicacionProducto 'Producto 1', 'Almacen 2'
go

CREATE TABLE Devolucion (
    idDevolucion INT PRIMARY KEY,
    fecha datetime NOT NULL,
    producto NVARCHAR(100) NOT NULL,
    motivo NVARCHAR(255) NOT NULL,
    idProducto INT,
    idUsuario INT,
    CONSTRAINT FK_Devolucion_Producto FOREIGN KEY (idProducto) REFERENCES Producto(idProducto),
    CONSTRAINT FK_Devolucion_Usuario FOREIGN KEY (idUsuario) REFERENCES Usuario(id_usuario)
);


CREATE TABLE Proveedor (
    idProveedor INT PRIMARY KEY,
    nombre NVARCHAR(100) UNIQUE NOT NULL,
    direccion NVARCHAR(255) NOT NULL,
    telefono NVARCHAR(50) NOT NULL
);

INSERT INTO Proveedor (idProveedor, nombre, direccion, telefono)
VALUES 
(1, 'Proveedor 1', 'Calle 123', '555-1234'),
(2, 'Proveedor 2', 'Avenida 456', '555-5678');

CREATE TABLE Pedido (
    idPedido INT PRIMARY KEY,
    fecha Datetime NOT NULL,
    estado NVARCHAR(50) CHECK (estado IN ('pendiente', 'enviado', 'cancelado')) NOT NULL,
    total DECIMAL(10, 2) NOT NULL,
    idProveedor INT,
    idUsuario INT,
    CONSTRAINT FK_Pedido_Proveedor FOREIGN KEY (idProveedor) REFERENCES Proveedor(idProveedor),
    CONSTRAINT FK_Pedido_Usuario FOREIGN KEY (idUsuario) REFERENCES Usuario(id_usuario)
);

INSERT INTO Pedido (idPedido, fecha, estado, total, idProveedor, idUsuario)
VALUES 
(1, GETDATE(), 'pendiente', 200.00, 1, 1),
(2, GETDATE(), 'enviado', 350.00, 2, 2);

CREATE TABLE PedidoDetalle (
    idDetalle INT PRIMARY KEY,
    idPedido INT,
    idProducto INT,
    cantidad INT CHECK (cantidad > 0),
    precio DECIMAL(10, 2) NOT NULL,
    CONSTRAINT FK_PedidoDetalle_Pedido FOREIGN KEY (idPedido) REFERENCES Pedido(idPedido),
    CONSTRAINT FK_PedidoDetalle_Producto FOREIGN KEY (idProducto) REFERENCES Producto(idProducto)
);
GO

INSERT INTO PedidoDetalle (idDetalle, idPedido, idProducto, cantidad, precio)
VALUES 
(1, 1, 1, 10, 10.00), -- Pedido 1, Producto 1
(2, 1, 2, 5, 20.00), -- Pedido 1, Producto 2
(3, 2, 3, 15, 10.00), -- Pedido 2, Producto 3
(4, 2, 4, 10, 20.00); -- Pedido 2, Producto 4
GO

CREATE PROCEDURE sp_VerPedidosPendientes
AS
BEGIN
    SET NOCOUNT ON;

    SELECT 
        p.idPedido,
        p.fecha,
        p.estado,
        p.total,
        pr.nombre AS nombreProveedor
    FROM 
        Pedido p
    JOIN 
        Proveedor pr ON p.idProveedor = pr.idProveedor
    WHERE 
        p.estado = 'pendiente';
END;
GO

EXEC sp_VerPedidosPendientes;
GO

CREATE PROCEDURE sp_VerDetallePedido
    @idPedido INT
AS
BEGIN
    SET NOCOUNT ON;

    SELECT 
        p.idPedido,
        pr.nombre AS nombreProveedor,
        prd.nombre AS nombreProducto,
        pd.cantidad,
        pd.precio
    FROM 
        Pedido p
    JOIN 
        PedidoDetalle pd ON p.idPedido = pd.idPedido
    JOIN 
        Producto prd ON pd.idProducto = prd.idProducto
    JOIN 
        Proveedor pr ON p.idProveedor = pr.idProveedor
    WHERE 
        p.idPedido = @idPedido;
END;
GO

EXEC sp_VerDetallePedido 1;
GO

alter VIEW vw_VerDetallePedido AS
SELECT 
    p.idPedido,
    pr.nombre AS nombreProveedor,
    prd.nombre AS nombreProducto,
    pd.cantidad,
    pd.precio,
    a.nombre AS nombreAlmacen
FROM 
    Pedido p
JOIN 
    PedidoDetalle pd ON p.idPedido = pd.idPedido
JOIN 
    Producto prd ON pd.idProducto = prd.idProducto
JOIN 
    Proveedor pr ON p.idProveedor = pr.idProveedor
JOIN 
    Almacen a ON prd.idAlmacen = a.idAlmacen;
GO

SELECT *
FROM vw_VerDetallePedido
WHERE idPedido = 1; -- Reemplaza 1 con el idPedido que deseas filtrar



CREATE VIEW vw_VerDetallePedido AS
SELECT 
    p.idPedido,
    pr.nombre AS nombreProveedor,
    prd.nombre AS nombreProducto,
    pd.cantidad,
    pd.precio
FROM 
    Pedido p
JOIN 
    PedidoDetalle pd ON p.idPedido = pd.idPedido
JOIN 
    Producto prd ON pd.idProducto = prd.idProducto
JOIN 
    Proveedor pr ON p.idProveedor = pr.idProveedor;
GO

SELECT * FROM vw_VerDetallePedido WHERE idPedido = 1;


CREATE TABLE ReporteInventario (
    idUltoria INT PRIMARY KEY,
    fecha Datetime NOT NULL,
    resultado NVARCHAR(255) NOT NULL,
    idUsuario INT,
    CONSTRAINT FK_ReporteInventario_Usuario FOREIGN KEY (idUsuario) REFERENCES Usuario(id_usuario)
);
GO

