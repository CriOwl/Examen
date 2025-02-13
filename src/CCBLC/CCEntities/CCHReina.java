package CCBLC.CCEntities;

public class CCHReina extends Hormiga {
    public CCHReina(int id) {
        super(id,"HReina","HEMBRA","VIVA");
    }
    public CCHReina(int id,String tipo,String sexo,String estado) {
        super(id,"HReina",sexo,estado);
    }
    
    @Override
    public Hormiga comer(IngestaNativa comida){
    switch (comida.getCcTipoIngesta()) {
    case "InsectivoroXX":
        return new CCHReina(getId(),"HReina","HEMBRA","VIVA");
    case "Insectivoro":
        return new CCHReina(getId(),"HReina","HEMBRA","VIVA");
    }
    return new CCHReina(getId(),"HReina","HEMBRA","MUERTA");
    }
}
