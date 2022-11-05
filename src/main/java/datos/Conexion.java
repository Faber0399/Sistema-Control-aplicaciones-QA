package datos;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author faber
 */
public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/control_clientes?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER= "root";
    private static final String JDBC_PW= "admin";
    
    public static DataSource getDataSource(){
        BasicDataSource ds =new BasicDataSource();
        ds.setUrl(JDBC_URL);
        ds.setUsername(JDBC_USER);
        ds.setPassword(JDBC_PW);
        ds.setInitialSize(50);
        return ds;
    }

    public static Connection getConnection() throws SQLException{  
        return  getDataSource.getConnection();
    }
    public static void close ( ResultSet rs) throws SQLException{
        rs.close();
    }
    public static void close (Statement rs) throws SQLException{
        rs.close();
    }
    public static void close (PreparedStatement rs) throws SQLException{
        rs.close();
    }
    public static void close(Connection rs) throws SQLException{
        rs.close();
    }
    
}
