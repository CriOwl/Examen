package CCBLC.CCEntities;

public class CCHRastreadora extends Hormiga {
    public CCHRastreadora(int id) {
        super(id,"HRastreadora","MACHO","VIVA");
    }
    public CCHRastreadora(int id,String tipo,String sexo,String estado) {
        super(id,"HRastreadora",sexo,estado);
    }
    
    @Override
    public Hormiga comer(IngestaNativa comida){
    switch (comida.getCcTipoIngesta()) {
    case "HerbivoroXY":
        return new CCHRastreadora(getId(),"HRastreadora","MACHO","VIVA");
    }
    return new CCHRastreadora(getId(),"HRastreadora","MACHO","MUERTA");
    }
}
