import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class myLabel extends JLabel{
    public myLabel(String name){
        this.setText(name);
        setFont(new Font("Serif", Font.PLAIN, 23));
        setOpaque(false);
        setForeground(Color.white);
        setPreferredSize(new Dimension (50,30));
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
    }
}
