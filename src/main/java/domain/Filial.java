package domain;


public class Filial {
    
    private int ID_FILIAL;
    private int ID_DUENNO;
    private String DESCRIPCION;

    public Filial(int ID_FILIAL, int ID_DUENNO, String DESCRIPCION) {
        this.ID_FILIAL = ID_FILIAL;
        this.ID_DUENNO = ID_DUENNO;
        this.DESCRIPCION = DESCRIPCION;
    }

    public Filial() {
    }

    public Filial(int ID_FILIAL) {
        this.ID_FILIAL = ID_FILIAL;
    }

   

    public int getID_FILIAL() {
        return ID_FILIAL;
    }

    public void setID_FILIAL(int ID_FILIAL) {
        this.ID_FILIAL = ID_FILIAL;
    }

    public int getID_DUENNO() {
        return ID_DUENNO;
    }

    public void setID_DUENNO(int ID_DUENNO) {
        this.ID_DUENNO = ID_DUENNO;
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
        sb.append("Filial{ID_FILIAL=").append(ID_FILIAL);
        sb.append(", ID_DUENNO=").append(ID_DUENNO);
        sb.append(", DESCRIPCION=").append(DESCRIPCION);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
