
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
public class CanvasPanel extends JPanel{
    
    public CanvasPanel(){
        setOpaque(false);
        setPreferredSize(new Dimension (400,30));
        this.setLayout(new GridLayout(0,1,0,0));
        Canvas myCanvas=new StartCanvas();
        add(myCanvas,BorderLayout.CENTER);
        
    }

}
