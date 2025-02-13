package CCBLC.CCEntities;

public class CCHObrera extends Hormiga {
    public CCHObrera(int id) {
        super(id,"HObrera","Hembra","VIVA");
    }
    public CCHObrera(int id,String tipo,String sexo,String estado) {
        super(id,"HObrera","Hembra","VIVA");
    }
    
    @Override
    public Hormiga comer(IngestaNativa comida){
    switch (comida.getCcTipoIngesta()) {
    case "OmnivoroXY":
        return new CCHObrera(getId(),"HObrera","Hembra","MUERTA");
    case "Omnivoro":
        break;
    case "HerbivoroXX":
        return new CCHObrera(getId(),"HObrera","Hembra","VIVA");
    case "Herbivoro":
        break;
    }
    return this;
    }
}
