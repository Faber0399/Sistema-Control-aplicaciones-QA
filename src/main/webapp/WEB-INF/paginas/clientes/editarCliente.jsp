<%-- 
    Document   : editarCliente
    Created on : Nov 18, 2022, 5:42:56 PM
    Author     : faber
--%>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Editar clientes</title>
    </head>

</head>
<body>
    <%-- Cabeceros de Bootstrap--%>
    <jsp:include page="/WEB-INF/paginas/comunes/cabeceros.jsp"/>
    <form action="${pageContext.request.contextPath}/ServletControlador?accion=modificar&idCliente=${cliente.idCliente}"
          method="POST" class="was-validated">

        <!--Botones de Navegacion -->
        <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacionEdicion.jsp"/>

        <section id="details">
            <div class="container">
                <div class="row">
                    <div class="col">
                        <div class="card border-secondary mb-3" style="max-width: 75rem" >
                            <div class="card-header" >
                                <h4>Editar Cliente</h4>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col">
                                        <div class="form-group" >
                                            <label for="nombre">Nombres</label>
                                            <input type="text" class="form-control" name="nombre" required value="${cliente.nombre}" >
                                        </div>
                                    </div>
                                    <div class="col">
                                        <div class="form-group">
                                            <label for="apellido">Apellidos</label>
                                            <input type="text" class="form-control" name="apellido" required value="${cliente.apellido}" >
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="email">Email</label>
                                    <input type="email" class="form-control" name="email" required value="${cliente.email}">
                                </div>
                                <div class="form-group">
                                    <label for="telefono">Tel�fono</label>
                                    <input type="tel" class="form-control" name="telefono" required value="${cliente.telefono}">
                                </div>
                                <div class="form-group">
                                    <label for="saldo">Saldo</label>
                                    <input type="number" class="form-control" name="saldo" required value="${cliente.saldo}" step="any">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

    </form>
    <%-- Pie de pagina--%>
    <jsp:include page="/WEB-INF/paginas/comunes/footer.jsp"/>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/065e11ef9c.js" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

</body>
</html>
