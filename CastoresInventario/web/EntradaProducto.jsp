<%-- 
    Document   : RegistrarSalidaProducto
    Created on : 11 dic. 2024, 0:11:23
    Author     : SAULSZSZ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entrada de producto</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>
        <h1>Registrar Entrada de producto</h1>
        <div class="card">
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
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
