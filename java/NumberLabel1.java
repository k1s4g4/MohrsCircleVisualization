import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
public class NumberLabel1 extends JLabel
{


    public NumberLabel1(double number){
        setText(number+"");
        setPreferredSize(new Dimension (80,30));
        //setOpaque(true);
        //setBackground(new Color(7,80,190,100));
        setForeground(Color.white);
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