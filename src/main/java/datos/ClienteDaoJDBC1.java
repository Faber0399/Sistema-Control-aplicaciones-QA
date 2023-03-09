/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.Aplicacion;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author faber
 */
public class ClienteDaoJDBC1 {

    private static final String SQL_SELECT = "SELECT idaplicaciones, nombre, version, cicloPruebas, metrica1, metrica2, metrica3, metrica4, metrica5 FROM aplicaciones ORDER BY nombre, version, cicloPruebas";
    private static final String SQL_SELECT_MAP = "SELECT nombre, version FROM aplicaciones";
    private static final String SQL_SELECT_BY_ID = "SELECT cicloPruebas, metrica1, metrica2, metrica3, metrica4, metrica5 FROM aplicaciones WHERE idaplicaciones=?";
    private static final String SQL_INSERT = "INSERT INTO aplicaciones(nombre, version, cicloPruebas, metrica1, metrica2, metrica3, metrica4, metrica5 ) VALUES (?,?,?,?,?,?,?,?)";

    public List<Aplicacion> listar2() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Aplicacion aplicacion = null;
        List<Aplicacion> aplicaciones = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idAplicaciones = rs.getInt("idaplicaciones");
                String nombre = rs.getString("nombre");
                String cicloPruebas = rs.getString("cicloPruebas");
                String version = rs.getString("version");
                int metrica1 = rs.getInt("metrica1");
                int metrica2 = rs.getInt("metrica2");
                int metrica3 = rs.getInt("metrica3");
                int metrica4 = rs.getInt("metrica4");
                int metrica5 = rs.getInt("metrica5");
                aplicacion = new Aplicacion(idAplicaciones, nombre, version, cicloPruebas, metrica1, metrica2, metrica3, metrica4, metrica5);
                aplicaciones.add(aplicacion);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return aplicaciones;
    }

    public Aplicacion encontrar(Aplicacion aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, aplicacion.getIdAplicacion());
            rs = stmt.executeQuery();
            rs.next();//Este metodo absolute nos permite posicionarnos en el primer registro que nos devuelva el query(Result Set)
            String cicloPruebas = rs.getString("cicloPruebas");
            int metrica1 = rs.getInt("metrica1");
            int metrica2 = rs.getInt("metrica2");
            int metrica3 = rs.getInt("metrica3");
            int metrica4 = rs.getInt("metrica4");
            int metrica5 = rs.getInt("metrica5");
            aplicacion.setCicloPruebas(cicloPruebas);
            aplicacion.setMetrica1(metrica1);
            aplicacion.setMetrica2(metrica2);
            aplicacion.setMetrica3(metrica3);
            aplicacion.setMetrica4(metrica4);
            aplicacion.setMetrica5(metrica5);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return aplicacion;
    }

    public int insertar(Aplicacion aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, aplicacion.getNombreAplicacion());
            stmt.setString(2, aplicacion.getVersion());
            stmt.setString(3, aplicacion.getCicloPruebas());
            stmt.setInt(4, aplicacion.getMetrica1());
            stmt.setInt(5, aplicacion.getMetrica2());
            stmt.setInt(6, aplicacion.getMetrica3());
            stmt.setInt(7, aplicacion.getMetrica4());
            stmt.setInt(8, aplicacion.getMetrica5());
            registro = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return registro;
    }

    public Map<String, String> diccionarioaplicaciones() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Map<String, String> aplicaciones = new HashMap<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_MAP);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String version = rs.getString("version");
                aplicaciones.put(nombre, version);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return aplicaciones;
    }

}
