package datos;

import static datos.Conexion.*;
import domain.Filial;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

public class FilialDAO {

    private Connection coneccionTransaccional;
    private static final String SQL_SELECT = "SELECT * FROM FILIALES";
    private static String SQL_INSERT;
    private static String SQL_UPDATE;
    private static String SQL_DELETE;
    private static Connection conexion;
    private String Cursero = "";

    public FilialDAO() throws SQLException {

        conexion = Conexion.getConexion();

    }

    public FilialDAO(Connection coneccionTransaccional) {
        this.coneccionTransaccional = coneccionTransaccional;
    }

    public List<Filial> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stml = null;
        ResultSet rs = null;
        Filial Filial = null;
        List<Filial> Filials = new ArrayList();

        try {
            conn = this.coneccionTransaccional != null ? this.coneccionTransaccional : conexion;
            System.out.println("ejecutando " + SQL_SELECT);
            stml = conn.prepareStatement(SQL_SELECT);
            rs = stml.executeQuery();
            while (rs.next()) {
                int id_filial = rs.getInt("ID_FILIAL");
                int id_duenno = rs.getInt("ID_DUENNO");
                String descripcion = rs.getString("DESCRIPCION");
                Filial = new Filial(id_filial, id_duenno, descripcion);

                Filials.add(Filial);

            }
        } finally {

            cerrar(rs);
            cerrar(stml);
            if (this.coneccionTransaccional == null) {
                cerrar(conn);
            }

        }
        return Filials;
    }

    public int insertar(Filial filial) throws SQLException {
        Connection conn = null;
        CallableStatement stml = null;
        int registros = 0;

        try {
            conn = this.coneccionTransaccional != null ? this.coneccionTransaccional : conexion;
            SQL_INSERT = "{call SP_INSERTAR_FILIALES(?,?,?)}";
            System.out.println("ejecutando " + SQL_INSERT);
            stml = conn.prepareCall(SQL_INSERT);

            stml.setInt(1, filial.getID_FILIAL());
            stml.setString(2, filial.getDESCRIPCION());
            stml.setInt(3, filial.getID_DUENNO());
            registros = stml.executeUpdate();

        } finally {

            cerrar(stml);
            if (this.coneccionTransaccional == null) {
                cerrar(conn);
            }

        }
        return registros;
    }

    public int actualizar(Filial filial) throws SQLException {
        Connection conn = null;
        PreparedStatement stml = null;
        int registros = 0;

        try {
            conn = this.coneccionTransaccional != null ? this.coneccionTransaccional : conexion;
            SQL_UPDATE = "{call SP_ACTUALIZAR_FILIALES (?,?,?)}";
            System.out.println("ejecutando " + SQL_UPDATE);
            stml = conn.prepareStatement(SQL_UPDATE);

            stml.setInt(1, filial.getID_FILIAL());
            stml.setString(2, filial.getDESCRIPCION());
            stml.setInt(3, filial.getID_DUENNO());
            registros = stml.executeUpdate();

        } finally {

            cerrar(stml);
            if (this.coneccionTransaccional == null) {
                cerrar(conn);
            }

        }
        return registros;
    }

    public int eliminar(Filial filial) throws SQLException {
        Connection conn = null;
        PreparedStatement stml = null;
        int registros = 0;

        try {
            conn = this.coneccionTransaccional != null ? this.coneccionTransaccional : conexion;
            SQL_DELETE = "{call SP_BORRAR_FILIALES (?)}";
            System.out.println("ejecutando " + SQL_DELETE);
            stml = conn.prepareStatement(SQL_DELETE);
            stml.setInt(1, filial.getID_FILIAL());
            registros = stml.executeUpdate();

        } finally {

            cerrar(stml);
            if (this.coneccionTransaccional == null) {
                cerrar(conn);
            }

        }
        return registros;
    }

    public String cursero(int ID_FILIAL) throws SQLException {
        Connection conn = null;
        CallableStatement stml = null;
        ResultSet rs = null;
        String resultado = "";

        try {
            conn = this.coneccionTransaccional != null ? this.coneccionTransaccional : conexion;
            this.Cursero = "{call Mostrar_Accesos(?,?)}";
            System.out.println("ejecutando " + Cursero);

            stml = conn.prepareCall(Cursero);
            stml.setInt(1, ID_FILIAL);
            stml.registerOutParameter(2, OracleTypes.CURSOR);
            stml.executeUpdate();
            rs = (ResultSet) stml.getObject(2);
            while (rs.next()) {

                resultado = rs.getString("DESCRIPCION");
                resultado += " | " + rs.getString("N_VISITANTE");
                resultado += " | " + rs.getString("FECHA");
                resultado += " | " + rs.getString("H_ENTRADA");
                resultado += " | " + rs.getString("H_SALIDA");
                

            }
        } finally {

            cerrar(rs);
            cerrar(stml);
            if (this.coneccionTransaccional == null) {
                cerrar(conn);
            }

        }
        return resultado;
    }

}
