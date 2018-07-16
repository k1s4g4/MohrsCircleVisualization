import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class BeforeRow extends JPanel{
    private TitleLabel1 titleLabelBefore1;
    private NumberLabel1 numberLabelBefore1;
    private TitleLabel1 titleLabelBefore2;
    private NumberLabel1 numberLabelBefore2;
    public BeforeRow(String title1,double number1,String title2,double number2){
        setLayout(new FlowLayout(FlowLayout.RIGHT,27,0));
        setOpaque(false);
        setPreferredSize(new Dimension(350,31));
        titleLabelBefore1=new TitleLabel1(title1);
        numberLabelBefore1=new NumberLabel1(number1);
        titleLabelBefore2=new TitleLabel1(title2);
        numberLabelBefore2=new NumberLabel1(number2);
        add(titleLabelBefore1);
        add(numberLabelBefore1);
        add(titleLabelBefore2);
        add(numberLabelBefore2);
    }
    //================mutator methods================================
    public void setNumber1(double number){
         numberLabelBefore1.setNumber(number);    
    }
    public void setNumber2(double number){
         numberLabelBefore2.setNumber(number);    
    }
    
}
