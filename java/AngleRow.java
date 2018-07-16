import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class AngleRow extends JPanel{
    private TitleLabel1 titleLabelCircle1;
    private NumberLabel1 numberLabelCircle1;
    private TitleLabel2 titleLabelCircle2;
    private NumberLabel2 numberLabelCircle2;
    public AngleRow(String title1,double number1,String title2,double number2){
        setLayout(new FlowLayout(FlowLayout.RIGHT,27,0));
        setOpaque(false);
        
        titleLabelCircle1=new TitleLabel1(title1);
        numberLabelCircle1=new NumberLabel1(number1);
        titleLabelCircle2=new TitleLabel2(title2);
        numberLabelCircle2=new NumberLabel2(number2);
        
        add(titleLabelCircle1);
        add(numberLabelCircle1);
        add(titleLabelCircle2);
        add(numberLabelCircle2);
    }
    //================mutator methods================================
    public void setNumber1(double number){
         numberLabelCircle1.setNumber(number);    
    }
    public void setNumber2(double number){
         numberLabelCircle2.setNumber(number);    
    }
}
