package BL;

import java.util.ArrayList;
import CCBL.Entities.CCAlimento.CCGenoma.*;
import CCBL.Entities.CCAlimento.CCIngesta.*;
import CCBLC.CCEntities.CCAlimentos.CCGenoma.GenoAlimento;
import CCBLC.CCEntities.CCAlimentos.CCGenoma.X;
import CCBLC.CCEntities.CCAlimentos.CCGenoma.XX;
import CCBLC.CCEntities.CCAlimentos.CCGenoma.XY;
import CCBLC.CCEntities.CCAlimentos.CCIngesta.Carnivoro;
import CCBLC.CCEntities.CCAlimentos.CCIngesta.Herbivoro;
import CCBLC.CCEntities.CCAlimentos.CCIngesta.IngestaNativa;
import CCBLC.CCEntities.CCAlimentos.CCIngesta.Insectivoro;
import CCBLC.CCEntities.CCAlimentos.CCIngesta.Nectarivoro;
import CCBLC.CCEntities.CCAlimentos.CCIngesta.Omnivoro;
import DAC.HormigueroDAC;
import Infra.AppException;  

public class HormigueroBL {
    public ArrayList<Hormiga> lstHormiguero = new ArrayList<>();

    public String crearLarva() throws AppException {
        Hormiga hormiga = new HLarva(lstHormiguero.size() + 1);
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
        GenoAlimento aGeno = null; 
        IngestaNativa aNativo = null; 
        Hormiga hormiga = null;

        switch (alimentoGeno) { 
            case "XX": aGeno = new XX(); break; 
            case "XY": aGeno = new XY(); break; 
            default: aGeno = new X(); break; 
        }

        switch (alimentoNativo) { 
            case "Carnívoro": aNativo = new Carnivoro(); break;
            case "Herbívoro": aNativo = new Herbivoro(); break; 
            case "Omnívoro": aNativo = new Omnivoro(); break; 
            case "Insectívoro": aNativo = new Insectivoro(); break; 
            case "Nectarívoros": aNativo = new Nectarivoro(); break; 
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

        if (aNativo.inyectar(aGeno)) {
            lstHormiguero.set(indexList, hormiga.comer(aNativo));
            return lstHormiguero.get(indexList).getTipo() + " Alimentada";
        } else {
            return hormiga.getTipo() + " NO alimentada";
        }
    }
}
