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
                                    <a>Aumentar</a>
                                    <a>Sacar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="card col-sm-4">
                <h4>Registrar Entrada de producto</h4>
                <div class="card-body">
                    <form>
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" name="txtNombre" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Descripcion</label>
                            <input type="text" name="txtEstatus" class="form-control">
                        </div>
                        <label>Estatus</label>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="ACTIVO" checked>
                            <label class="form-check-label" for="exampleRadios1">
                                Activo
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios2" value="BAJA">
                            <label class="form-check-label" for="exampleRadios2">
                                Baja
                            </label>
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                    </form>
                </div>
            </div>
        </div>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</html>
