package CCBLC.CCEntities.CCAlimentos.CCIngesta;

import CCBLC.CCEntities.CCAlimentos.CCAlimento;
import CCBLC.CCEntities.CCAlimentos.CCGenoma.CCGenoAlimento;
import CCBLC.CCEntities.CCAlimentos.CCGenoma.GenoAlimento;

public abstract class IngestaNativa extends CCAlimento implements ICCIngestaNativa{
    private GenoAlimento ccGenoAlimento;
    private String ccTipoIngesta;
    public IngestaNativa(String tipo) {
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
        if(ccGenoma!=null){
            ccGenoAlimento=ccGenoma;
            setCcTipoIngesta(ccTipoIngesta+ccGenoma.getCcTipo());
            return true;
        }
        return false;
    }

    public GenoAlimento getCcGenoAlimento() {
        return ccGenoAlimento;
    }
    
}