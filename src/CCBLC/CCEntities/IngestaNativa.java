package CCBLC.CCEntities;

import CCBLC.CCEntities.CCAlimentos.CCAlimento;
import CCBLC.CCEntities.CCAlimentos.CCGenoma.CCGenoAlimento;

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
        if(ccGenoma.getCcTipo().isEmpty()){
            ccGenoAlimento=ccGenoma;
            setCcTipoIngesta(ccTipoIngesta+ccGenoma.getCcTipo());
            return true;
        }
        return false;
    }

    public CCGenoAlimento getCcGenoAlimento() {
        return ccGenoAlimento;
    }
    
}