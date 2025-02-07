package CCBLC.CCEntities;

public abstract class Hormiga implements IHormiga{
    private Integer Id;
    private String Tipo;
    private String Sexo;
    private String Estado;
    public Hormiga(Integer id,String tipo, String sexo,String estado){

    }
    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        Id = id;
    }
    public String getTipo() {
        return Tipo;
    }
    public void setTipo(String tipo) {
        Tipo = tipo;
    }
    public String getSexo() {
        return Sexo;
    }
    public void setSexo(String sexo) {
        Sexo = sexo;
    }
    public String getEstado() {
        return Estado;
    }
    public void setEstado(String estado) {
        Estado = estado;
    }
    @Override
    public String toString() {
        return Id + "," + Tipo + "," + Sexo + "," + Estado;
    }
}
