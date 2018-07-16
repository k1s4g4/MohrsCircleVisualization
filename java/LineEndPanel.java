import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class LineEndPanel extends JPanel{
    public Mohr myMohr;
    private ElementCanvasContainer myCanvasContainer;
    private SliderPanelContainer mySliders;
    private LabelPanelContainer myLabels;
    public LineEndPanel(Mohr myMohr){
        this.myMohr=myMohr;
        setOpaque(false);
        //setBackground(new Color(7,130,171));
        this.setLayout(new GridLayout(3,1,10,10));
        myLabels=new LabelPanelContainer(myMohr);
        myCanvasContainer=new ElementCanvasContainer(myMohr);
        mySliders=new SliderPanelContainer(myMohr,new intMohr(myMohr),myLabels,myCanvasContainer);
        //myCanvasContainer=new ElementCanvasContainer();
        
        add(myCanvasContainer);
        add(mySliders);
        add(myLabels);
    }
    public ElementCanvasContainer getElementCanvasContainer(){
        return myCanvasContainer;
    }
}
