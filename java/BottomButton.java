import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
public class BottomButton extends JPanel{
    private JButton myButton4;
    private JLabel myErrorLbl;
    public BottomButton(){
        setPreferredSize(new Dimension (400,10));
        setBackground(new Color(7,100,171));
        setLayout(new GridLayout(2,3,0,0));
        setForeground(new Color(255,255,255));
        myButton4=new JButton("<html><p style=\"padding-top:-5; color:white; font-size:20; \">Continue</p>");
        myButton4.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        myButton4.setBackground(new Color(7,100,171));
        Border border = BorderFactory.createBevelBorder(0,new Color(7,100,171),new Color(50,50,110));
        myButton4.setBorder(border);
        myButton4.setPreferredSize(new Dimension (100,20));
        myButton4.setFocusPainted(false);
        add(new JLabel());
        add(myButton4);
        add(new JLabel());
        myErrorLbl=new JLabel();
        add(new JLabel());
        add(myErrorLbl);
        add(new JLabel());
        
    }
    public JButton getButton(){
        return myButton4;
    }
    public JLabel getErrorLabel(){
        return myErrorLbl;
    }
}
