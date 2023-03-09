<%-- 
    Document   : error.jsp
    Created on : Mar 8, 2023, 8:50:24 PM
    Author     : faber
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Error al ingreso de los datos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="text-center">
                <div>
                    <h1 class="display-1 fw-bold">Error 400!</h1>
                    <p class="fs-3"> <span class="text-danger">Opps!</span> La aplicacion
                        <%
                            String nombre = request.getParameter("Aplicacion").toLowerCase();
                            out.print(nombre);
                        %>          
                        o version <%
                            String version = request.getParameter("version");
                            out.println(version);
                        %> no estan actualmente en desarrollo, las versiones
                        y aplicaciones en desarrollo las puede encontrar en el siguiente cuadro:
                    </p>

                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <div class="card text-center ">
                        <div class="card-header">
                            <h4>Aplicaciones y versiones en desarrollo </h4>
                        </div>

                        <table class="table" >
                            <thead >
                                <tr>
                                    <th>#</th>
                                    <th>Aplicacion</th>
                                    <th>Version</th>
                                </tr>
                            </thead>
                            <tbody>
                                <!-- Iteramos cada elemento de la lista de clientes -->
                                <c:forEach var="aplicacion" items="${aplicaciones}" varStatus="status">
                                    <tr><th scope="row">${status.count}</th>
                                        <td>${aplicacion.nombreAplicacion}</td>
                                        <td>${aplicacion.version}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Volver a la pagina de inicio</h5>
                            <p class="lead">
                                Por favor verifica la aplicacion y la version ingresadas
                            </p>

                            <a href="${pageContext.request.contextPath}/ServletControlador_1" class="btn btn-primary">Inicio</a>
                        </div>
                    </div>
                </div>
                <br>
                <br>

            </div>
        </div>
    </body>
</html>
