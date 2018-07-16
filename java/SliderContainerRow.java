
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class SliderContainerRow extends JPanel{
   private myLabel constSizeLabel;
   private myButton1 minBtn,maxBtn;
   private mySlider slider;
   
   public SliderContainerRow(String labelName,int min, int value,int max){
     setPreferredSize(new Dimension(350,30));
     setLayout(new FlowLayout());
     setOpaque(false);
     constSizeLabel=new myLabel(labelName);
     add(constSizeLabel);
     minBtn=new myButton1("min");
     maxBtn=new myButton1("max");
     slider=new mySlider(min,value,max);
     add(minBtn);
     add(slider);
     add(maxBtn);
     
   }
   //=========================================================================================================
   //========================================ACCESOR METHODS==================================================
   //=========================================================================================================
   public myButton1 getMinButton(){
       return minBtn;
   }
   public myButton1 getMaxButton(){
       return maxBtn;
   }
   public myLabel getLabel(){
       return constSizeLabel;
   }
   public mySlider getSlider(){
       return slider;
   }
   //==========================================================================================================
   //========================================MUTATOR METHODS===================================================
   //==========================================================================================================
}

