package CCInfra;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

public abstract class EcuAnt {
    public static final Color COLOR_FONT = new Color(250, 250, 250);
    public static final Color COLOR_FONT_LIGHT = new Color(100, 100, 100);
    public static final Color COLOR_CURSOR = Color.black; // cambiar segun el estilo
    public static final Color COLOR_BACKGROUND          = new Color(100, 100, 100);
    public static final Color COLOR_BACKGROUND_GRID     = new Color(100, 100, 100);
    public static final Color COLOR_BACKGROUND_SELECT   = new Color(100, 100, 100);
    public static final Font FONT = new Font("Cambria Math", Font.PLAIN, 15);
    public static final Font FONT_BOLD = new Font("Century Gothic", Font.BOLD, 15);
    public static final Font FONT_SMALL = new Font("JetBrains Mono", Font.PLAIN, 15);
    public static final Font FONT_NUMBER = new Font("Digital-7 Mono", Font.PLAIN, 15);
    public static final Dimension dimension_button = new Dimension(150, 45);

    public static final int ALIGNMENT_LEFT = SwingConstants.LEFT;
    public static final int ALIGNMENT_RIGHT = SwingConstants.RIGHT;
    public static final int ALIGNMENT_CENTER = SwingConstants.CENTER;

    public static final Cursor CURSOR_HAND = new Cursor(Cursor.HAND_CURSOR);
    public static final Cursor CURSOR_DEFAULT = new Cursor(Cursor.DEFAULT_CURSOR);

    public static final String URL_MAIN = ("src\\CCUIC\\CCResource\\Icon\\LogAnt.png");
    public static final String URL_LOGO = "src\\CCUIC\\CCResource\\Icon\\LogAnt.png";
    public static final String URL_SUN_THEMES = "src\\CCUIC\\CCResource\\Icon\\moon.png";
    public static final String URL_MOON_THEMES = "src\\CCUIC\\CCResource\\Icon\\sun.png";
    public static final String URL_CHECK = "src\\CCUIC\\CCResource\\Icon\\Check.png"; 
    public static final String DATAFILE = "Data\\hormiguero.csv";
    public static final String LOGFILE = "Data\\log.txt";
    

    public static final void show_mesg_advert(String msg, String title) {
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.ERROR_MESSAGE);

    }

    public static final void show_mesg_correct(String msg, String title) {
        ImageIcon check = new ImageIcon(
                new ImageIcon(URL_CHECK).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.PLAIN_MESSAGE, check);
    }

    public static final int show_mesg_yes_no(String msg, String title) {
        String[] option = { "SI", "No" };
        return JOptionPane.showOptionDialog(null, msg, title, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
        option, option[0]);
    }

    public static JTable customize_table(JTable tabla) {
        tabla.setGridColor(EcuAnt.COLOR_BACKGROUND_GRID);
        tabla.setSelectionBackground(EcuAnt.COLOR_BACKGROUND_SELECT);
        tabla.setSelectionForeground(EcuAnt.COLOR_FONT);
        tabla.setRowHeight(30);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabla.setOpaque(false);
        tabla.setFocusable(true);
        tabla.setRowSelectionAllowed(true);
        tabla.setColumnSelectionAllowed(false);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.setDefaultEditor(Object.class, null);
        return tabla;
    }
}