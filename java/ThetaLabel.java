import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ThetaLabel extends JLabel{
    public ThetaLabel(String name){
        this.setText(name);
        setPreferredSize(new Dimension (50,30));
        setFont(new Font("Serif", Font.PLAIN, 23));
        setForeground(Color.white);
        setOpaque(false);
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
    }
}
