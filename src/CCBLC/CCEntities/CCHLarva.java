package CCBLC.CCEntities;

public class CCHLarva extends Hormiga {
    public CCHLarva(int id) {
        super(id,"HLarva","Asexual","VIVA");
    }
    public CCHLarva(int id,String tipo,String sexo,String estado) {
        super(id,"HLarva",sexo,estado);
    }
    @Override
    public Hormiga comer(IngestaNativa comida){
    switch (comida.getCcTipoIngesta()) {
    case "HerbivoroXX":
        return new CCHObrera(getId());
    case "CarnivoroXY":
        return new CCHSoldado(getId());
        case "NectarivoroX":
        return new CCHLarva(getId(),"HLarva","ASEXUAL","VIVA");
        case "NectarivoroXX":
        return new CCHLarva(getId(),"HLarva","ASEXUAL","VIVA");
        case "NectarivoroXY":
        return new CCHLarva(getId(),"HLarva","ASEXUAL","VIVA");
        default:
    return new CCHLarva(getId(),"HLarva","ASEXUAL","MUERTA");
}
    }
}
