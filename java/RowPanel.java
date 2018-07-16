import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class RowPanel extends JPanel{
    private InputLabel myLabel;
    private InputTextField myField;
    public RowPanel(String name){
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension (400,10));
        setOpaque(false);
        myLabel=new InputLabel(name);
        myField=new InputTextField();
        add(myLabel);
        add(myField);
    }
    public JTextField getRowsField(){
        return myField;
    }
}
