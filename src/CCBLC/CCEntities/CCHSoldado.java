package CCBLC.CCEntities;

public class CCHSoldado extends Hormiga {
    public CCHSoldado(int id) {
        super(id,"HSoldado","MACHO","VIVA");
    }
    public CCHSoldado(int id,String tipo,String sexo,String estado) {
        super(id,"HSoldado",sexo,estado);
    }
    
    @Override
    public Hormiga comer(IngestaNativa comida){
    switch (comida.getCcTipoIngesta()) {
    case "CarnivoroXY":
        return new CCHSoldado(getId(),"HSoldado","MACHO","VIVA");
    case "Carnivoro":
        return new CCHSoldado(getId(),"HSoldado","MACHO","VIVA");
    }
    return new CCHSoldado(getId(),"HSoldado","MACHO","MUERTA");
    }
}
