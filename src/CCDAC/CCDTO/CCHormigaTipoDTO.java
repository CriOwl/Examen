package CCDAC.CCDTO;

public class CCHormigaTipoDTO {
    private Integer IdTipoHormiga;
    private String Name           ;
    private String Estado         ;
    private String FechaCreacion  ;
    private String FechaActua     ;
    

   
    public CCHormigaTipoDTO(Integer idTipoHormiga, String estado, String fechaActua) {
        IdTipoHormiga = idTipoHormiga;
        Estado = estado;
        FechaActua = fechaActua;
    }



    public CCHormigaTipoDTO(Integer idTipoHormiga, String name, String estado, String fechaActua) {
        IdTipoHormiga = idTipoHormiga;
        Name = name;
        Estado = estado;
        FechaActua = fechaActua;
    }



    public CCHormigaTipoDTO(Integer idTipoHormiga, String name) {
        IdTipoHormiga = idTipoHormiga;
        Name = name;
    }



    public Integer getIdTipoHormiga() {
        return IdTipoHormiga;
    }



    public void setIdTipoHormiga(Integer idTipoHormiga) {
        IdTipoHormiga = idTipoHormiga;
    }



    public String getName() {
        return Name;
    }



    public void setName(String name) {
        Name = name;
    }



    public String getEstado() {
        return Estado;
    }



    public void setEstado(String estado) {
        Estado = estado;
    }



    public String getFechaCreacion() {
        return FechaCreacion;
    }



    public void setFechaCreacion(String fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }



    public String getFechaActua() {
        return FechaActua;
    }



    public void setFechaActua(String fechaActua) {
        FechaActua = fechaActua;
    }

    @Override
    public String toString(){
        return getClass().getName()
        +"\n IdTipoHormiga    : "    + getIdTipoHormiga()
        +"\n Name             : "    + getName()
        +"\n Estado           : "    + getEstado()
        +"\n FechaCreacion    : "    + getFechaCreacion()
        +"\n FechaActua       : "    + getFechaActua();
    }
}
