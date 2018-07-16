import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
 public class myButton extends JButton{
        
        public myButton(String name){
            setMargin(new Insets(3, 0, 3, 0));
            setBackground(new Color(7,100,180));
            setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
            setForeground(Color.white);
            this.setText(name);
            setFocusPainted(false);
            Border border = BorderFactory.createBevelBorder(0,new Color(7,100,171),new Color(50,50,110));
            setBorder(border);
            setRolloverEnabled(true);
         }
 }
