package CCBLC.CCEntities;


public abstract class CCGenoAlimento{
    private String ccTipo;

    public String getCcTipo() {
        return ccTipo;
    }

    public void setCcTipo(String ccTipo) {
        this.ccTipo = ccTipo;
    }

    public CCGenoAlimento(String ccTipo) {
        this.ccTipo = ccTipo;
    }


}