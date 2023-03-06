<%-- 
    Document   : listadoClientes
    Created on : Nov 11, 2022, 12:33:51 PM
    Author     : faber
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>

<section id="clientes">
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado detallado de aplicaciones</h4>
                    </div>
                    <table class="table table-hover" >
                        <thead >
                            <tr>
                                <th>#</th>
                                <th>Aplicacion</th>
                                <th>Ciclo de Pruebas</th>
                                <th>Version</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Iteramos cada elemento de la lista de clientes -->
                            <c:forEach var="aplicacion" items="${aplicaciones}" varStatus="status">
                                
                                <tr><th scope="row">${status.count}</th>
                                    <td>${aplicacion.nombreAplicacion}</td>
                                    <td>${aplicacion.cicloPruebas}</td>
                                    <td>${aplicacion.version}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletControlador_1?accion=editar&idAplicacion=${aplicacion.idAplicacion}"
                                           class="btn btn-secondary btn-sm" >
                                            <i class="fa-sharp fa-solid fa-user-pen"></i>
                                        </a>
                                    </td></tr>

                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <%--Inicio de las tarjetas --%>
            <div class="col-md-4">
                <div>
                    <div class="card text-center bg-success text-white mb-3">
                        <div class="card-body">
                            <h3>"La productividad y la eficiencia solo se pueden 
                                lograr paso a paso con trabajo duro sostenido, atención 
                                incesante a los detalles e insistencia en los más altos 
                                estándares de calidad y rendimiento." - J. R. D. Tata</h3>
                            <h3 class="display-4">
                                <i class="fas fa-users"></i>
                            </h3>
                        </div>
                    </div>
                </div>
            </div>
            <%--Fin de las tarjetas --%>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-10">
                <div class="card">
                    <div class="card-header">
                        <h4>Resumen de aplicaciones por version</h4>
                    </div>
                    <table class="table table-hover" >
                        <thead >
                            <tr>
                                
                                <th>Aplicacion</th>
                                <th>Version</th>
                                <th>Vulnerabilidades de seguridad</th>
                                <th>Densidad de defectos(0-100)</th>
                                <th>Tiempo de respuesta (seg)</th>
                                <th>Tiempo de entrega (semanas)</th>
                                <th>Tiempo medio de reparacion (seg)</th>

                            </tr>
                        </thead>
                        <tbody>
                            <!-- Iteramos cada elemento de la lista de clientes -->
                            <c:forEach var="aplicacion" items="${aplicaciones2}" varStatus="status1">
                                <tr>
                                    <td>${aplicacion.nombreAplicacion}</td>
                                    <td>${aplicacion.version}</td>
                                    <td>${aplicacion.metrica1}</td>
                                    <td>${aplicacion.metrica2}</td>
                                    <td>${aplicacion.metrica3}</td>
                                    <td>${aplicacion.metrica4}</td>
                                    <td>${aplicacion.metrica5}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
</section>
<jsp:include page="/WEB-INF/paginas/clientes/agregarCliente.jsp"/>