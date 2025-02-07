package CCBLC.CCEntities;

public class CCHLarva extends Hormiga {
    public CCHLarva(int id) {
        super(id,"HLarva","Asexual","Viva");
    }
    @Override
    public Hormiga comer(IngestaNativa comida){
    switch (comida.getCcTipoIngesta()) {
    case "HerbivoroXX":
        return new CCHObrera(getId());
    case "Herbivoro":
        break;
    case "CarnivoroXY":
        return new CCHSoldado(getId());
    case "Carnivoro":
        break;
    }
    return this;
    }
}
