import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class AfterRow extends JPanel{
    private TitleLabel2 titleLabelAfter1;
    private NumberLabel2 numberLabelAfter1;
    private TitleLabel2 titleLabelAfter2;
    private NumberLabel2 numberLabelAfter2;
    public AfterRow(String title1,double number1,String title2,double number2){
        setLayout(new FlowLayout(FlowLayout.RIGHT,27,0));
        setOpaque(false);
        titleLabelAfter1=new TitleLabel2(title1);
        numberLabelAfter1=new NumberLabel2(number1);
        titleLabelAfter2=new TitleLabel2(title2);
        numberLabelAfter2=new NumberLabel2(number2);
        add(titleLabelAfter1);
        add(numberLabelAfter1);
        add(titleLabelAfter2);
        add(numberLabelAfter2);
    }
    //================mutator methods================================
    public void setNumber1(double number){
         numberLabelAfter1.setNumber(number);    
    }
    public void setNumber2(double number){
         numberLabelAfter2.setNumber(number);    
    }
    
}
