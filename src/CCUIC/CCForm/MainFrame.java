package CCUIC.CCForm;
import CCUIC.CCResource.EcuAnt;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatMonokaiProIJTheme;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.UIManager;


public class MainFrame extends JFrame {
    private  final JButton change_themes = new JButton();
    private  final ImageIcon moon_theme_icon = new ImageIcon (new ImageIcon(EcuAnt.URL_MOON_THEMES).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
    private  final ImageIcon sun_theme_icon = new ImageIcon(new ImageIcon(EcuAnt.URL_SUN_THEMES).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
    private  final ImageIcon logo = new ImageIcon(EcuAnt.URL_LOGO);
    private JFrame main_windown;
    private boolean is_dark=true;

    public MainFrame(String name_app) {
        created_windown(name_app);
    }

    public void created_windown(String name_app) {
        try {
        UIManager.setLookAndFeel(new FlatCarbonIJTheme());
        main_windown = new JFrame(name_app);
        main_windown.setExtendedState(JFrame.MAXIMIZED_BOTH);
        main_windown.setIconImage(logo.getImage());
        main_windown.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel themes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        themes.setOpaque(false);
        main_windown.add(themes, BorderLayout.NORTH);
        themes.add(change_themes);
        change_themes.setPreferredSize(new Dimension(40, 40));
        change_themes.setIcon(sun_theme_icon);
        change_themes.addActionListener(e -> change_icon_themes(this.is_dark));
        menu_panel();
        main_windown.setVisible(true);
        
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void  change_icon_themes(boolean is_dark) {
            try {
                if (is_dark) {
                    change_themes.setIcon(moon_theme_icon);
                    UIManager.setLookAndFeel(new FlatCyanLightIJTheme());
                } else {
                    change_themes.setIcon(sun_theme_icon);
                    UIManager.setLookAndFeel(new FlatMonokaiProIJTheme());
                }
            } catch (Exception e) {
                System.out.println("No se puede cargar el tema");
            }
        SwingUtilities.updateComponentTreeUI(main_windown);
        this.is_dark=!is_dark;
    }
    
    private void menu_panel(){
        Menu_panel menu=new Menu_panel();
        Container container=getContentPane();
        container.setLayout(new BorderLayout());
        container.add(menu,BorderLayout.WEST);
        TablaHormiga ta=new TablaHormiga();
        container.setPreferredSize(new Dimension(300,getHeight()));
        container.add(ta);
        main_windown.add(container);
        main_windown.revalidate();
        main_windown.add(container);
        main_windown.revalidate();
    }
    private void change_panel_menu(JPanel panel){
        main_windown.remove(panel);
        main_windown.add(panel,BorderLayout.CENTER);
        main_windown.revalidate();
    }

    
}
