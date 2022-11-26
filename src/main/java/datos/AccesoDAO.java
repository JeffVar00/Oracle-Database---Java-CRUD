
package datos;

import static datos.Conexion.cerrar;
import domain.Acceso;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AccesoDAO {
    
    private Connection coneccionTransaccional;
    private static final String SQL_SELECT = "SELECT * FROM ACCESOS";
    private static  String SQL_INSERT;
    private static  String SQL_UPDATE;
    private static  String SQL_DELETE;
    private static Connection conexion;

   

    public AccesoDAO() throws SQLException {

        conexion = Conexion.getConexion();

    }

    public AccesoDAO(Connection coneccionTransaccional) {
        this.coneccionTransaccional = coneccionTransaccional;
    }

    public List<Acceso> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stml = null;
        ResultSet rs = null;
        Acceso acceso = null;
        List<Acceso> accesos = new ArrayList();
        
        try {
            conn = this.coneccionTransaccional != null ? this.coneccionTransaccional : conexion;
            System.out.println("ejecutando "+SQL_SELECT);
            stml = conn.prepareStatement(SQL_SELECT);
            rs = stml.executeQuery();
            while (rs.next()) {
                int n_acceso = rs.getInt("N_ACCESO");
                String fecha = String.valueOf(rs.getDate("FECHA"));
                String n_visitante = rs.getString("N_VISITANTE");
                int id_visitante = rs.getInt("ID_VISITANTE");
                int filial = rs.getInt("FILIAL");
                String h_entrada = rs.getString("H_ENTRADA");
                String h_salida = rs.getString("H_SALIDA");
                acceso = new Acceso(n_acceso, fecha, n_visitante, id_visitante,filial, h_entrada, h_salida);

                accesos.add(acceso);
                
            }
        } finally {

            cerrar(rs);
            cerrar(stml);
            if (this.coneccionTransaccional == null) {
                cerrar(conn);
            }

        }
        return accesos;
    }

    public int insertar(Acceso acceso) throws SQLException {
        Connection conn = null;
        CallableStatement stml = null;
        int registros = 0;
        
        try {
            conn = this.coneccionTransaccional != null ? this.coneccionTransaccional : conexion;
            SQL_INSERT="{call SP_INSERTAR_ACCESOS(?,?,?,?,?)}";
            System.out.println("ejecutando "+SQL_INSERT);
            stml = conn.prepareCall(SQL_INSERT);
            
            stml.setInt(1, acceso.getN_ACCESO());
            stml.setString(2, acceso.getN_VISITANTE());
            stml.setInt(3, acceso.getID_VISITANTE());
            stml.setInt(4, acceso.getFILIAL());
            stml.setString(5, acceso.getH_ENTRADA());

            registros = stml.executeUpdate();

        } finally {

            cerrar(stml);
            if (this.coneccionTransaccional == null) {
                cerrar(conn);
            }

        }
        return registros;
    }

    public int actualizar(Acceso acceso) throws SQLException {
        Connection conn = null;
        CallableStatement stml = null;
        int registros = 0;
        
        try {
            conn = this.coneccionTransaccional != null ? this.coneccionTransaccional : conexion;
            SQL_UPDATE="{call SP_ACTUALIZAR_ACCESOS(?,?)}";
            System.out.println("ejecutando "+SQL_UPDATE);
            stml = conn.prepareCall(SQL_UPDATE);
            
            stml.setInt(1, acceso.getN_ACCESO());
            stml.setString(2, acceso.getH_SALIDA ());
            stml.executeUpdate();
        } finally {

            cerrar(stml);
            if (this.coneccionTransaccional == null) {
                cerrar(conn);
            }

        }
        return registros;
    }

    public int eliminar(Acceso acceso) throws SQLException {
        Connection conn = null;
        CallableStatement stml = null;
        int registros = 0;
        
        try {
            conn = this.coneccionTransaccional != null ? this.coneccionTransaccional : conexion;
            SQL_DELETE="{call SP_BORRAR_ACCESOS  (?)}";
            System.out.println("ejecutando "+SQL_DELETE);
            stml = conn.prepareCall(SQL_DELETE);
            stml.setInt(1, acceso.getN_ACCESO());
            registros = stml.executeUpdate();

        } finally {

            cerrar(stml);
            if (this.coneccionTransaccional == null) {
                cerrar(conn);
            }

        }
        return registros;
    }
    
    
}
