<%-- 
    Document   : Inventario
    Created on : 11 dic. 2024, 0:04:40
    Author     : SAULSZSZ
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventario</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <h1>Inventario</h1>
        <div class="d-flex">
            <div class="card col-sm-8">
                <table class="table table-hover" border="1">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>NOMBRE</th>
                            <th>DESCRIPCION</th>
                            <th>INVENTARIO</th>
                            <th>ESTATUS</th>
                            <th>ACCION</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="pro" items="${productos}">
                            <tr>
                                <td>${pro.getIdProducto()}</td>
                                <td>${pro.getNombre()}</td>
                                <td>${pro.getDescripcion()}</td>
                                <td>${pro.getInventario()}</td>
                                <td>${pro.getEstatus()}</td>
                                <td>
                                    <a class="btn btn-info" href="Controlador?menu=Inventario&accion=Aumenta&id=${pro.getIdProducto()}">
                                        <img style="width: 30px" src="img/box_add.png" alt=""/>
                                    </a>
                                    <a class="btn btn-info" href="Controlador?menu=Inventario&accion=Saca&id=${pro.getIdProducto()}">
                                        <img style="width: 30px" src="img/package.png" alt=""/>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

            <div class="card col-sm-4">
                <h4>Agregar producto</h4>
                <div class="card-body">
                    <form action="Controlador?menu=Inventario" method="POST">
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" name="txtNombre" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Descripcion</label>
                            <input type="text" name="txtDescripcion" class="form-control">
                        </div>
                        <div class="input-group">
                            <label class="input-group-text" for="inputGroupSelect01">Estatus</label>
                            <select class="form-select" name="selEstatus" aria-label="Default select example">
                                <option value="ACTIVO">Activo</option>
                                <option value="BAJA">Baja</option>
                            </select>
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                    </form>
                </div>
            </div>

            <div class="card col-sm-4 d-none">
                <h4>Aumentar inventario</h4>
                <div class="card-body">
                    <form action="Controlador?menu=Inventario" method="POST">
                        <div class="form-group input-group">
                            <label style="width: 100px" class="input-group-text">IdProducto</label>
                            <input type="text" value="${producto.getIdProducto()}" name="txtIdProductoAu" class="form-control" >
                        </div>
                        <div class="form-group input-group">
                            <label style="width: 100px" class="input-group-text">Nombre</label>
                            <input type="text" value="${producto.getNombre()}" name="txtNombreAu" class="form-control">
                        </div>
                        <div class="form-group input-group">
                            <label style="width: 100px" class="input-group-text">Descripcion</label>
                            <input type="text" value="${producto.getDescripcion()}" name="txtDescripcionAu" class="form-control">
                        </div>
                        <div class="form-group input-group">
                            <label style="width: 100px" class="input-group-text">Inventario</label>
                            <input type="text" value="${producto.getInventario()}" name="txtInventarioAu" class="form-control">
                        </div>
                        <div class="form-group input-group">
                            <label style="width: 100px" class="input-group-text">Estatus</label>
                            <input type="text" value="${producto.getEstatus()}" name="txtEstatusAu" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Cantidad a aumentar</label>
                            <input type="number" name="txtAumentar" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Aumentar" class="btn btn-success">
                    </form>
                </div>
            </div>
        </div>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</html>
