<%-- 
    Document   : Principal.jsp
    Created on : 9 dic. 2024, 23:07:38
    Author     : SAULSZSZ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Castores</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <nav style="padding:10px" class="navbar navbar-expand-lg navbar-light bg-info">
            <div class="collapse navbar-collapse" id="navbarNav">
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item active">
                            <a class="navbar-brand" href="#">Castores</a>
                        </li>
                        <li class="nav-item">
                            <a style="margin-left:10px; border:none" class="btn btn-outline-light" href="Controlador?accion=Inventario" target="myFrame">Inventario</a>
                        </li>
                        <li class="nav-item">
                            <a style="margin-left:10px; border:none" class="btn btn-outline-light" href="Controlador?accion=SalidaProducto" target="myFrame">Salida de productos</a>
                        </li>
                        <li class="nav-item">
                            <a style="margin-left:10px; border:none" class="btn btn-outline-light" href="Controlador?accion=Historial" target="myFrame">Historial</a>
                        </li>
                    </ul>
                </div>
                <div class="nav-item dropdown">
                    <button style="border:none" class="btn btn-outline-light dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                        ${usuario.getNombre()}
                    </button>
                    <ul class="dropdown-menu dropdown-menu-end text-center">
                        <li><a class="dropdown-item" href="#"><img src="img/account_circle.png" alt="60" width="60" style="color: black"/></a></li>
                        <li><h6 class="dropdown-header">${usuario.getNombre()}</h6></li>
                        <li><a class="dropdown-item" href="#">${usuario.getNombre()}</a></li>
                        <li><a class="dropdown-item" href="#">${usuario.getCorreo()}</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li>
                            <form action="Validar" method="POST">
                                <button name="accion" value="salir" class="dropdown-item" href="#">Salir</button>
                            </form>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="m-4" style="height: 650px">
            <iframe name="myFrame" style="height: 100%; width: 100%"></iframe>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>