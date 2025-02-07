package CCDAC.CCDTO;

public class CCHormigaDTO {
    private Integer IdHormiga     ; 
    private Integer IdTipoHormiga ;
    private Integer IdSexo        ;
    private String  Estado         ;
    private Integer IdIngestaNativa;
    private Integer IdGenoma       ;
    private String  Entrenada      ;
    private String  FechaCreacion  ;
    private String  FechaActua     ;

    public CCHormigaDTO() {
    }

    public CCHormigaDTO(Integer idHormiga, Integer idTipoHormiga, Integer idSexo, String estado,
            Integer idIngestaNativa, Integer idGenoma) {
        IdHormiga = idHormiga;
        IdTipoHormiga = idTipoHormiga;
        IdSexo = idSexo;
        Estado = estado;
        IdIngestaNativa = idIngestaNativa;
        IdGenoma = idGenoma;
    }

    public CCHormigaDTO(Integer idHormiga, String estado, String fechaActua) {
        IdHormiga = idHormiga;
        Estado = estado;
        FechaActua = fechaActua;
    }
    
    public CCHormigaDTO(Integer idHormiga, String estado) {
        IdHormiga = idHormiga;
        Estado = estado;
    }

    public CCHormigaDTO(Integer idTipoHormiga, Integer idSexo, String estado, Integer idIngestaNativa, Integer idGenoma,
            String entrenada, String fechaActua) {
        IdTipoHormiga = idTipoHormiga;
        IdSexo = idSexo;
        Estado = estado;
        IdIngestaNativa = idIngestaNativa;
        IdGenoma = idGenoma;
        Entrenada = entrenada;
        FechaActua = fechaActua;
    }

    public CCHormigaDTO(Integer idTipoHormiga, Integer idSexo) {
        IdTipoHormiga = idTipoHormiga;
        IdSexo = idSexo;
    }

    public CCHormigaDTO(Integer idHormiga, Integer idTipoHormiga, Integer idSexo, String estado,
            Integer idIngestaNativa, Integer idGenoma, String entrenada) {
        IdHormiga = idHormiga;
        IdTipoHormiga = idTipoHormiga;
        IdSexo = idSexo;
        Estado = estado;
        IdIngestaNativa = idIngestaNativa;
        IdGenoma = idGenoma;
        Entrenada = entrenada;
    }

    public Integer getIdHormiga() {
        return IdHormiga;
    }

    public void setIdHormiga(Integer IdHormiga) {
        this.IdHormiga = IdHormiga;
    }

    public Integer getIdTipoHormiga() {
        return IdTipoHormiga;
    }

    public void setIdTipoHormiga(Integer IdTipoHormiga) {
        this.IdTipoHormiga = IdTipoHormiga;
    }

    public Integer getIdSexo() {
        return IdSexo;
    }

    public void setIdSexo(Integer IdSexo) {
        this.IdSexo = IdSexo;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }


    public String getEntrenada() {
        return Entrenada;
    }

    public void setEntrenada(String Entrenada) {
        this.Entrenada = Entrenada;
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
        +"\n IdHormiga     : "   + getIdHormiga()
        +"\n IdTipoHormiga: "    + getIdTipoHormiga()
        +"\n IdSexo       : "    + getIdSexo()
        +"\n Estado       : "    + getEstado()
        +"\n Alimento     : "    + getIdIngestaNativa()
        +"\n GenoAlimento : "    + getIdGenoma()
        +"\n Entrenada    : "    + getEntrenada()
        +"\n FechaCreacion: "    + getFechaCreacion()
        +"\n FechaActua   : "    + getFechaActua();
    }

    public Integer getIdIngestaNativa() {
        return IdIngestaNativa;
    }

    public void setIdIngestaNativa(Integer IdIngestaNativa) {
        this.IdIngestaNativa = IdIngestaNativa;
    }

    public Integer getIdGenoma() {
        return IdGenoma;
    }

    public void setIdGenoma(Integer IdGenoma) {
        this.IdGenoma = IdGenoma;
    }
}
