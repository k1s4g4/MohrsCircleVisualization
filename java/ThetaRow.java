
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ThetaRow extends JPanel{
   private ThetaLabel thetaLabel;
   private ThetaButton thetaMinBtn,thetaMaxBtn;
   private ThetaSlider thetaSlider;
   
   public ThetaRow (String labelName,int min, int value,int max){
     setPreferredSize(new Dimension(300,30));
     setOpaque(false);
     setLayout(new FlowLayout());
     thetaLabel=new ThetaLabel(labelName);
     add(thetaLabel);
     thetaMinBtn=new ThetaButton("min");
     thetaMaxBtn=new ThetaButton("max");
     thetaSlider=new ThetaSlider(min,value,max);
     add(thetaMinBtn);
     add(thetaSlider);
     add(thetaMaxBtn);
     
   }
   //=========================================================================================================
   //========================================ACCESOR METHODS==================================================
   //=========================================================================================================
   public ThetaButton getThetaMinButton(){
       return thetaMinBtn;
   }
   public ThetaButton getThetaMaxButton(){
       return thetaMaxBtn;
   }
   public ThetaLabel getThetaLabel(){
       return thetaLabel;
   }
   public ThetaSlider getThetaSlider(){
       return thetaSlider;
   }
   //==========================================================================================================
   //========================================MUTATOR METHODS===================================================
   //==========================================================================================================
}

