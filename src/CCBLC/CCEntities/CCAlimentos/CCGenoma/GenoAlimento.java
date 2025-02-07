package CCBLC.CCEntities.CCAlimentos.CCGenoma;


public abstract class GenoAlimento{
    private String ccTipo;

    public String getCcTipo() {
        return ccTipo;
    }

    public void setCcTipo(String ccTipo) {
        this.ccTipo = ccTipo;
    }

    public GenoAlimento(String ccTipo) {
        this.ccTipo = ccTipo;
    }


}