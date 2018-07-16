import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class ElementCanvasContainer extends JPanel{
    private ElementCanvas1 myElementCanvas1;
    private Mohr myMohr;
    public ElementCanvasContainer(Mohr myMohr){
        this.myMohr=myMohr;
        setBackground(new Color(7,100,171));
        myElementCanvas1=new ElementCanvas1(myMohr);
        this.setLayout(new BorderLayout(10,10));
        add(myElementCanvas1,BorderLayout.CENTER);
        setOpaque(false);    
    }
    public void setRunning(boolean a){
        myElementCanvas1.setRunning(a);
    }
}
