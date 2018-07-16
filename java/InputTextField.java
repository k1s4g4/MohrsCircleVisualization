import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class InputTextField extends JTextField{
    
    public InputTextField(){
        setPreferredSize(new Dimension (80,40));
        setForeground(new Color(255,255,255));
        setBackground(new Color(7,100,171));
        setCaretColor(new Color(255,255,255));
        setFont(new Font("Serif", Font.PLAIN, 25));
        Border border = BorderFactory.createBevelBorder(1,new Color(7,100,171),new Color(50,50,110));
        setBorder(border);
    }

    
}
