package CCBLC.CCEntities;

public class CCHObrera extends Hormiga {
    public CCHObrera(int id) {
        super(id,"HObrera","HEMBRA","VIVA");
    }
    public CCHObrera(int id,String tipo,String sexo,String estado) {
        super(id,"HObrera",sexo,estado);
    }
    
    @Override
    public Hormiga comer(IngestaNativa comida){
    switch (comida.getCcTipoIngesta()) {
    case "HerbivoroXX":
        return new CCHObrera(getId(),"HObrera","HEMBRA","VIVA");
    case "Herbivoro":
        return new CCHObrera(getId(),"HObrera","HEMBRA","VIVA");
    }
    return new CCHObrera(getId(),"HObrera","HEMBRA","MUERTA");
    }
}
