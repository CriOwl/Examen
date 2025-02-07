package CCUIC.CCForm;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import CCInfra.EcuAnt;

public class MainPanel extends JPanel {
    public MainPanel() {
        ccCustomize();
    }

    private void ccCustomize(){
        try {
            ImageIcon imageIcon = new ImageIcon(EcuAnt.URL_MAIN);
            add(new JLabel(imageIcon), BorderLayout.CENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
