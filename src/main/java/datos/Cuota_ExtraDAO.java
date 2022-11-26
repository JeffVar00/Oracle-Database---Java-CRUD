
package datos;

import static datos.Conexion.cerrar;
import domain.Cuota_Extra;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Cuota_ExtraDAO {
    
    
    
    private Connection coneccionTransaccional;
    private static final String SQL_SELECT = "SELECT * FROM CUOTAS_EXTRAS";
    private static  String SQL_INSERT;
    private static  String SQL_UPDATE;
    private static  String SQL_DELETE;
    private static Connection conexion;

   

    public Cuota_ExtraDAO() throws SQLException {

        conexion = Conexion.getConexion();

    }

    public Cuota_ExtraDAO(Connection coneccionTransaccional) {
        this.coneccionTransaccional = coneccionTransaccional;
    }

    public List<Cuota_Extra> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stml = null;
        ResultSet rs = null;
        Cuota_Extra cuota_extra = null;
        List<Cuota_Extra> cuota_extras = new ArrayList();
        
        try {
            conn = this.coneccionTransaccional != null ? this.coneccionTransaccional : conexion;
            System.out.println("ejecutando "+SQL_SELECT);
            stml = conn.prepareStatement(SQL_SELECT);
            rs = stml.executeQuery();
            while (rs.next()) {
                int id_cuotaex = rs.getInt("ID_CUOTA_EX");
                int id_duenno = rs.getInt("ID_DUENNO");
                String fecha = String.valueOf(rs.getDate("FECHA"));
                float monto = rs.getFloat("MONTO");
                String descripcion = rs.getString("DESCRIPCION");
                cuota_extra = new Cuota_Extra(id_cuotaex, id_duenno, fecha, monto, descripcion);

                cuota_extras.add(cuota_extra);
                
            }
        } finally {

            cerrar(rs);
            cerrar(stml);
            if (this.coneccionTransaccional == null) {
                cerrar(conn);
            }

        }
        return cuota_extras;
    }

    public int insertar(Cuota_Extra cuota_extra) throws SQLException {
        Connection conn = null;
        CallableStatement stml = null;
        int registros = 0;
        
        try {
            conn = this.coneccionTransaccional != null ? this.coneccionTransaccional : conexion;
            SQL_INSERT="{call SP_INSERTAR_CUOTAS_EXTRAS(?, ?, ?, ?)}";
            System.out.println("ejecutando "+SQL_INSERT);
            stml = conn.prepareCall(SQL_INSERT);
            
            stml.setInt(1, cuota_extra.getID_CUOTA_EX());
            stml.setInt(2, cuota_extra.getID_DUENNO());
            stml.setFloat(3, cuota_extra.getMONTO());
            stml.setString(4, cuota_extra.getDESCRIPCION());
            registros = stml.executeUpdate();

        } finally {

            cerrar(stml);
            if (this.coneccionTransaccional == null) {
                cerrar(conn);
            }

        }
        return registros;
    }

    public int actualizar(Cuota_Extra cuota_extra) throws SQLException {
        Connection conn = null;
        CallableStatement stml = null;
        int registros = 0;
        
        try {
            conn = this.coneccionTransaccional != null ? this.coneccionTransaccional : conexion;
            SQL_UPDATE="{call SP_ACTUALIZAR_CUOTAS_EXTRAS  (?,?,?,?)}";
            System.out.println("ejecutando "+SQL_UPDATE);
            stml = conn.prepareCall(SQL_UPDATE);
            Date invoiceDate = new Date(System.currentTimeMillis());
            java.sql.Date invDate = new java.sql.Date (invoiceDate.getTime());
            
            stml.setInt(1, cuota_extra.getID_CUOTA_EX());
            stml.setDate(2,invDate);
            stml.setFloat(3, cuota_extra.getMONTO());
            stml.setString(4, cuota_extra.getDESCRIPCION());
            registros = stml.executeUpdate();

        } finally {

            cerrar(stml);
            if (this.coneccionTransaccional == null) {
                cerrar(conn);
            }

        }
        return registros;
    }

    public int eliminar(Cuota_Extra cuota_extra) throws SQLException {
        Connection conn = null;
        CallableStatement stml = null;
        int registros = 0;
        
        try {
            conn = this.coneccionTransaccional != null ? this.coneccionTransaccional : conexion;
            SQL_DELETE="{call SP_BORRAR_CUOTAS_EXTRAS (?)}";
            System.out.println("ejecutando "+SQL_DELETE);
            stml = conn.prepareCall(SQL_DELETE);
            stml.setInt(1, cuota_extra.getID_CUOTA_EX());
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
