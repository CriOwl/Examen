package CCBLC.CCEntities.CCAlimentos;

public abstract class Alimento {
    private final String ccTipo;

    public String getCcTipo() {
        return ccTipo;
    }

    public Alimento(String tipo){
        ccTipo=tipo;
    }
}
