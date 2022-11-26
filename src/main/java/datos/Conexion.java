package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private static String url;
    private static final String user = "CONDOMINIO";
    private static final String password = "root0000";

    public static Connection getConexion() throws SQLException {
        url="jdbc:oracle:thin:@localhost:1521:xe";
        return DriverManager.getConnection(url, user, password);

    }
    
    public static void cerrar(ResultSet rs) throws SQLException{
        rs.close();
    }
    
    public static void cerrar(Statement sm) throws SQLException{
        sm.close();
    }
    
    public static void cerrar(PreparedStatement sm) throws SQLException{
        sm.close();
    }
    public static void cerrar(Connection cn) throws SQLException{
        cn.close();
    }
}
