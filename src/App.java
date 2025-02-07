import CCBLC.CCEntities.HormigueroBL;
import CCDAC.CCDAO.CCHormigaDAO;
import CCDAC.CCDAO.CCIngestaDAO;
import CCDAC.CCDTO.CCHormigaDTO;
import CCDAC.CCDTO.CCIngestaNativaDTO;
import CCUIC.CCForm.MainFrame;

public class App {
    public static void main(String[] args) throws Exception {
        HormigueroBL sdf= new HormigueroBL();
        CCHormigaDAO map=new CCHormigaDAO();
        CCIngestaDAO ta=new CCIngestaDAO();
        ta.delete(1);
        for (CCIngestaNativaDTO s : ta.ccReadBox()) {
            System.out.println(s.toString());
        }
        map.created(new CCHormigaDTO(1,2));
        map.delete(1);
        MainFrame venta= new MainFrame("EcuAnt");
    }
}
