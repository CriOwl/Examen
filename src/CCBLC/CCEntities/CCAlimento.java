package CCBLC.CCEntities;

public abstract class CCAlimento {
    private final String ccTipo;

    public String getCcTipo() {
        return ccTipo;
    }

    public CCAlimento(String tipo){
        ccTipo=tipo;
    }
}
