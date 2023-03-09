<%-- 
    Document   : agregarCliente
    Created on : Nov 14, 2022, 2:34:51 PM
    Author     : faber
--%>
<div class="modal" id="agregarNuevaApp">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Aplicacion</h5> 
                <button class="close" data-dismiss="modal">
                    <i class="fa-solid fa-circle-xmark"></i>
                </button>
            </div>
            <form action="${pageContext.request.contextPath}/ServletControlador_1?accion=insertarApp"
                  class="was-validated" method="POST">
                <div class="modal-body" >
                    <div class="form-row align-items-center">

                        <div class="form-group" >
                            <label for="Aplicacion">Aplicacion</label>
                            <input type="text" class="form-control" name="Aplicacion" required placeholder="Trivago">
                        </div>
                        <div class="form-group">
                            <label for="cicloPruebas">Ciclo Pruebas</label>
                            <input type="text" class="form-control" name="cicloPruebas" required placeholder="Ciclo 3">
                        </div>

                        <div class="form-group">
                            <label for="version">Version</label>
                            <input type="text" class="form-control" name="version" required placeholder="1.0">
                        </div>
                        <div class="form-group">
                            <label for="metrica1">Vulnerabilidades de seguridad</label>
                            <input type="number" class="form-control" name="metrica1" required placeholder="Ejemplo 6">
                        </div>
                        <div class="form-group">
                            <label for="metrica2">Densidad de defectos(0-100)</label>
                            <input type="number" class="form-control" name="metrica2" required placeholder="Ejemplo 0.2">
                        </div>
                        <div class="form-group">
                            <label for="metrica3">Tiempo de respuesta (seg)</label>
                            <input type="number" class="form-control" name="metrica3" required placeholder="Ejemplo 2">
                        </div>
                        <div class="form-group">
                            <label for="metrica4">Tiempo de entrega (semanas)</label>
                            <input type="number" class="form-control" name="metrica4" required placeholder="Ejemplo 9">
                        </div>
                        <div class="form-group">
                            <label for="metrica5">Tiempo medio de reparacion (seg)</label>
                            <input type="number" class="form-control" name="metrica5" required placeholder="Ejemplo 5">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-primary" type="submit">Guardar</button>
                    </div>
                </div>
            </form>

        </div>
    </div>        
</div>
