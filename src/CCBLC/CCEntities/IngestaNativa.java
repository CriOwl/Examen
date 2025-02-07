package CCBLC.CCEntities;

import CCBLC.CCEntities.CCAlimentos.CCAlimento;
import CCBLC.CCEntities.CCAlimentos.CCGenoma.CCGenoAlimento;
import CCInfra.AppException;
import CCInfra.EcuAnt;

public abstract class IngestaNativa extends CCAlimento implements ICCIngestaNativa{
    private CCGenoAlimento ccGenoAlimento;
    private String ccTipoIngesta;
    public IngestaNativa(String tipo) {
        super(tipo);    
        setCcTipoIngesta(tipo);
    }
    public IngestaNativa(String tipo, Integer IdIngesta, Integer IdGenoma) {
        super(tipo);    
        setCcTipoIngesta(tipo);
    }
    public String getCcTipoIngesta() {
        return ccTipoIngesta;
    }
    public void setCcTipoIngesta(String ccTipoIngesta) {
        this.ccTipoIngesta = ccTipoIngesta;
    }
    @Override
    public boolean ccInyectar(CCGenoAlimento ccGenoma){
        if(!(ccGenoma.getCcTipo().isEmpty())){
            ccGenoAlimento=ccGenoma;
            setCcTipoIngesta(ccTipoIngesta+ccGenoma.getCcTipo());
            return true;
        }
        return false;
    }

    public CCGenoAlimento getCcGenoAlimento() {
        return ccGenoAlimento;
    }
    public static Hormiga ccClasificar(String ccAlimento,String ccGenoma,Integer Id,String Tipo){
        CCGenoAlimento aGeno = null; 
        IngestaNativa aNativo = null; 
        Hormiga hormiga = null;
        switch (ccGenoma) { 
            case "XX": aGeno = new XX(); break; 
            case "XY": aGeno = new XY(); break; 
            case "X": aGeno = new XY(); break; 
            default: break; 
        }
        switch (Tipo) { 
            case "HObrera": hormiga=new CCHObrera(Id);break; 
            case "HLarva": hormiga=new CCHLarva(Id);break; 
            case "HSoldado": hormiga=new CCHSoldado(Id);break; 
            default: EcuAnt.show_mesg_advert("El tipo de hormiga que desea alimentar no esta disponible", "TipoHormiga");break;
        }
        switch (ccAlimento) { 
            case "Carnivoro": aNativo = new CCCarnivoro(); break;
            case "Herbivoro": aNativo = new Herbivoro(); break; 
            case "Omnivoro": aNativo = new Omnivoro(); break; 
            case "Insectivoro": aNativo  = new Insectivoro(); break; 
            case "Nectarivoros": aNativo  = new Nectarivoro(); break; 
        }
        aNativo.ccInyectar(aGeno);
        return hormiga.comer(aNativo);
        
    }
    
}