
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.Border;
public class ChangeBoundsFrame extends JFrame{
    int width,height;
    private Mohr myMohr;
    private JPanel topPane,centerPane,bottomPane;
    private JButton cancelBtn,changeButton;
    private JTextField field;
    private JLabel notifLabel; 
    private String state;
    private mySlider slider;
    private String name;
    public ChangeBoundsFrame(mySlider slider,String name,String state,Mohr myMohr){
        this.myMohr=myMohr;
        this.state=state;
        this.slider=slider;
        this.name=name;
        setUndecorated(true);
        width=400;
        height=(int)(width/1.77);
        this.setAlwaysOnTop (true);
        Border border = BorderFactory.createBevelBorder(0,new Color(7,100,171),new Color(50,50,110));
        this.getRootPane().setBorder(border);
        setSize(width,height);
        setLocationRelativeTo(null);
        Container cp=getContentPane();
        cp.setBackground(new Color(7,100,171));
        cp.setLayout(new GridLayout(3,1,0,0));
        
        topPane=new JPanel(new GridLayout(1,1,0,0));
        topPane.setBackground(new Color(7,100,171));
        JLabel myLabel=new JLabel();
        myLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        myLabel.setForeground(new Color(255,255,255));
        myLabel.setHorizontalAlignment(SwingConstants.CENTER);
        if(state.equals("min")){
            myLabel.setText("Set Minimun value of:");
        }else{
            myLabel.setText("Set Maximun value of:");
        }
        topPane.add(myLabel);
        
        
        
        centerPane=new JPanel(new FlowLayout());
        centerPane.setBackground(new Color(7,100,171));
        JLabel label=new JLabel();
        label.setPreferredSize(new Dimension (40,40));
        label.setForeground(new Color(255,255,255));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.PLAIN, 13));
        border = BorderFactory.createBevelBorder(1,new Color(7,100,171),new Color(50,50,110));
        label.setBorder(border);
        label.setText(name);
        field=new JTextField();
        field.setPreferredSize(new Dimension (80,40));
        field.setFont(new Font("Serif", Font.PLAIN, 20));
        field.setForeground(new Color(255,255,255));
        field.setBackground(new Color(7,100,171));
        field.setCaretColor(new Color(255,255,255));
        field.setBorder(border);
        if(state.equals("min")){
            field.setText(0.01*slider.getMinimum()+"");
        }else{
            field.setText(0.01*slider.getMaximum()+"");
        }
        centerPane.add(label);
        centerPane.add(field);
        
        
        bottomPane=new JPanel();
        bottomPane.setBackground(new Color(7,100,171));
        bottomPane.setLayout(new GridLayout(2,3,5,5));
        changeButton=new JButton("Change");
        notifLabel=new JLabel();
        
        bottomPane.add(new JLabel());
        bottomPane.add(changeButton);
        bottomPane.add(new JLabel());
        bottomPane.add(new JLabel());
        bottomPane.add(notifLabel);
        bottomPane.add(new JLabel());
        
        ButtonListener btnLst=new ButtonListener();
        changeButton.addActionListener(btnLst);
        changeButton.setSize(80,20);
        changeButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        changeButton.setForeground(new Color(255,255,255));
        changeButton.setBackground(new Color(7,100,171));
        
        border = BorderFactory.createBevelBorder(0,new Color(7,100,171),new Color(50,50,110));
        changeButton.setBorder(border);
        changeButton.setPreferredSize(new Dimension (100,20));
        changeButton.setFocusPainted(false);
        
        notifLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        notifLabel.setForeground(new Color(255,255,255));
        notifLabel.setHorizontalAlignment(SwingConstants.CENTER);
        notifLabel.setVerticalAlignment(SwingConstants.TOP);
        
        
        
        cp.add(topPane);
        cp.add(centerPane);
        cp.add(bottomPane);
        setVisible(true);
    }
    public class ButtonListener implements ActionListener{
       
       public void actionPerformed(ActionEvent evt){
           String btnLabel = evt.getActionCommand();
           JButton source=(JButton)evt.getSource();
           String number=field.getText();
           boolean isNumber;
           double dnumber;
           //=======validate if isNumber=============
           try{
               dnumber=Double.parseDouble(number);
               isNumber=true;
           }catch(Exception e){
               dnumber=0;
               isNumber=false;
           }
           if(isNumber){//check if number is double
               //check ranges of number if its actual
               if(state.equals("min")){
                   int value0=(int)(dnumber*100);
                   if(value0>slider.getMaximum()){
                       double value1=slider.getMaximum()/100d;
                       notifLabel.setText("Must <max="+value1);
                   }else{
                       if(value0<0){
                           if(name.equals("<html><p style=\"padding-top:-12; font-size:22; font-family:Serif;\" >  τ  :<p>  ")){
                                slider.setMinimum(value0);
                                myMohr.setMinTau(dnumber);
                                dispose();
                           }else{
                               notifLabel.setText("Must < 0");
                           }
                       }else{
                           slider.setMinimum(value0);
                           if(name.equals("<html><p style=\"padding-top:-12; font-size:22; font-family:Serif;\" >σ<sub style=\"font-size:13;\">A</sub> :<p> ")){
                                myMohr.setMinSigmaA(dnumber);
                                dispose();
                           }else if(name.equals("<html><p style=\"padding-top:-12; font-size:22; font-family:Serif;\" >σ<sub style=\"font-size:13;\">B</sub>  :<p> ")){
                                myMohr.setMinSigmaB(dnumber);
                                dispose();
                           }else if(name.equals("<html><p style=\"padding-top:-12; font-size:22; font-family:Serif;\" >  τ  :<p>  ")){
                                myMohr.setMinTau(dnumber);
                                dispose();
                           }else{
                                myMohr.setMinCohesion(dnumber);
                                dispose();
                           }
                       }
                   }
               }else{
                   int value0=(int)(dnumber*100);
                   if(value0<slider.getMinimum()){
                       double value1=slider.getMinimum()/100d;
                       notifLabel.setText("Must >min="+value1);
                   }else{
                       if(value0<0){
                           if(name.equals("<html><p style=\"padding-top:-12; font-size:22; font-family:Serif;\" >  τ  :<p>  ")){
                                slider.setMaximum(value0);
                                myMohr.setMaxTau(dnumber);
                                dispose();
                           }else{
                               notifLabel.setText("Must > 0");
                           }
                       }else{
                           slider.setMaximum(value0);
                           if(name.equals("<html><p style=\"padding-top:-12; font-size:22; font-family:Serif;\" >σ<sub style=\"font-size:13;\">A</sub> :<p> ")){
                                myMohr.setMaxSigmaA(dnumber);
                                dispose();
                           }else if(name.equals("<html><p style=\"padding-top:-12; font-size:22; font-family:Serif;\" >σ<sub style=\"font-size:13;\">B</sub>  :<p> ")){
                                myMohr.setMaxSigmaB(dnumber);
                                dispose();
                           }else if (name.equals("<html><p style=\"padding-top:-12; font-size:22; font-family:Serif;\" >  τ  :<p>  ")){
                                myMohr.setMaxTau(dnumber);
                                dispose();
                           }else{
                                myMohr.setMaxCohesion(dnumber);
                                dispose();
                           }
                       }
                   }
               }
           }else{
               notifLabel.setText("insert numbers");
           }
       }
    }
}
