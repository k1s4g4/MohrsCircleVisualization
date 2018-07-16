
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
public class InputLabel extends JLabel{
    

    public InputLabel(String name){
        setText(name);
        setPreferredSize(new Dimension (40,40));
        setForeground(new Color(255,255,255));
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.TOP);
        setFont(new Font("Serif", Font.PLAIN, 13));
        Border border = BorderFactory.createBevelBorder(1,new Color(7,100,171),new Color(50,50,110));
        setBorder(border);
        
    }
}
