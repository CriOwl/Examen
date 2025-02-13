package CCBLC.CCEntities;

public class CCHZangano extends Hormiga {
    public CCHZangano(int id) {
        super(id,"HZangano","MACHO","VIVA");
    }
    public CCHZangano(int id,String tipo,String sexo,String estado) {
        super(id,"HZangano",sexo,estado);
    }
    
    @Override
    public Hormiga comer(IngestaNativa comida){
    switch (comida.getCcTipoIngesta()) {
    case "OmnivoroXY":
        return new CCHZangano(getId(),"HZangano","MACHO","VIVA");
    case "Carnivoro":
        return new CCHZangano(getId(),"HZangano","MACHO","VIVA");
    }
    return new CCHZangano(getId(),"HZangano","MACHO","MUERTA");
    }
}
