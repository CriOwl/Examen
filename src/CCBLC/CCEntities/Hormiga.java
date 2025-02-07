package CCBLC.CCEntities;

import CCInfra.AppException;
import CCInfra.EcuAnt;

public abstract class Hormiga implements IHormiga{
    private Integer Id;
    private String Tipo;
    private String Sexo;
    private String Estado;
    
    public Hormiga(Integer id, String tipo, String sexo, String estado) {
        Id = id;
        Tipo = tipo;
        Sexo = sexo;
        Estado = estado;
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
    public static void ccEntrenarHormiga(int Idhormiga, String TipoHormiga) throws AppException { 
        CCEntomologo ccEntomologo=new CCEntomologo();
            switch (TipoHormiga) { 
            case "HObrera": ccEntomologo.ccEducar(new CCHObrera(Idhormiga));break; 
            case "HSoldado": ccEntomologo.ccEducar(new CCHSoldado(Idhormiga));break; 
            default: EcuAnt.show_mesg_advert("El tipo de hormiga que desea entrenar no esta disponible", "TipoHormiga");break; 
        }
        EcuAnt.show_mesg_advert("El tipo de hormiga que desea entrenar no esta disponible", "TipoHormiga");
    }
}
