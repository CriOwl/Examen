package CCBLC.CCEntities;

import java.util.ArrayList;
import CCBL.Entities.CCAlimento.CCGenoma.*;
import CCBL.Entities.CCAlimento.CCIngesta.*;
import CCBLC.CCEntities.CCAlimentos.*;
import CCBLC.CCEntities.CCHLarva;
import CCBLC.CCEntities.Hormiga;
import DAC.CCHormigueroDAC;
import CCInfra.AppException;  

public class HormigueroBL {
    public ArrayList<Hormiga> lstHormiguero = new ArrayList<>();

    public String crearLarva() throws AppException {
        Hormiga hormiga = new CCHLarva(lstHormiguero.size() + 1);
        lstHormiguero.add(hormiga);
        return "HORMIGA LARVA, agregada al hormiguero";
    }

    public String eliminarHormiga(int idHormiga) throws Exception {
        String msg = "HORMIGA, no encontrada";
        for (int i = 0; i < lstHormiguero.size(); i++) {
            if (lstHormiguero.get(i).getId() == idHormiga) {
                msg = lstHormiguero.get(i).getTipo() + ", eliminada del hormiguero";
                lstHormiguero.remove(i);
                break;
            }
        }
        return msg;
    }

    public String guardarHormiquero() throws AppException {
        StringBuilder fullDataHormiga = new StringBuilder();
        for (Hormiga hormiga : lstHormiguero) {
            fullDataHormiga.append(hormiga.toString());
        }
        new HormigueroDAC().saveHormigueroToCSV(fullDataHormiga.toString());
        return "HORMIGUERO, almacenado";
    }

    public String alimentarHormiga(int Idhormiga, String alimentoGeno, String alimentoNativo) throws AppException { 
        int indexList = -1;
        CCGenoAlimento aGeno = null; 
        IngestaNativa aNativo = null; 
        Hormiga hormiga = null;

        switch (alimentoGeno) { 
            case "XX": aGeno = new XX(); break; 
            case "XY": aGeno = new XY(); break; 
            default: aGeno = new X(); break; 
        }
        switch (alimentoNativo) { 
            case "Carnivoro": aNativo = new CCCarnivoro(); break;
            case "Herbivoro": aNativo = new Herbivoro(); break; 
            case "Omnivoro": aNativo = new Omnivoro(); break; 
            case "Insectivoro": aNativo = new Insectivoro(); break; 
            case "Nectarivoros": aNativo = new Nectarivoro(); break; 
        }
        for (int i = 0; i < lstHormiguero.size(); i++) {
            if (lstHormiguero.get(i).getId() == Idhormiga) { 
                hormiga = lstHormiguero.get(i);
                indexList = i;
                break;
            }
        }
        if (aNativo == null || aGeno == null || hormiga == null || "MUERTA".equals(hormiga.getEstado())) {
            return "Ups...! alimento u hormiga no son válidos";
        }
        if (aNativo.ccInyectar(aGeno)) {
            lstHormiguero.set(indexList, hormiga.comer(aNativo));
            return lstHormiguero.get(indexList).getTipo() + " Alimentada";
        } else {
            return hormiga.getTipo() + " NO alimentada";
        }
    }
    
}
