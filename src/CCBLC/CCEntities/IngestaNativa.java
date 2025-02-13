package CCBLC.CCEntities;

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
            case "X": aGeno = new X(); break; 
            default: break; 
        }
        switch (Tipo) { 
            case "HLarva": hormiga=new CCHLarva(Id);break; 
            case "HObrera": hormiga=new CCHObrera(Id);break; 
            case "HSoldado": hormiga=new CCHSoldado(Id);break; 
            case "HZangano": hormiga=new CCHZangano(Id);break; 
            case "HRastreadora": hormiga=new CCHRastreadora(Id);break; 
            case "HReina": hormiga=new CCHReina(Id);break; 
            default: EcuAnt.show_mesg_advert("El tipo de hormiga que desea alimentar no esta disponible", "TipoAlimento");break;
        }
        switch (ccAlimento) { 
            case "Carnivoro": aNativo = new Carnivoro(); break;
            case "Herbivoro": aNativo = new Herbivoro(); break; 
            case "Omnivoro": aNativo = new Omnivoro(); break; 
            case "Insectivoro": aNativo  = new Insectivoro(); break; 
            case "Nectarivoro": aNativo  = new Nectarivoro(); break; 
        }
        if (hormiga==null||aNativo==null) {
            return hormiga;            
        }
        aNativo.ccInyectar(aGeno);
        return hormiga.comer(aNativo);
    }
    
}