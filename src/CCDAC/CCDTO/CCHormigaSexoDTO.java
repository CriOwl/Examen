package CCDAC.CCDTO;

public class CCHormigaSexoDTO {
    private Integer IdSexo;
    private String Name           ;
    private String Estado         ;
    private String FechaCreacion  ;
    private String FechaActua     ;
    
    public CCHormigaSexoDTO(Integer idSexo, String name) {
        IdSexo = idSexo;
        Name = name;
    }
    public Integer getIdSexo() {
        return IdSexo;
    }
    public void setIdSexo(Integer idSexo) {
        IdSexo = idSexo;
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
    
}
