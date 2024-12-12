<%-- 
    Document   : Historial
    Created on : 11 dic. 2024, 0:04:58
    Author     : SAULSZSZ
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Historial</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <h1>Historial</h1>
        <a class="btn btn-info" href="Controlador?menu=Historial&accion=Listar">
            TODAS
        </a>
        <a class="btn btn-info" href="Controlador?menu=Historial&accion=ListarEntrada">
            ENTRADAS
        </a>
        <a class="btn btn-info" href="Controlador?menu=Historial&accion=ListarSalida">
            SALIDAS
        </a>
        <div class="d-flex">
            <div class="card col-sm-8">
                <table class="table table-hover" border="1">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>USUARIO</th>
                            <th>PRODUCTO</th>
                            <th>MOVIMIENTO</th>
                            <th>CANTIDAD</th>
                            <th>FECHA</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="his" items="${historicos}">
                        <tr>
                            <td>${his.getIdHistorico()}</td>
                            <td>${his.getUsuario()}</td>
                            <td>${his.getProducto()}</td>
                            <td>${his.getMovimiento()}</td>
                            <td>${his.getCantidad()}</td>
                            <td>${his.getFecha()}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</html>
