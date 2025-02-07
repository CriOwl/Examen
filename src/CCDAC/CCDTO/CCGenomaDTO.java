package CCDAC.CCDTO;

public class CCGenomaDTO {
    private Integer IdGenoma     ; 
    private String Name         ;
    private String Estado       ;
    private String FechaCreacion;
    private String FechaActua   ;

    public CCGenomaDTO(Integer idGenoma, String name) {
        IdGenoma = idGenoma;
        Name = name;
    }
    

    public CCGenomaDTO(String name, String estado) {
        Name = name;
        Estado = estado;
    }


    public Integer getIdGenoma() {
        return IdGenoma;
    }

    public void setIdGenoma(Integer IdGenoma) {
        this.IdGenoma = IdGenoma;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(String FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }

    public String getFechaActua() {
        return FechaActua;
    }

    public void setFechaActua(String FechaActua) {
        this.FechaActua = FechaActua;
    }
    @Override
    public String toString(){
        return getClass().getName()
        +"\n IdGenoma         : "    + getIdGenoma()
        +"\n Name             : "    + getName()
        +"\n Estado           : "    + getEstado()
        +"\n FechaCreacion    : "    + getFechaCreacion()
        +"\n FechaActua       : "    + getFechaActua();
    }
}
