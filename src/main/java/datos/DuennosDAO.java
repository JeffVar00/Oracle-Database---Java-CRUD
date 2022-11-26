
package datos;

import static datos.Conexion.cerrar;
import domain.Duenno;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DuennosDAO {
    
    private Connection coneccionTransaccional;
    private static final String SQL_SELECT = "SELECT * FROM DUENNOS";
    private static  String SQL_INSERT;
    private static  String SQL_UPDATE;
    private static  String SQL_DELETE;
    private static Connection conexion;

   

    public DuennosDAO() throws SQLException {

        conexion = Conexion.getConexion();

    }

    public DuennosDAO(Connection coneccionTransaccional) {
        this.coneccionTransaccional = coneccionTransaccional;
    }

    public List<Duenno> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stml = null;
        ResultSet rs = null;
        Duenno duenno = null;
        List<Duenno> Duennos = new ArrayList();
        
        try {
            conn = this.coneccionTransaccional != null ? this.coneccionTransaccional : conexion;
            System.out.println("ejecutando "+SQL_SELECT);
            stml = conn.prepareStatement(SQL_SELECT);
            rs = stml.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID_DUENNO");
                String nombre = rs.getString("NOMBRE");
                String apellido1 = rs.getString("APE1");
                String apellido2 = rs.getString("APE2");
                int telefono = rs.getInt("TELEFONO");
                String correo = rs.getString("CORREO");
                duenno = new Duenno(nombre, id, apellido1, apellido2, telefono, correo);

                Duennos.add(duenno);
                
            }
        } finally {

            cerrar(rs);
            cerrar(stml);
            if (this.coneccionTransaccional == null) {
                cerrar(conn);
            }

        }
        return Duennos;
    }

    public int insertar(Duenno duenno) throws SQLException {
        Connection conn = null;
        CallableStatement stml = null;
        int registros = 0;
        
        try {
            conn = this.coneccionTransaccional != null ? this.coneccionTransaccional : conexion;
            SQL_INSERT="{call SP_INSERTAR_DUENNOS(?,?,?,?,?,?)}";
            System.out.println("ejecutando "+SQL_INSERT);
            stml = conn.prepareCall(SQL_INSERT);
            
            stml.setInt(1, duenno.getID_DUENNO());
            stml.setString(2, duenno.getNOMBRE());
            stml.setString(3, duenno.getAPE1());
            stml.setString(4, duenno.getAPE2());
            stml.setInt(5, duenno.getTELEFONO());
            stml.setString(6, duenno.getCORREO());
            registros = stml.executeUpdate();

        } finally {

            cerrar(stml);
            if (this.coneccionTransaccional == null) {
                cerrar(conn);
            }

        }
        return registros;
    }

    public int actualizar(Duenno duenno) throws SQLException {
        Connection conn = null;
        CallableStatement stml = null;
        int registros = 0;
        
        try {
            conn = this.coneccionTransaccional != null ? this.coneccionTransaccional : conexion;
            SQL_UPDATE="{call SP_ACTUALIZAR_DUENNO (?,?,?,?,?,?)}";
            System.out.println("ejecutando "+SQL_UPDATE);
            stml = conn.prepareCall(SQL_UPDATE);
            
            stml.setInt(1, duenno.getID_DUENNO());
            stml.setString(2, duenno.getNOMBRE());
            stml.setString(3, duenno.getAPE1());
            stml.setString(4, duenno.getAPE2());
            stml.setInt(5, duenno.getTELEFONO());
            stml.setString(6, duenno.getCORREO());
            registros = stml.executeUpdate();

        } finally {

            cerrar(stml);
            if (this.coneccionTransaccional == null) {
                cerrar(conn);
            }

        }
        return registros;
    }

    public int eliminar(Duenno duenno) throws SQLException {
        Connection conn = null;
        CallableStatement stml = null;
        int registros = 0;
        
        try {
            conn = this.coneccionTransaccional != null ? this.coneccionTransaccional : conexion;
            SQL_DELETE="{call SP_BORRAR_DUENNO(?)}";
            System.out.println("ejecutando "+SQL_DELETE);
            stml = conn.prepareCall(SQL_DELETE);
            stml.setInt(1, duenno.getID_DUENNO());
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
