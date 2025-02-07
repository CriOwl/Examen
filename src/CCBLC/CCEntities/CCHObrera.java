package CCBLC.CCEntities;

import CCBLC.CCEntities.CCAlimentos.CCIngesta.IngestaNativa;

public class CCHObrera extends Hormiga {
    public CCHObrera(int id) {
        super(id,"Obrera","Hembra","Viva");
    }
    public CCHObrera(int id,String sexo,String estado) {
        super(id,"Obrera","Hembra","Viva");
    }
    @Override
    public Hormiga comer(IngestaNativa comida){
    switch (comida.getCcTipoIngesta()) {
    case "OmnivoroXY":
        return new CCHObrera(getId(),"Obrera","Hembra","Muerta");
    case "Omnivoro":
        break;
    case "HerbivoroXX":
        return new CCHObrera(getId(),"Obrera","Hembra","Muerta");
    case "Herbivoro":
        break;
    }
    return this;
    }
}
