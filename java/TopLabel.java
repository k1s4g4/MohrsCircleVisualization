import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TopLabel extends JPanel{
    private JLabel myLabel4;
    public TopLabel(){
        setLayout(new GridLayout(1,0,0,0));
        setPreferredSize(new Dimension (400,5));
        setBackground(new Color(7,100,171));
        setForeground(new Color(255,255,255));
        myLabel4=new JLabel("<html><p style=\"padding-top:-5; color:white; font-size:25; \">Please insert your load data:</p>");
        myLabel4.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        //myLabel4.setOpaque(true);
        myLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        myLabel4.setVerticalAlignment(SwingConstants.CENTER);
        add(myLabel4);
    }
}
