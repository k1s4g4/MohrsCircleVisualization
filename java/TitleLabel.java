import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
public class TitleLabel extends JLabel
{


    public TitleLabel(String name){
        setText(name);
        //setMargin(new Insets(0, 0, 0, 0));
        setPreferredSize(new Dimension (34,30));
        //setOpaque(true);
        //setBackground(new Color(7,80,190,100));
        setForeground(new Color(27,170,255));
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.TOP);
        setFont(new Font("Serif", Font.PLAIN, 13));
        Border border = BorderFactory.createBevelBorder(1,new Color(7,100,171),new Color(50,50,110));
        setBorder(border);
        
    }
}
    

