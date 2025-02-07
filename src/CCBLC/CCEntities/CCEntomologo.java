package CCBLC.CCEntities;

import CCDAC.CCDAO.CCHormigaDAO;
import CCInfra.EcuAnt;

public class  CCEntomologo implements CCIEntomologo{
    @Override
    public void ccEducar(Hormiga hormiga){
        try {
            new CCHormigaDAO().entrenar(hormiga.getId());
            EcuAnt.show_mesg_correct(hormiga.getTipo()+" entrenada y sumisa ", "Entrenar Hormigas");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
