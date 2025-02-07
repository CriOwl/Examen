package CCUIC.CCForm;

import CCBLC.CCBlTable;
import CCBLC.CCBlView;
import CCDAC.CCDAO.CCGenomaDAO;
import CCDAC.CCDAO.CCHormigaTablaDAO;
import CCDAC.CCDAO.CCIngestaDAO;
import CCDAC.CCDTO.CCGenomaDTO;
import CCDAC.CCDTO.CCHormigaTablaDTO;
import CCDAC.CCDTO.CCIngestaNativaDTO;
import CCUIC.CCCustomerControl.Button_Text;
import CCUIC.CCCustomerControl.Text_box;
import CCUIC.CCCustomerControl.Text_label;
import CCUIC.CCResource.EcuAnt;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class TablaHormiga extends JPanel {
    private final Button_Text ccCrearLarva;
    private final Button_Text ccAlimentar;
    private final Button_Text ccBuscar;
    private final Button_Text ccEliminar;
    private final Button_Text ccGuardar;
    private JComboBox<String> ccGenoma;
    private JComboBox<String> ccIngesta;
    private final Text_box ccBusqueda;
    private final Text_label ccBusquedaEtiqueta;
    private final HashMap<String,Integer> ccMapGenoma=new HashMap<>();
    private final HashMap<String,Integer> ccMapAlimento=new HashMap<>();
    private JTable ccTabla;
    private JScrollPane ccScroll;
    private String[] ccArrayGenoma;
    private String[] ccArrayIngesta;

    public TablaHormiga() {
        setLayout(new GridBagLayout());
        ccCrearLarva = new Button_Text("Crear Larva", EcuAnt.FONT_BOLD, null);
        ccAlimentar = new Button_Text("Alimentar", EcuAnt.FONT_BOLD, null);
        ccEliminar = new Button_Text("Eliminar", EcuAnt.FONT_BOLD, null);
        ccGuardar = new Button_Text("Guardar", EcuAnt.FONT_BOLD, null);
        ccBuscar = new Button_Text("Buscar", EcuAnt.FONT_BOLD, null);
        ccBusqueda = new Text_box(EcuAnt.FONT_BOLD, null);
        ccBusquedaEtiqueta = new Text_label("Nombre:");
        ccGenoma=new JComboBox<>(ccData_Genoma());
        ccIngesta=new JComboBox<>(ccDataIngesta());
        ccBuscar.addActionListener(e -> change_table());
        created_table();
        setup_panel();
    }

    private void change_table() {
        String ccTipo = ccBusqueda.getText().trim();
        if (ccTipo.isEmpty()||ccTipo.isBlank()) {
            created_table();
        }else{
            search(ccTipo);
        }
        ccTabla.revalidate();
        ccTabla.repaint();
    }

    private void created_table() {
        CCBlView<CCHormigaTablaDTO> blHormiguero = new CCBlView<>(CCHormigaTablaDAO::new);
        try {
            String[] columns = blHormiguero.getColumn().stream().map(c -> c.getColumnas()).toArray(String[]::new);
            List<CCHormigaTablaDTO> hormiguero= blHormiguero.getAll();
            Object[][] data = new Object[hormiguero.size()][columns.length];
            int index = 0;
            for (CCHormigaTablaDTO Hormiga : hormiguero) {
                data[index][0] = Hormiga.getIdHormiga();
                data[index][1] = Hormiga.getTipoHormiga();
                data[index][2] = Hormiga.getSexo();
                data[index][3] = Hormiga.getAlimento();
                data[index][4] = Hormiga.getEstado();
                data[index][5] = Hormiga.getEntrenado();
                index++;
            }
            if (ccTabla == null) {
                ccTabla = new JTable();
                ccTabla = new JTable(new DefaultTableModel(data, columns));
                ccTabla=EcuAnt.customize_table(ccTabla);
                ccScroll = new JScrollPane(ccTabla);
            }
            ccTabla.setModel(new DefaultTableModel(data, columns));
            ccTabla.revalidate();
            ccTabla.repaint();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void search(String Tipo) {
        CCBlView<CCHormigaTablaDTO> blHormiguero = new CCBlView<>(CCHormigaTablaDAO::new);
        try {
            String[] columns = blHormiguero.getColumn().stream().map(c -> c.getColumnas()).toArray(String[]::new);
            List<CCHormigaTablaDTO> hormiguero= blHormiguero.search(Tipo);
            Object[][] data = new Object[hormiguero.size()][columns.length];
            int index = 0;
            for (CCHormigaTablaDTO Hormiga : hormiguero) {
                data[index][0] = Hormiga.getIdHormiga();
                data[index][1] = Hormiga.getTipoHormiga();
                data[index][2] = Hormiga.getSexo();
                data[index][3] = Hormiga.getAlimento();
                data[index][4] = Hormiga.getEstado();
                data[index][5] = Hormiga.getEntrenado();
                index++;
            }
            ccTabla.setModel(new DefaultTableModel(data, columns));
            ccTabla.revalidate();
            ccTabla.repaint();
        } catch (Exception e) {
            System.out.println(e);
        }
    } 

    private void setup_panel() {
        setLayout(new GridBagLayout());
        JTableHeader ccHeader = ccTabla.getTableHeader();
        ccHeader.setFont(EcuAnt.FONT_BOLD);
        ccScroll.setPreferredSize(new Dimension(1000, 250));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.weightx = 3;
        gbc.weighty = 3;
        gbc.fill = GridBagConstraints.BOTH;
        add(ccScroll, gbc);
        Dimension buttonSize = new Dimension(120, 30);
        ccCrearLarva.setPreferredSize(buttonSize);
        ccAlimentar.setPreferredSize(buttonSize);
        ccEliminar.setPreferredSize(buttonSize);
        ccGuardar.setPreferredSize(buttonSize);
        ccBuscar.setPreferredSize(buttonSize);
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridy = 3; 
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        add(ccCrearLarva, gbc);
        gbc.gridx = 1;
        add(ccAlimentar, gbc);
        gbc.gridx = 2;
        add(ccEliminar, gbc);
        gbc.gridx = 3;
        add(ccGuardar, gbc);
        gbc.gridy = 2; 
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        add(ccIngesta, gbc);
        gbc.gridx = 2;
        add(ccGenoma, gbc);
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(ccBusquedaEtiqueta, gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(ccBusqueda, gbc);
        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(ccBuscar, gbc);
    }
    private String[] ccData_Genoma(){
        try {
            CCBlTable<CCGenomaDTO> ccBlGenoma=new CCBlTable<>(CCGenomaDAO::new);
            List<CCGenomaDTO> ccList=ccBlGenoma.read_elments();
            ccArrayGenoma=new String [ccList.size()];
            for (int index = 0; index < ccList.size(); index++) {
                ccArrayGenoma[index]=ccList.get(index).getName();
                ccMapGenoma.put(ccList.get(index).getName(), ccList.get(index).getIdGenoma());
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return ccArrayGenoma;
    }
    private String[] ccDataIngesta(){
        try {
            CCBlTable<CCIngestaNativaDTO> ccBlGenoma=new CCBlTable<>(CCIngestaDAO::new);
            List<CCIngestaNativaDTO> ccList=ccBlGenoma.read_elments();
            ccArrayIngesta=new String [ccList.size()];
            for (int index = 0; index < ccList.size(); index++) {
                ccArrayIngesta[index]=ccList.get(index).getName();
                ccMapGenoma.put(ccList.get(index).getName(), ccList.get(index).getIdIngestaNativa());
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return ccArrayIngesta;
    }

    private <ccName,ccId> ccName ccBuscarMap(Map<ccName,ccId> ccMap,ccId Id){
    for (Map.Entry<ccName,ccId> entry : ccMap.entrySet()) {
            if (entry.getValue().equals(Id)) {
                System.out.println(entry.getKey());
                return entry.getKey();
            }
        }
        return null; 
    }
}
