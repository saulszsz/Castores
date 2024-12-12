CREATE TABLE historico (
  idHistorico int(6) NOT NULL UNIQUE AUTO_INCREMENT,
  idUsuario int(6) NOT NULL,
  idProducto int(6) NOT NULL,
  movimiento varchar(7) NOT NULL,
  cantidad int(6) NOT NULL,
  fecha date NOT NULL,
  PRIMARY KEY(idHistorico)
);

CREATE TABLE productos (
  idProducto int(6) NOT NULL UNIQUE AUTO_INCREMENT,
  nombre varchar(40) NOT NULL,
  descripcion varchar(100) NOT NULL,
  inventario int(6) NOT NULL DEFAULT 0,
  estatus varchar(6) NOT NULL,
  PRIMARY KEY(idProducto)
);

CREATE TABLE rol (
  idRol int(2) NOT NULL UNIQUE AUTO_INCREMENT,
  nombre varchar(100) NOT NULL,
  descripcion varchar(500) NOT NULL,
  PRIMARY KEY(idRol)
);

CREATE TABLE usuarios (
  idUsuario int(6) NOT NULL UNIQUE AUTO_INCREMENT,
  nombre varchar(100) NOT NULL,
  correo varchar(50) NOT NULL,
  contrasena varchar(25) NOT NULL,
  idRol int(2) NOT NULL,
  estatus int(1) NOT NULL,
  PRIMARY KEY(idUsuario)
);

INSERT INTO `rol` (`idRol`, `nombre`, `descripcion`) VALUES 
('1', 'ADMINISTRADOR', 'Ver módulo inventario, Agregar nuevos productos, Aumentar inventario, Dar de baja/reactivar un producto, Ver módulo del histórico'), 
('2', 'ALMACENISTA', 'Ver módulo inventario, Ver módulo para Salida de productos, Sacar inventario del almacén');

COMMIT;