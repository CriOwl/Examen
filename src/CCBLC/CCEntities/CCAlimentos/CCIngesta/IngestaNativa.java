package CCBLC.CCEntities.CCAlimentos.CCIngesta;

import CCBLC.CCEntities.CCAlimentos.CCAlimento;
import CCBLC.CCEntities.CCAlimentos.CCGenoma.CCGenoAlimento;
import CCBLC.CCEntities.CCAlimentos.CCGenoma.GenoAlimento;

public abstract class IngestaNativa extends CCAlimento implements ICCIngestaNativa{
    private GenoAlimento ccGenoAlimento;
    public IngestaNativa(String tipo) {
        super(tipo);    
    }
    @Override
    public boolean ccInyectar(CCGenoAlimento ccGenoma){
        if(ccGenoma!=null){
            ccGenoAlimento=ccGenoma;
            return true;
        }
        return false;
    }

    public GenoAlimento getCcGenoAlimento() {
        return ccGenoAlimento;
    }
    
}