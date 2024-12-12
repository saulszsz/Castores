<%-- 
    Document   : Historial
    Created on : 11 dic. 2024, 0:04:58
    Author     : SAULSZSZ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Historial</h1>
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
                    <c:forEach var="pro" items="${productos}">
                        <c:if test="${usr.getIdRol() == 1 || pro.getEstatus().equals('ACTIVO')}">
                            <tr>
                                <td>${pro.getIdProducto()}</td>
                                <td>${pro.getNombre()}</td>
                                <td>${pro.getDescripcion()}</td>
                                <td>${pro.getInventario()}</td>
                                <td>${pro.getEstatus()}</td>
                                <td>
                            <c:if test="${usr.getIdRol() == 1}">
                                <a class="btn btn-info" href="Controlador?menu=Inventario&accion=Aumenta&id=${pro.getIdProducto()}">
                                    <img style="width: 30px" src="img/box_add.png" alt=""/>
                                    Aumentar inventario
                                </a>
                            </c:if>
                            <c:if test="${usr.getIdRol() == 2}">
                                <a class="btn btn-info" href="Controlador?menu=Inventario&accion=Saca&id=${pro.getIdProducto()}">
                                    <img style="width: 30px" src="img/package.png" alt=""/>
                                    Sacar inventario
                                </a>
                            </c:if>
                            </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
