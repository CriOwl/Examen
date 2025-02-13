package CCBLC.CCEntities;

public class CCHLarva extends Hormiga {
    public CCHLarva(int id) {
        super(id, "HLarva", "ASEXUAL", "VIVA");
    }

    public CCHLarva(int id, String tipo, String sexo, String estado) {
        super(id, "HLarva", sexo, estado);
    }

    @Override
    public Hormiga comer(IngestaNativa comida) {
        System.out.println(comida.getCcGenoAlimento().getCcTipo());
        switch (comida.getCcTipoIngesta()) {
            case "HerbivoroXX":
                return new CCHObrera(getId());
            case "NectarivoroX":
                return new CCHLarva(getId(), "HLarva", "ASEXUAL", "VIVA");
            case "NectarivoroXX":
                return new CCHLarva(getId(), "HLarva", "ASEXUAL", "VIVA");
            case "NectarivoroXY":
                return new CCHLarva(getId(), "HLarva", "ASEXUAL", "VIVA");
            case "CarnivoroXY":
                return new CCHSoldado(getId());
            case "OmnivoroXY":
                return new CCHZangano(getId());
            case "HerbivoroXY":
                return new CCHRastreadora(getId());
            case "InsectivoroXX":
                return new CCHReina(getId());
            default:
                return new CCHLarva(getId(), "HLarva", "ASEXUAL", "MUERTA");
        }
    }
}
