
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
import java.lang.*;
public class InputUI extends JFrame {
    private int width,height;
    private InputContainer myInputs;
    private JButton myControl;
    private JLabel myErrorLabel;
    private JTextField textSigmaA,textSigmaB,textTau;
    public InputUI(){
        setUndecorated(true);
        width=400;
        height=(int)(1.77*width);
        
        this.setAlwaysOnTop (true);
        setSize(width,height);
        setLocationRelativeTo(null);
        Container cp=getContentPane();
        cp.setBackground(new Color(7,100,171));
        cp.setLayout(new BoxLayout(cp, BoxLayout.PAGE_AXIS));
        
        myInputs=new InputContainer();
        cp.add(new CanvasPanel());
        cp.add(myInputs);
        myControl=myInputs.getMyButton();
        myErrorLabel=myInputs.getLabel();
        textSigmaA=myInputs.getFieldSigmaA();
        textSigmaB=myInputs.getFieldSigmaB();
        textTau=myInputs.getFieldTau();
        event1 e=new event1();
        myControl.addActionListener(e);
        myErrorLabel.setForeground(new Color(255,255,255));
        myErrorLabel.setVerticalAlignment(SwingConstants.CENTER);
        myErrorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        myErrorLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        setVisible(true);
    }
    public class event1 implements ActionListener{
        private double sigmaA,sigmaB,tau;
        private String number;
        public void actionPerformed(ActionEvent evt) {
            
            boolean isNumber;
            double dnumber;
            boolean lowerThanZero=false;
            //=====================number validation===================
            try{
               number=textSigmaA.getText();
               dnumber=Double.parseDouble(number);
               if(dnumber<0){
                    lowerThanZero=true;
               }
               number=textSigmaB.getText();
               dnumber=Double.parseDouble(number);
               if(dnumber<0){
                    lowerThanZero=true;
               }
               number=textTau.getText();
               dnumber=Double.parseDouble(number);
               if(dnumber<0){
                    lowerThanZero=true;
               }
               isNumber=true;
           }catch(Exception e){
               dnumber=0;
               isNumber=false;
           }
            if(isNumber){    
               if(lowerThanZero){
                   myErrorLabel.setText("Only non-negative");
               }else{
                   number=textSigmaA.getText();
                   sigmaA=Double.parseDouble(number);
                   number=textSigmaB.getText();
                   sigmaB=Double.parseDouble(number);
                   number=textTau.getText();
                   tau=Double.parseDouble(number);
                   new MohrUI(sigmaA,sigmaB,tau);
                   dispose();
               }
               
            }else{
               myErrorLabel.setText("Please insert numbers");
               
            }
        }
    }
}

