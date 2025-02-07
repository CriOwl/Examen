package CCDAC.CCDAO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import CCDAC.CCDataHelperSqlite;

public class CCHormigueroDAO extends CCDataHelperSqlite {

    public void saveHormigueroToCSV(String fullDataHormiga){
        File archivo = new File("Data\\hormiguero.csv");
        try {
            File directorio = archivo.getParentFile();
            if (directorio != null && !directorio.exists()) {
                directorio.mkdirs();
            }
            FileWriter writer = new FileWriter(archivo, true);
            writer.write(fullDataHormiga + "\n");
            writer.close();
            System.out.println("Datos guardados en " + archivo.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
}
