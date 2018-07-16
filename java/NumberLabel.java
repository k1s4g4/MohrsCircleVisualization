import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
public class NumberLabel extends JLabel
{


    public NumberLabel(double number){
        setPreferredSize(new Dimension (80,30));
        setText(number+"");
        //setOpaque(true);
        //setBackground(new Color(7,80,190,100));
        setForeground(new Color(27,170,255));
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        setFont(new Font("Serif", Font.PLAIN, 16));
        Border border = BorderFactory.createBevelBorder(1,new Color(7,100,171),new Color(50,50,110));
        setBorder(border);
    }
    public void setNumber(double number){
        setText(number+"");
    }
}