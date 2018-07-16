import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class MohrCanvasContainer extends JPanel{
    private MohrCanvas1 myMohrCanvas1;
    private Mohr myMohr;
    public MohrCanvasContainer(Mohr myMohr){
        this.myMohr=myMohr;
        myMohrCanvas1=new MohrCanvas1(myMohr);
        setBackground(new Color(7,100,171));
        this.setLayout(new BorderLayout(10,10));
        add(myMohrCanvas1,BorderLayout.CENTER);  
        setOpaque(true);
        
        
    }
    public void setRunning(boolean a){
        myMohrCanvas1.setRunning(a);
    }
}