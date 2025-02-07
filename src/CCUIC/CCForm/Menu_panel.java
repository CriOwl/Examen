package CCUIC.CCForm;

import CCInfra.EcuAnt;
import CCUIC.CCCustomerControl.Button_Text;
import java.awt.*;
import javax.swing.*;

public class Menu_panel extends JPanel {
    public Button_Text boton;

    public Menu_panel() {
        customizepanel();
    }

    private void init_component() {
            boton = new Button_Text("Formulario", EcuAnt.FONT, null);

    }

    private void customizepanel() {
        init_component();
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setPreferredSize(new Dimension(300, getHeight()));
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.gridy = 0;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        boton.setPreferredSize(new Dimension(250, 50));
        add(boton, gbc);
        }
    }