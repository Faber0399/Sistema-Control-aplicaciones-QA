package web;

import datos.ClienteDaoJDBC1;
import dominio.Aplicacion;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author faber
 */
@WebServlet("/ServletControlador_1")
public class ServletControlador_1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarCliente(request, response);
                    break;

                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Map<String, String> diccionarioaplicaciones = new ClienteDaoJDBC1().diccionarioaplicaciones();
        //System.out.println("diccionarioaplicaciones = " + diccionarioaplicaciones.values());
        List<Aplicacion> aplicaciones = new ClienteDaoJDBC1().listar2();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("aplicaciones", aplicaciones);
        Aplicacion[] aplicaciones2 = this.resumenMetricas(aplicaciones);
        sesion.setAttribute("aplicaciones2", aplicaciones2);

        //request.getRequestDispatcher("clientes.jsp").forward(request, response);
        response.sendRedirect("clientes.jsp");

    }

    private void editarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos el idCliente
        int idAplicacion = Integer.parseInt(request.getParameter("idAplicacion"));
        Aplicacion aplicacion = new ClienteDaoJDBC1().encontrar(new Aplicacion(idAplicacion));
        request.setAttribute("aplicacion", aplicacion);
        String jspEditar = "/WEB-INF/paginas/clientes/editarCliente.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        System.out.println(accion);
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarCliente(request, response);
                    break;
                case "modificar":
                    this.modificarCliente(request, response);
                    break;
                case "insertarApp":
                    this.insertarClienteNuevo(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void insertarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario agregarCliente

        String nombre = request.getParameter("Aplicacion");
        String cicloPruebas = request.getParameter("cicloPruebas");
        String version = request.getParameter("version");
        int metrica1 = Integer.parseInt(request.getParameter("metrica1"));
        int metrica2 = Integer.parseInt(request.getParameter("metrica2"));
        int metrica3 = Integer.parseInt(request.getParameter("metrica3"));
        int metrica4 = Integer.parseInt(request.getParameter("metrica4"));
        int metrica5 = Integer.parseInt(request.getParameter("metrica5"));
        List<Aplicacion> aplicaciones = new ClienteDaoJDBC1().listar2();

        for (int i = 0; i < aplicaciones.size(); i++) {
            if (nombre.toLowerCase().equals(aplicaciones.get(i).getNombreAplicacion().toLowerCase()) && version.equals(aplicaciones.get(i).getVersion())) {
                //Creamos el objeto de cliente (modelo)
                Aplicacion aplicacion = new Aplicacion(nombre, version,
                        cicloPruebas, metrica1, metrica2, metrica3, metrica4, metrica5);

                //Insertamos el nuevo objeto en la base de datos
                int registrosModificados = new ClienteDaoJDBC1().insertar(aplicacion);
                //Redirigimos hacia accion por default
                this.accionDefault(request, response);
                break;
            }
        }

        if (!response.isCommitted()) {

            request.setAttribute("Aplicacion", nombre);
            request.setAttribute("version", version);
            request.setAttribute("aplicaciones", aplicaciones);
            request.setAttribute("error", "error");

            request.getRequestDispatcher("error.jsp").forward(request, response);

        }

    }

    private void modificarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario editarCliente

        String cicloPruebas = request.getParameter("cicloPruebas");
        String metrica1 = request.getParameter("metrica1");
        String metrica2 = request.getParameter("metrica2");
        String metrica3 = request.getParameter("metrica3");
        String metrica4 = request.getParameter("metrica4");
        String metrica5 = request.getParameter("metrica5");

        this.accionDefault(request, response);
    }

    public Aplicacion[] resumenMetricas(List<Aplicacion> aplicaciones) {
        int aux2 = 0, aux3 = 0, aux4 = 0, aux5 = 0, aux6 = 0, metrica1 = 0, metrica2 = 0, metrica3 = 0, metrica4 = 0, metrica5 = 0;
        Aplicacion[] appresumen = new Aplicacion[aplicaciones.size()];
        existe:
        for (int i = 0; i < aplicaciones.size(); i++) {
            int aux = 1, j = i + 1, a = i - 1;
            while (a >= 0) {
                if (appresumen[a] != null && appresumen[a].getNombreAplicacion().equals(aplicaciones.get(i)
                        .getNombreAplicacion()) && appresumen[a].getVersion()
                                .equals(aplicaciones.get(i).getVersion()
                                )) {
                    continue existe;
                }
                a--;
            }
            metrica1 = (aplicaciones.get(i).getMetrica1());
            metrica2 = (aplicaciones.get(i).getMetrica2());
            metrica3 = (aplicaciones.get(i).getMetrica3());
            metrica4 = (aplicaciones.get(i).getMetrica4());
            metrica5 = (aplicaciones.get(i).getMetrica5());
            while (j < aplicaciones.size()) {
                if (aplicaciones.get(i).getNombreAplicacion().equals(
                        aplicaciones.get(j).getNombreAplicacion())
                        && aplicaciones.get(i)
                                .getVersion().equals(aplicaciones.get(j).
                                        getVersion())) {
                    aux++;
                    metrica1 = (aplicaciones.get(i).getMetrica1()
                            + aplicaciones.get(j).getMetrica1()) / aux;
                    aux2 = metrica1 + aux2;
                    metrica2 = (aplicaciones.get(i).getMetrica2()
                            + aplicaciones.get(j).getMetrica2()) / aux;
                    aux3 = metrica2 + aux3;
                    metrica3 = (aplicaciones.get(i).getMetrica3()
                            + aplicaciones.get(j).getMetrica3()) / aux;
                    aux4 = metrica3 + aux4;
                    metrica4 = (aplicaciones.get(i).getMetrica4()
                            + aplicaciones.get(j).getMetrica4()) / aux;
                    aux5 = metrica4 + aux5;
                    metrica5 = (aplicaciones.get(i).getMetrica5()
                            + aplicaciones.get(j).getMetrica5()) / aux;
                    aux6 = metrica5 + aux6;
                }
                j++;
            }
            Aplicacion app1 = new Aplicacion(aplicaciones.get(i)
                    .getNombreAplicacion(),
                    aplicaciones.get(i).getVersion(), "Resumen",
                    metrica1, metrica2, metrica3, metrica4, metrica5);

            appresumen[i] = app1;
        }
        return appresumen;

    }

    private void insertarClienteNuevo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario agregarCliente

        String nombre = request.getParameter("Aplicacion");
        String cicloPruebas = request.getParameter("cicloPruebas");
        String version = request.getParameter("version");
        int metrica1 = Integer.parseInt(request.getParameter("metrica1"));
        int metrica2 = Integer.parseInt(request.getParameter("metrica2"));
        int metrica3 = Integer.parseInt(request.getParameter("metrica3"));
        int metrica4 = Integer.parseInt(request.getParameter("metrica4"));
        int metrica5 = Integer.parseInt(request.getParameter("metrica5"));

        //Creamos el objeto de cliente (modelo)
        Aplicacion aplicacion = new Aplicacion(nombre, version,
                cicloPruebas, metrica1, metrica2, metrica3, metrica4, metrica5);

        //Insertamos el nuevo objeto en la base de datos
        int registrosModificados = new ClienteDaoJDBC1().insertar(aplicacion);
        //Redirigimos hacia accion por default
        this.accionDefault(request, response);

    }

}
