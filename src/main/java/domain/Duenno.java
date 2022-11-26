
package domain;

public class Duenno {
    
    private String NOMBRE;
    private int ID_DUENNO;
    private String APE1;
    private String APE2;
    private int TELEFONO;
    private String CORREO;

    public Duenno(String NOMBRE, int ID_DUENNO, String APE1, String APE2, int TELEFONO, String CORREO) {
        this.NOMBRE = NOMBRE;
        this.ID_DUENNO = ID_DUENNO;
        this.APE1 = APE1;
        this.APE2 = APE2;
        this.TELEFONO = TELEFONO;
        this.CORREO = CORREO;
    }

    public Duenno() {
    }

    public Duenno(int ID_DUENNO) {
        this.ID_DUENNO = ID_DUENNO;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public int getID_DUENNO() {
        return ID_DUENNO;
    }

    public void setID_DUENNO(int ID_DUENNO) {
        this.ID_DUENNO = ID_DUENNO;
    }

    public String getAPE1() {
        return APE1;
    }

    public void setAPE1(String APE1) {
        this.APE1 = APE1;
    }

    public String getAPE2() {
        return APE2;
    }

    public void setAPE2(String APE2) {
        this.APE2 = APE2;
    }

    public int getTELEFONO() {
        return TELEFONO;
    }

    public void setTELEFONO(int TELEFONO) {
        this.TELEFONO = TELEFONO;
    }

    public String getCORREO() {
        return CORREO;
    }

    public void setCORREO(String CORREO) {
        this.CORREO = CORREO;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Duenno{NOMBRE=").append(NOMBRE);
        sb.append(", ID_DUENNO=").append(ID_DUENNO);
        sb.append(", APE1=").append(APE1);
        sb.append(", APE2=").append(APE2);
        sb.append(", TELEFONO=").append(TELEFONO);
        sb.append(", CORREO=").append(CORREO);
        sb.append('}');
        return sb.toString();
    }
    
    
}
