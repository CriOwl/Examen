package CCBLC.CCEntities;

public class CCHSoldado extends Hormiga {
    public CCHSoldado(int id) {
        super(id,"HSoldado","Hembra","Viva");
    }
    public CCHSoldado(int id,String tipo,String sexo,String estado) {
        super(id,"HSoldado","Hembra","Viva");
    }
    
    @Override
    public Hormiga comer(IngestaNativa comida){
    switch (comida.getCcTipoIngesta()) {
    case "CarnivoroXY":
        return new CCHObrera(getId(),"HSoldado","Hembra","Viva");
    case "Carnivoro":
        return this;
    default:
        return new CCHObrera(getId(),"HSoldado","Hembra","Muerta");
    }
    }
}
