
package domain;


public class Cuota {
    
    private int ID_CUOTA;
    private int ID_DUENNO;
    private String FECHA;
    private float MONTO;
    private String DESCRIPCION;

    public Cuota(int ID_CUOTA, int ID_DUENNO,String FECHA, float MONTO, String DESCRIPCION) {
        this.ID_CUOTA = ID_CUOTA;
        this.ID_DUENNO = ID_DUENNO;
        this.FECHA=FECHA;
        this.MONTO = MONTO;
        this.DESCRIPCION = DESCRIPCION;
    }

    public Cuota(int ID_CUOTA, int ID_DUENNO, float MONTO, String DESCRIPCION) {
        this.ID_CUOTA = ID_CUOTA;
        this.ID_DUENNO = ID_DUENNO;
        this.MONTO = MONTO;
        this.DESCRIPCION = DESCRIPCION;
    }

    public Cuota(int ID_CUOTA, String FECHA, float MONTO, String DESCRIPCION) {
        this.ID_CUOTA = ID_CUOTA;
        this.FECHA = FECHA;
        this.MONTO = MONTO;
        this.DESCRIPCION = DESCRIPCION;
    }
    

    public Cuota() {
    }

    public Cuota(int ID_CUOTA) {
        this.ID_CUOTA = ID_CUOTA;
    }

    
    public int getID_CUOTA() {
        return ID_CUOTA;
    }

    public void setID_CUOTA(int ID_CUOTA) {
        this.ID_CUOTA = ID_CUOTA;
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
        sb.append("Cuota{ID_CUOTA=").append(ID_CUOTA);
        sb.append(", ID_DUENNO=").append(ID_DUENNO);
        sb.append(", FECHA=").append(FECHA);
        sb.append(", MONTO=").append(MONTO);
        sb.append(", DESCRIPCION=").append(DESCRIPCION);
        sb.append('}');
        return sb.toString();
    }

    
    
    
    
}
