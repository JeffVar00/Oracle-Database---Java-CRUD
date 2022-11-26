
package datos;

import static datos.Conexion.cerrar;
import domain.Cuota;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CuotaDAO {
    private Connection coneccionTransaccional;
    private static final String SQL_SELECT = "SELECT * FROM CUOTAS";
    private static  String SQL_INSERT;
    private static  String SQL_UPDATE;
    private static  String SQL_DELETE;
    private static Connection conexion;

   

    public CuotaDAO() throws SQLException {

        conexion = Conexion.getConexion();

    }

    public CuotaDAO(Connection coneccionTransaccional) {
        this.coneccionTransaccional = coneccionTransaccional;
    }

    public List<Cuota> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stml = null;
        ResultSet rs = null;
        Cuota cuota = null;
        List<Cuota> cuotas = new ArrayList();
        
        try {
            conn = this.coneccionTransaccional != null ? this.coneccionTransaccional : conexion;
            System.out.println("ejecutando "+SQL_SELECT);
            stml = conn.prepareStatement(SQL_SELECT);
            rs = stml.executeQuery();
            while (rs.next()) {
                int id_cuota = rs.getInt("ID_CUOTA");
                int id_duenno = rs.getInt("ID_DUENNO");
                String fecha = String.valueOf(rs.getDate("FECHA"));
                float monto = rs.getFloat("MONTO");
                String descripcion = rs.getString("DESCRIPCION");
                cuota = new Cuota(id_cuota, id_duenno,fecha, monto, descripcion);

                cuotas.add(cuota);
                
            }
        } finally {

            cerrar(rs);
            cerrar(stml);
            if (this.coneccionTransaccional == null) {
                cerrar(conn);
            }

        }
        return cuotas;
    }

    public int insertar(Cuota cuota) throws SQLException {
        Connection conn = null;
        CallableStatement stml = null;
        int registros = 0;
        
        try {
            conn = this.coneccionTransaccional != null ? this.coneccionTransaccional : conexion;
            SQL_INSERT="{call SP_INSERTAR_CUOTAS(?, ?, ?, ?)}";
            System.out.println("ejecutando "+SQL_INSERT);
            stml = conn.prepareCall(SQL_INSERT);
            
            stml.setInt(1, cuota.getID_CUOTA());
            stml.setInt(2, cuota.getID_DUENNO());
            stml.setFloat(3, cuota.getMONTO());
            stml.setString(4, cuota.getDESCRIPCION());
            registros = stml.executeUpdate();

        } finally {

            cerrar(stml);
            if (this.coneccionTransaccional == null) {
                cerrar(conn);
            }

        }
        return registros;
    }

    public int actualizar(Cuota cuota) throws SQLException {
        Connection conn = null;
        CallableStatement stml = null;
        int registros = 0;
        
        try {
            conn = this.coneccionTransaccional != null ? this.coneccionTransaccional : conexion;
            SQL_UPDATE="{call SP_ACTUALIZAR_CUOTA(?,?,?,?)}";
            System.out.println("ejecutando "+SQL_UPDATE);
            stml = conn.prepareCall(SQL_UPDATE);
            Date invoiceDate = new Date(System.currentTimeMillis());
            java.sql.Date invDate = new java.sql.Date(invoiceDate.getTime());
            
            stml.setInt(1, cuota.getID_CUOTA());
            stml.setDate(2,invDate);
            stml.setFloat(3, cuota.getMONTO());
            stml.setString(4, cuota.getDESCRIPCION());
            registros = stml.executeUpdate();

        } finally {

            cerrar(stml);
            if (this.coneccionTransaccional == null) {
                cerrar(conn);
            }

        }
        return registros;
    }

    public int eliminar(Cuota cuota) throws SQLException {
        Connection conn = null;
        CallableStatement stml = null;
        int registros = 0;
        
        try {
            conn = this.coneccionTransaccional != null ? this.coneccionTransaccional : conexion;
            SQL_DELETE="{call SP_BORRAR_CUOTA  (?)}";
            System.out.println("ejecutando "+SQL_DELETE);
            stml = conn.prepareCall(SQL_DELETE);
            stml.setInt(1, cuota.getID_CUOTA());
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
