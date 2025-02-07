package CCDAC;
import CCInfra.EcuAnt;
import java.io.FileWriter;
import java.io.IOException;



public class CCHormigueroDAC {

    public void naSaveHormigueroToCSV(String fullData) {
        try (FileWriter writer = new FileWriter(EcuAnt.DATAFILE, true)) {
            writer.write(fullData);
            writer.write(System.lineSeparator());
            EcuAnt.show_mesg_correct("Datos guardados exitosamente en " + EcuAnt.DATAFILE,"Guardado");
        } catch (IOException e) {
            EcuAnt.show_mesg_advert("Ups...! tenemos problema al respaldar”: " + e.getMessage(),"Error");
        }
    }
}
