package CCDAC.CCDTO;

public class CCHormigaTablaDTO {
    private Integer IdHormiga;
    private String TipoHormiga;
    private String Sexo;
    private String Alimento;
    private String Estado;
    private String Entrenado;
    private String Columnas;

    
    public CCHormigaTablaDTO(String columnas) {
        Columnas = columnas;
    }

    public CCHormigaTablaDTO() {
    }

    public CCHormigaTablaDTO(Integer idHormiga, String tipoHormiga, String sexo, String alimento, String estado,
            String entrenado) {
        IdHormiga = idHormiga;
        TipoHormiga = tipoHormiga;
        Sexo = sexo;
        Alimento = alimento;
        Estado = estado;
        Entrenado = entrenado;
    }

    public Integer getIdHormiga() {
        return IdHormiga;
    }

    public void setIdHormiga(Integer IdHormiga) {
        this.IdHormiga = IdHormiga;
    }

    public String getTipoHormiga() {
        return TipoHormiga;
    }

    public void setTipoHormiga(String TipoHormiga) {
        this.TipoHormiga = TipoHormiga;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getAlimento() {
        return Alimento;
    }

    public void setAlimento(String Alimento) {
        this.Alimento = Alimento;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getEntrenado() {
        return Entrenado;
    }

    public void setEntrenado(String Entrenado) {
        this.Entrenado = Entrenado;
    }

    public String getColumnas() {
        return Columnas;
    }

    public void setColumnas(String Columnas) {
        this.Columnas = Columnas;
    }
    @Override
    public String toString(){
        return getClass().getName()
        +"\n IdHormiga     : "   + getIdHormiga()
        +"\n TipoHormiga: "    + getTipoHormiga()
        +"\n Sexo       : "    + getSexo()
        +"\n Estado       : "    + getEstado()
        +"\n Alimento     : "    + getAlimento()
        +"\n Entrenado    : "    + getEntrenado();
    }
}
