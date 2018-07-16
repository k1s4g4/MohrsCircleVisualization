import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Write a description of class LabelPanelContainer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LabelPanelContainer extends JPanel{
    public Mohr myMohr;
    private CircleRow circleRow1;
    private CircleRow circleRow2;
    private CircleRow circleRow3;
    private AngleRow circleRow4;
    private BeforeRow beforeRow1;
    private BeforeRow beforeRow2;
    private AfterRow afterRow1;
    private AfterRow afterRow2;
    public LabelPanelContainer(Mohr myMohr){
        this.myMohr=myMohr;
        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        setOpaque(true);
        setBackground(new Color(7,100,171));
        //setBackground(new Color(7,70,171));
        //add(new TitleLabel(""));
        //circleRow1=new CircleRow("<html><a style=\"padding-top:-60; margin:0; font-size:18; font-family:Serif;\" >σ</a><sub style=\"font-size:12;\">ave</sub>",myMohr.getRndSigmaAve(),"<html><a style=\"padding-top:-60; font-size:17; font-family:Serif;\" >R</a>",myMohr.getRndRadius());
        //circleRow2=new CircleRow("<html><a style=\"padding-top:-60; font-size:18; font-family:Serif;\" >σ</a><sub style=\"font-size:12;\">1</sub>",myMohr.getRndSigma1(),"<html><a style=\"padding-top:-60; font-size:17; font-family:Serif;\" >σ</a><sub style=\"font-size:12;\">3</sub>",myMohr.getRndSigma3());
        circleRow3=new CircleRow("<html><p style=\"padding-top:-5; font-size:20; font-family:Serif;\" >σ</a><sub style=\"font-size:12;\">P</sub><p>",myMohr.getRndSigmaP(),"<html><p style=\"padding-top:-5; font-size:20; font-family:Serif;\" >τ<sub style=\"font-size:12;\">P</sub><p>",myMohr.getRndTauP());
        circleRow4=new AngleRow("<html><p style=\"padding-top:-5; font-size:20; font-family:Serif;\" >θ<sub style=\"font-size:12;\">0</sub><p>",myMohr.getRndTheta0(),"<html><p style=\"padding-top:-5; font-size:20; color:black; font-family:Serif;\" >θ<sub style=\"font-size:12; color:black;\">1</sub><p>",myMohr.getRndTheta1());
        beforeRow1=new BeforeRow("<html><p style=\"padding-top:-5; font-size:20; font-family:Serif;\" >σ<sub style=\"font-size:12;\">Α</sub><p>",myMohr.getRndSigmaA(),"<html><p style=\"padding-top:-5; font-size:20; font-family:Serif;\" >τ<sub style=\"font-size:12;\">Α</sub><p>",myMohr.getRndTauA());
        beforeRow2=new BeforeRow("<html><p style=\"padding-top:-5; font-size:20; font-family:Serif;\" >σ<sub style=\"font-size:12;\">Β</sub><p>",myMohr.getRndSigmaB(),"<html><p style=\"padding-top:-5; font-size:20; font-family:Serif;\" >τ<sub style=\"font-size:12;\">Β</sub><p>",myMohr.getRndTauB());
        afterRow1=new AfterRow("<html><p style=\"padding-top:-5; font-size:20; font-family:Serif; color:black;\" >σ<sub style=\"font-size:12; color:black;\">ΑΑ</sub><p>",myMohr.getRndSigmaAA(),"<html><p style=\"padding-top:-5; font-size:20; color:black; font-family:Serif;\" >τ<sub style=\"font-size:12; color:black;\">ΑΑ</sub><p>",myMohr.getRndTauAA());
        afterRow2=new AfterRow("<html><p style=\"padding-top:-5; font-size:20; font-family:Serif; color:black;\" >σ<sub style=\"font-size:12; color:black;\">ΒΒ</sub><p>",myMohr.getRndSigmaBB(),"<html><p style=\"padding-top:-5; font-size:20; color:black; font-family:Serif;\" >τ<sub style=\"font-size:12; color:black;\">ΒΒ</sub><p>",myMohr.getRndTauBB());
        //add(circleRow1);
        //add(circleRow2);
        
        
        
        add(beforeRow1);
        add(beforeRow2);
        add(circleRow4);
        add(afterRow1);
        add(afterRow2);
        add(circleRow3);
        
        
        
       
    }
    public void refresh(){
        //circleRow1.setNumber1(myMohr.getRndSigmaAve());
        //circleRow1.setNumber2(myMohr.getRndRadius());
        //circleRow2.setNumber1(myMohr.getRndSigma1());
        //circleRow2.setNumber2(myMohr.getRndSigma3());
        circleRow3.setNumber1(myMohr.getRndSigmaP());
        circleRow3.setNumber2(myMohr.getRndTauP());
        circleRow4.setNumber1(myMohr.getRndTheta0());
        circleRow4.setNumber2(myMohr.getRndTheta1());
        beforeRow1.setNumber1(myMohr.getRndSigmaA());
        beforeRow1.setNumber2(myMohr.getRndTauA());
        beforeRow2.setNumber1(myMohr.getRndSigmaB());
        beforeRow2.setNumber2(myMohr.getRndTauB());
        afterRow1.setNumber1(myMohr.getRndSigmaAA());
        afterRow1.setNumber2(myMohr.getRndTauAA());
        afterRow2.setNumber1(myMohr.getRndSigmaBB());
        afterRow2.setNumber2(myMohr.getRndTauBB());
    }
    //==========================================================================================================
    //========================================ACCESOR METHODS===================================================
    //==========================================================================================================
}
