
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
public class myButton1 extends JButton{
    private String myName;
    public myButton1(String name){
        setMargin(new Insets(0, 0, 0, 0));
        setBackground(new Color(7,100,180));
        setForeground(Color.white);
        setFont(new Font("Comic Sans MS", Font.PLAIN, 10));
        setVerticalAlignment(SwingConstants.CENTER);
        setPreferredSize(new Dimension (30,15));
        setText(name);
        setFocusPainted(false);
        Border border = BorderFactory.createBevelBorder(0,new Color(7,100,171),new Color(50,50,110));
        setBorder(border);
    }
    public void setName(String na){
        myName=na;
    }
    public String getName(){
        return myName;
    }
}