package domain;

import java.sql.Date;

public class Cuota_Extra {
    
    private int ID_CUOTA_EX;
    private int ID_DUENNO;
    private String FECHA;
    private float MONTO;
    private String DESCRIPCION;

    public Cuota_Extra(int ID_CUOTA_EX, float MONTO, String DESCRIPCION) {
        this.ID_CUOTA_EX = ID_CUOTA_EX;
        this.MONTO = MONTO;
        this.DESCRIPCION = DESCRIPCION;
    }

    public Cuota_Extra() {
    }

    public Cuota_Extra(int ID_CUOTA_EX, int ID_DUENNO, float MONTO, String DESCRIPCION) {
        this.ID_CUOTA_EX = ID_CUOTA_EX;
        this.ID_DUENNO = ID_DUENNO;
        this.MONTO = MONTO;
        this.DESCRIPCION = DESCRIPCION;
    }

    public Cuota_Extra(int ID_CUOTA_EX, int ID_DUENNO, String FECHA, float MONTO, String DESCRIPCION) {
        this.ID_CUOTA_EX = ID_CUOTA_EX;
        this.ID_DUENNO = ID_DUENNO;
        this.FECHA = FECHA;
        this.MONTO = MONTO;
        this.DESCRIPCION = DESCRIPCION;
    }

    public Cuota_Extra(int ID_CUOTA_EX) {
        this.ID_CUOTA_EX = ID_CUOTA_EX;
    }

    

    public int getID_CUOTA_EX() {
        return ID_CUOTA_EX;
    }

    public void setID_CUOTA_EX(int ID_CUOTA_EX) {
        this.ID_CUOTA_EX = ID_CUOTA_EX;
    }

    public int getID_DUENNO() {
        return ID_DUENNO;
    }

    public void setID_DUENNO(int ID_DUENNO) {
        this.ID_DUENNO = ID_DUENNO;
    }

    public String getFECHA() {
        return FECHA;
    }

    public void setFECHA(String FECHA) {
        this.FECHA = FECHA;
    }

    public float getMONTO() {
        return MONTO;
    }

    public void setMONTO(float MONTO) {
        this.MONTO = MONTO;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cuota_Extra{ID_CUOTA_EX=").append(ID_CUOTA_EX);
        sb.append(", ID_DUENNO=").append(ID_DUENNO);
        sb.append(", FECHA=").append(FECHA);
        sb.append(", MONTO=").append(MONTO);
        sb.append(", DESCRIPCION=").append(DESCRIPCION);
        sb.append('}');
        return sb.toString();
    }
    
    
            
    
}
