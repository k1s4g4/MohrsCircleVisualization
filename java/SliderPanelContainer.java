import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
public class SliderPanelContainer extends JPanel{
    private LabelPanelContainer myLabels;
    private MohrCanvasContainer myMohrCanvasContainer;
    private ElementCanvasContainer myCanvasContainer;
    private Mohr myMohr1;
    private int minSigmaA;
    private int sigmaA;
    private int maxSigmaA;
    private int minSigmaB;
    private int sigmaB;
    private int maxSigmaB;
    private int minTauA;
    private int tauA;
    private int maxTauA;
    private int minTheta0;
    private int theta0;
    private int maxTheta0;
    private int minTheta1;
    private int theta1;
    private int maxTheta1;
    private int minCohesion;
    private int cohesion;
    private int maxCohesion;
    private int minFrictionAngle;
    private int frictionAngle;
    private int maxFrictionAngle;
    private mySlider sliderSigmaA,sliderSigmaB,sliderTauA,sliderCohesion,sliderFrictionAngle;
    private ThetaSlider sliderTheta0,sliderTheta1;
    private SliderContainerRow rowA,rowB,rowTau,rowC,rowPhi;
    private ThetaRow rowTheta0,rowTheta1;
    private myButton1 minSigmaABtn,maxSigmaABtn,minSigmaBBtn,maxSigmaBBtn,minTauBtn,maxTauBtn,minCohesionBtn,maxCohesionBtn,minFrictionAngleBtn,maxFrictionAngleBtn;
    public SliderPanelContainer(Mohr myMohr1,intMohr myMohr,LabelPanelContainer myLabels,ElementCanvasContainer myCanvasContainer){
        this.myMohrCanvasContainer=myMohrCanvasContainer;
        this.myCanvasContainer=myCanvasContainer;
        this.myMohr1=myMohr1;
        this.myLabels=myLabels;
        setBackground(Color.BLUE);
        setOpaque(true);
        //setPreferredSize(new Dimension(350,400));
        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        setBackground(new Color(7,100,171));
        minSigmaA=myMohr.getIntMinSigmaA();
        sigmaA=myMohr.getIntSigmaA();
        maxSigmaA=myMohr.getIntMaxSigmaA();
        minSigmaB=myMohr.getIntMinSigmaB();
        sigmaB=myMohr.getIntSigmaB();
        maxSigmaB=myMohr.getIntMaxSigmaB();
        minTauA=myMohr.getIntMinTauA();
        tauA=myMohr.getIntTauA();
        maxTauA=myMohr.getIntMaxTauA();
        minTheta0=myMohr.getIntMinTheta0();
        theta0=myMohr.getIntTheta0();
        maxTheta0=myMohr.getIntMaxTheta0();
        minTheta1=myMohr.getIntMinTheta1();
        theta1=myMohr.getIntTheta1();
        maxTheta1=myMohr.getIntMaxTheta1();
        minCohesion=myMohr.getIntMinCohesion();
        cohesion=myMohr.getIntCohesion();
        maxCohesion=myMohr.getIntMaxCohesion();
        minFrictionAngle=myMohr.getIntMinFrictionAngle();
        frictionAngle=myMohr.getIntFrictionAngle();
        maxFrictionAngle=myMohr.getIntMaxFrictionAngle();
        
        
        rowA=new SliderContainerRow("<html><p style=\"padding-top:-12; font-size:22; font-family:Serif;\" >σ<sub style=\"font-size:13;\">A</sub> :<p> ",minSigmaA,sigmaA,maxSigmaA);
        sliderSigmaA=rowA.getSlider();
        event e=new event();
        sliderSigmaA.addChangeListener(e);
        rowB=new SliderContainerRow("<html><p style=\"padding-top:-12; font-size:22; font-family:Serif;\" >σ<sub style=\"font-size:13;\">B</sub>  :<p> ",minSigmaB,sigmaB,maxSigmaB);
        sliderSigmaB=rowB.getSlider();
        sliderSigmaB.addChangeListener(e);
        rowTau=new SliderContainerRow("<html><p style=\"padding-top:-12; font-size:22; font-family:Serif;\" >  τ  :<p>  ",minTauA,tauA,maxTauA);
        sliderTauA=rowTau.getSlider();
        sliderTauA.addChangeListener(e);
        rowTheta0=new ThetaRow("<html> <p style=\"padding-top:-12; font-size:22; font-family:Serif;\" >  θ<sub style=\"font-size:13;\">0</sub> : <p>",minTheta0,theta0,maxTheta0);
        sliderTheta0=rowTheta0.getThetaSlider();
        sliderTheta0.addChangeListener(e);
        ThetaLabel lbl=rowTheta0.getThetaLabel();
        rowTheta1=new ThetaRow("<html><p style=\"padding-top:-12; font-size:22; font-family:Serif;\" >Δθ:<p>",minTheta1,theta1,maxTheta1);
        sliderTheta1=rowTheta1.getThetaSlider();
        sliderTheta1.addChangeListener(e);
        rowC=new SliderContainerRow("<html><p style=\"padding-top:-12; font-size:22; font-family:Serif;\" >  c  :<p>  ",minCohesion,cohesion,maxCohesion);
        sliderCohesion=rowC.getSlider();
        sliderCohesion.addChangeListener(e);
        rowPhi=new SliderContainerRow("<html><p style=\"padding-top:-12; font-size:22; font-family:Serif;\" >  φ  :<p>  ",minFrictionAngle,frictionAngle,maxFrictionAngle);
        sliderFrictionAngle=rowPhi.getSlider();
        sliderFrictionAngle.addChangeListener(e);
        
        minSigmaABtn=rowA.getMinButton();
        maxSigmaABtn=rowA.getMaxButton();
        minSigmaBBtn=rowB.getMinButton();
        maxSigmaBBtn=rowB.getMaxButton();
        minTauBtn=rowTau.getMinButton();
        maxTauBtn=rowTau.getMaxButton();
        minCohesionBtn=rowC.getMinButton();
        maxCohesionBtn=rowC.getMaxButton();
        maxFrictionAngleBtn=rowPhi.getMaxButton();
        minFrictionAngleBtn=rowPhi.getMinButton();
        
        ChangeBound minMaxListener=new ChangeBound();
        minSigmaABtn.addActionListener(minMaxListener);
        minSigmaABtn.setName("minSigmaA");
        maxSigmaABtn.addActionListener(minMaxListener);
        maxSigmaABtn.setName("maxSigmaA");
        minSigmaBBtn.addActionListener(minMaxListener);
        minSigmaBBtn.setName("minSigmaB");
        maxSigmaBBtn.addActionListener(minMaxListener);
        maxSigmaBBtn.setName("maxSigmaB");
        minTauBtn.addActionListener(minMaxListener);
        minTauBtn.setName("minTau");
        maxTauBtn.addActionListener(minMaxListener);
        maxTauBtn.setName("maxTau");
        minCohesionBtn.addActionListener(minMaxListener);
        minCohesionBtn.setName("minCohesion");
        maxCohesionBtn.addActionListener(minMaxListener);
        maxCohesionBtn.setName("maxCohesion");
        minFrictionAngleBtn.addActionListener(minMaxListener);
        minFrictionAngleBtn.setName("minFrictionAngle");
        minFrictionAngleBtn.setEnabled(false);
        maxFrictionAngleBtn.addActionListener(minMaxListener);
        maxFrictionAngleBtn.setName("maxFrictionAngle");
        maxFrictionAngleBtn.setEnabled(false);
        
        
        add(rowA);
        add(rowB);
        add(rowTau);
        add(rowTheta0);
        add(rowTheta1);
        add(rowC);
        add(rowPhi);
        
    }
    //==========================================================================================================
    //========================================ACCESOR METHODS===================================================
    //==========================================================================================================
    public SliderContainerRow getRowA(){
        return rowA;
    }
    public SliderContainerRow getRowB(){
        return rowB;
    }
    public SliderContainerRow getRowTau(){
        return rowTau;
    }
    public ThetaRow getRowTheta0(){
        return rowTheta0;
    }
    public ThetaRow getRowTheta1(){
        return rowTheta1;
    }
    //==========================================================================================================
    //========================================EVENT CLASSES=====================================================
    //==========================================================================================================
    public class event implements ChangeListener{
        private int index;
        private int maxIter;
        public void stateChanged(ChangeEvent e){
            
            int valueSigmaA=sliderSigmaA.getValue();
            int valueSigmaB=sliderSigmaB.getValue();
            int valueTauA=sliderTauA.getValue();
            int valueTheta0=sliderTheta0.getValue();
            int valueTheta1=sliderTheta1.getValue();
            int valueCohesion=sliderCohesion.getValue();
            int valueFrictionAngle=sliderFrictionAngle.getValue();
            myMohr1.setSigmaA(valueSigmaA*0.01);
            myMohr1.setSigmaB(valueSigmaB*0.01);
            myMohr1.setTau(valueTauA*0.01);
            myMohr1.setTheta0(valueTheta0*0.01);
            myMohr1.setTheta1(valueTheta1*0.01);
            myMohr1.setCohesion(valueCohesion*0.01);
            myMohr1.setFrictionAngle(valueFrictionAngle*0.01);
            myMohr1.calculate();
            
            myLabels.refresh();
           
        }
    }
    public class ChangeBound implements ActionListener {
         public void actionPerformed(ActionEvent evt) {
             myButton1 myBtn=(myButton1)evt.getSource();
             String label=evt.getActionCommand();
             String name=myBtn.getName();
             
             if(label.equals("min")){
                 //new ChangeBoundsFrame();
                 
                 if(name.equals("minSigmaA")){
                     mySlider slider=rowA.getSlider();
                     name=rowA.getLabel().getText();
                     new ChangeBoundsFrame(slider,name,"min",myMohr1);
                 }else if(name.equals("minSigmaB")){
                     mySlider slider=rowB.getSlider();
                     name=rowB.getLabel().getText();
                     new ChangeBoundsFrame(slider,name,"min",myMohr1);
                 }else if (name.equals("minTau")){
                     mySlider slider=rowTau.getSlider();
                     name=rowTau.getLabel().getText();
                     new ChangeBoundsFrame(slider,name,"min",myMohr1);
                 }else if(name.equals("minCohesion")){
                     mySlider slider=rowC.getSlider();
                     name=rowC.getLabel().getText();
                     new ChangeBoundsFrame(slider,name,"min",myMohr1);
                 }else{
                     mySlider slider=rowPhi.getSlider();
                     name=rowPhi.getLabel().getText();
                     new ChangeBoundsFrame(slider,name,"min",myMohr1);
                 }
             }else{
                 
                 if(name.equals("maxSigmaA")){
                     mySlider slider=rowA.getSlider();
                     name=rowA.getLabel().getText();
                     new ChangeBoundsFrame(slider,name,"max",myMohr1);
                 }else if(name.equals("maxSigmaB")){
                     mySlider slider=rowB.getSlider();
                     name=rowB.getLabel().getText();
                     new ChangeBoundsFrame(slider,name,"max",myMohr1);
                 }else if(name.equals("maxTau")){
                     mySlider slider=rowTau.getSlider();
                     name=rowTau.getLabel().getText();
                     new ChangeBoundsFrame(slider,name,"max",myMohr1);
                 }else if(name.equals("maxCohesion")){
                     mySlider slider=rowC.getSlider();
                     name=rowC.getLabel().getText();
                     new ChangeBoundsFrame(slider,name,"max",myMohr1);
                 }else{
                     mySlider slider=rowPhi.getSlider();
                     name=rowPhi.getLabel().getText();
                     new ChangeBoundsFrame(slider,name,"max",myMohr1);
                 }
             }
         }
    }
}
