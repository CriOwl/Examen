package CCUIC.CCCustomerControl;

import CCUIC.CCResource.EcuAnt;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;

public class Text_box extends JTextField{
    public Text_box(Font font, Color color){
        customize_textfield( font, color);
    }
    public Text_box(){
        customize_textfield();
    }
    
    public Text_box(Font font){
        customize_textfield(font);
    }
    private void customize_textfield(Font font,Color color){
        setFont(font);
        setForeground(color);
        setOpaque(false);
        setCaretColor(EcuAnt.COLOR_CURSOR);
        setMargin(new Insets(10, 10, 10, 10));
    }
    private void customize_textfield(Font font){
        setFont(font);
        setOpaque(false);
        //setCaretColor(Spark_Style.COLOR_CURSOR);
        setMargin(new Insets(10, 10, 10, 10));
    }
    private void customize_textfield(){
        setFont(EcuAnt.FONT);
        //setForeground(Spark_Style.COLOR_FONT_LIGHT);
        setCaretColor(EcuAnt.COLOR_CURSOR);
        setOpaque(false);
        setMargin(new Insets(10, 10, 10, 10));
    }
    
}
