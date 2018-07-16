
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class CircleRow extends JPanel{
    private TitleLabel titleLabelCircle1;
    private NumberLabel numberLabelCircle1;
    private TitleLabel titleLabelCircle2;
    private NumberLabel numberLabelCircle2;
    public CircleRow(String title1,double number1,String title2,double number2){
        setLayout(new FlowLayout(FlowLayout.RIGHT,27,0));
        setOpaque(false);
        titleLabelCircle1=new TitleLabel(title1);
        numberLabelCircle1=new NumberLabel(number1);
        titleLabelCircle2=new TitleLabel(title2);
        numberLabelCircle2=new NumberLabel(number2);
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
