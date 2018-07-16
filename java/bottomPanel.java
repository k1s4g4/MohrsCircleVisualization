import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class bottomPanel extends JPanel{
    private myButton creditsBtn=new myButton("Reset");
    private myButton resetBtn=new myButton("Minimize");
    private myButton fullScreenBtn=new myButton("Full Screen");
    private myButton exitBtn=new myButton("Exit");
    public bottomPanel(){
         this.setLayout(new GridLayout(0,7,10,0));
         setOpaque(false);
         add(new JLabel());
         add(creditsBtn);
         add(resetBtn);
         add(fullScreenBtn);
         add(exitBtn);
         add(new JLabel());
         add(new JLabel());
         add(new JLabel());
         add(new JLabel());
         add(new JLabel());
         add(new JLabel());
         add(new JLabel());
         add(new JLabel());
         add(new SignatureLabel("<html><p style=\"padding-top:0; font-size:12; \">developed by.......K<sub>1</sub>S<sub>4</sub>G<sub>4</sub><p>"));
    }
    public myButton getCreditsBtn(){
        return creditsBtn;
    }
    public myButton getResetBtn(){
        return resetBtn;
    }
    public myButton getFullScreenBtn(){
        return fullScreenBtn;
    }
    public myButton getExitBtn(){
        return exitBtn;
    }
    
   
}
