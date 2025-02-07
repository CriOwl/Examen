package CCBLC.CCEntities;

public class CCHObrera extends Hormiga {
    public CCHObrera(int id) {
        super(id,"HObrera","Hembra","Viva");
    }
    public CCHObrera(int id,String tipo,String sexo,String estado) {
        super(id,"HObrera","Hembra","Viva");
    }
    
    @Override
    public Hormiga comer(IngestaNativa comida){
    switch (comida.getCcTipoIngesta()) {
    case "OmnivoroXY":
        return new CCHObrera(getId(),"HObrera","Hembra","Muerta");
    case "Omnivoro":
        break;
    case "HerbivoroXX":
        return new CCHObrera(getId(),"HObrera","Hembra","Muerta");
    case "Herbivoro":
        break;
    }
    return this;
    }
}
