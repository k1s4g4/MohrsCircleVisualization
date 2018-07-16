import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class InputContainer extends JPanel{
    private RowPanel row1,row2,row3;
    private BottomButton myBottom;
    public InputContainer(){
        setOpaque(true);
        setBackground(new Color(7,100,171));
        setLayout(new GridLayout(5,0,0,0));
        myBottom=new BottomButton();
        
        row1=new RowPanel("<html><p style=\"padding-top:-5; font-size:25; font-family:Serif;\" >σ<sub style=\"font-size:12;\">Α</sub><p>");
        row2=new RowPanel("<html><p style=\"padding-top:-5; font-size:25; font-family:Serif;\" >σ<sub style=\"font-size:12;\">Β</sub><p>");
        row3=new RowPanel("<html><p style=\"padding-top:-2; font-size:25; font-family:Serif;\" >τ<p>");
        add(new TopLabel());
        add(row1);
        add(row2);
        add(row3);
        add(myBottom);
    }
    public JButton getMyButton(){
        return myBottom.getButton();
    }
    public JLabel getLabel(){
        return myBottom.getErrorLabel();
    }
    public JTextField getFieldSigmaA(){
        return row1.getRowsField();
    }
    public JTextField getFieldSigmaB(){
        return row2.getRowsField();
    }
    public JTextField getFieldTau(){
        return row3.getRowsField();
    }
}
