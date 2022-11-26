
package domain;

public class Acceso {
    
    private int N_ACCESO;
    private String FECHA;
    private String N_VISITANTE;
    private int ID_VISITANTE;
    private int FILIAL;
    private String H_ENTRADA;
    private String H_SALIDA;

    public Acceso(int N_ACCESO, String FECHA, String N_VISITANTE, int ID_VISITANTE, int FILIAL, String H_ENTRADA, String H_SALIDA) {
        this.N_ACCESO = N_ACCESO;
        this.FECHA = FECHA;
        this.N_VISITANTE = N_VISITANTE;
        this.ID_VISITANTE = ID_VISITANTE;
        this.FILIAL = FILIAL;
        this.H_ENTRADA = H_ENTRADA;
        this.H_SALIDA = H_SALIDA;
    }

    public Acceso() {
    }

    public Acceso(int N_ACCESO, String N_VISITANTE, int ID_VISITANTE, int FILIAL, String H_ENTRADA, String H_SALIDA) {
        this.N_ACCESO = N_ACCESO;
        this.N_VISITANTE = N_VISITANTE;
        this.ID_VISITANTE = ID_VISITANTE;
        this.FILIAL = FILIAL;
        this.H_ENTRADA = H_ENTRADA;
        this.H_SALIDA = H_SALIDA;
    }

    public Acceso(int N_ACCESO, String H_SALIDA) {
        this.N_ACCESO = N_ACCESO;
        this.H_SALIDA = H_SALIDA;
    }
    

    public int getN_ACCESO() {
        return N_ACCESO;
    }

    public void setN_ACCESO(int N_ACCESO) {
        this.N_ACCESO = N_ACCESO;
    }

    public String getFECHA() {
        return FECHA;
    }

    public void setFECHA(String FECHA) {
        this.FECHA = FECHA;
    }

    public String getN_VISITANTE() {
        return N_VISITANTE;
    }

    public void setN_VISITANTE(String N_VISITANTE) {
        this.N_VISITANTE = N_VISITANTE;
    }

    public int getID_VISITANTE() {
        return ID_VISITANTE;
    }

    public void setID_VISITANTE(int ID_VISITANTE) {
        this.ID_VISITANTE = ID_VISITANTE;
    }

    public int getFILIAL() {
        return FILIAL;
    }

    public void setFILIAL(int FILIAL) {
        this.FILIAL = FILIAL;
    }

    public String getH_ENTRADA() {
        return H_ENTRADA;
    }

    public void setH_ENTRADA(String H_ENTRADA) {
        this.H_ENTRADA = H_ENTRADA;
    }

    public String getH_SALIDA() {
        return H_SALIDA;
    }

    public void setH_SALIDA(String H_SALIDA) {
        this.H_SALIDA = H_SALIDA;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Acceso{N_ACCESO=").append(N_ACCESO);
        sb.append(", FECHA=").append(FECHA);
        sb.append(", N_VISITANTE=").append(N_VISITANTE);
        sb.append(", ID_VISITANTE=").append(ID_VISITANTE);
        sb.append(", FILIAL=").append(FILIAL);
        sb.append(", H_ENTRADA=").append(H_ENTRADA);
        sb.append(", H_SALIDA=").append(H_SALIDA);
        sb.append('}');
        return sb.toString();
    }

    
}
