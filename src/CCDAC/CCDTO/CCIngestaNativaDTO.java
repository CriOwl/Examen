package CCDAC.CCDTO;

public class CCIngestaNativaDTO {
    private Integer IdIngestaNativa ;
    private String Name           ;
    private String Estado         ;
    private String FechaCreacion  ;
    private String FechaActua     ;
    

    public CCIngestaNativaDTO(Integer idIngestaNativa, String name) {
        IdIngestaNativa = idIngestaNativa;
        Name = name;
    }


    public CCIngestaNativaDTO() {
    }


    public CCIngestaNativaDTO(Integer idIngestaNativa, String name, String estado, String fechaActua) {
        IdIngestaNativa = idIngestaNativa;
        Name = name;
        Estado = estado;
        FechaActua = fechaActua;
    }


    public CCIngestaNativaDTO(Integer idIngestaNativa, String estado, String fechaActua) {
        IdIngestaNativa = idIngestaNativa;
        Estado = estado;
        FechaActua = fechaActua;
    }


    public CCIngestaNativaDTO(String name, String estado) {
        Name = name;
        Estado = estado;
    }


    public Integer getIdIngestaNativa() {
        return IdIngestaNativa;
    }


    public void setIdIngestaNativa(Integer idIngestaNativa) {
        IdIngestaNativa = idIngestaNativa;
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
        +"\n IdTipoHormiga    : "    + getIdIngestaNativa()
        +"\n Name             : "    + getName()
        +"\n Estado           : "    + getEstado()
        +"\n FechaCreacion    : "    + getFechaCreacion()
        +"\n FechaActua       : "    + getFechaActua();
    }
}
